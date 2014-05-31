package com.runwaysdk.system.scheduler;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.runwaysdk.session.Request;
import com.runwaysdk.util.IDGenerator;

public abstract class ExecutableJob extends ExecutableJobBase implements org.quartz.Job, com.runwaysdk.system.scheduler.Job, ExecutableJobIF
{
  private static final long        serialVersionUID = 328266996;

  private Map<String, JobListener> listeners;

  public ExecutableJob()
  {
    super();

    this.listeners = new LinkedHashMap<String, JobListener>();
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.runwaysdk.business.Entity#buildKey()
   */
  @Override
  protected String buildKey()
  {
    return this.getJobId();
  }

  /**
   * 
   * @param jobListener
   */
  public void addJobListener(JobListener jobListener)
  {
    this.listeners.put(jobListener.getName(), jobListener);
  }

  /**
   * 
   * @return
   */
  public Map<String, JobListener> getJobListeners()
  {
    return this.listeners;
  }

  /**
   * Executes the Job within the context of Quartz.
   */
  @Override
  public final void execute(JobExecutionContext context) throws JobExecutionException
  {
    // the job's key is equal to the Runway id. Fetch the job
    // from the cache and pass it into the execution context
    String id = context.getJobDetail().getKey().getName();
    ExecutableJob job = ExecutableJob.get(id);

    JobHistory history = new JobHistory();

    ExecutionContext executionContext = ExecutionContext.factory(ExecutionContext.Context.EXECUTION, job, history);

    executeJob(job, job, executionContext);
  }

  /**
   * The final stage in executing the job, which invokes the execute() method
   * directly. This cannot be overridden because it follows a special error
   * handling procedure.
   * 
   * @param ej
   * @param executionContext
   */
  @Request
  static final void executeJob(ExecutableJob job, ExecutableJobIF ej, ExecutionContext executionContext)
  {
    job.lock();
    job.setStartTime(new Date());
    job.setRunning(true);
    job.setCompleted(false);
    job.apply();

    String errorMessage = null;

    try
    {
      job.execute(executionContext);
    }
    catch (Throwable t)
    {
      if (t.getCause() != null)
      {
        t = t.getCause();
      }

      errorMessage = t.getLocalizedMessage();

      if (errorMessage == null)
      {
        errorMessage = t.getMessage();
      }
    }
    finally
    {
      // Job completed
      // FIXME handle asynchronous jobs?
      job.lock();
      job.setRunning(false);
      job.setCompleted(true);
      job.setEndTime(new Date());
      job.setLastRun(job.getEndTime());
      job.apply();
    }

    JobHistory history = executionContext.getJobHistory();
    history.setJobSnapshot(createSnapshotFromJob(job));
    if (errorMessage != null)
    {
      history.getHistoryInformation().setValue(errorMessage);
    }
    history.apply();

    JobHistoryRecord rec = new JobHistoryRecord(job, history);
    rec.apply();
  }

  private static JobSnapshot createSnapshotFromJob(ExecutableJob job)
  {
    JobSnapshot snap = new JobSnapshot();
    snap.setCancelable(job.getCancelable());
    snap.setCanceled(job.getCanceled());
    snap.setCompleted(job.getCompleted());
    snap.setCronExpression(job.getCronExpression());
    snap.setEndTime(job.getEndTime());
    snap.setLastRun(job.getLastRun());
    snap.setMaxRetries(job.getMaxRetries());
    snap.setPauseable(job.getPauseable());
    snap.setPaused(job.getPaused());
    snap.setRemoveOnComplete(job.getRemoveOnComplete());
    snap.setRepeated(job.getRepeated());
    snap.setRetries(job.getRetries());
    snap.setRunning(job.getRunning());
    snap.setStartOnCreate(job.getStartOnCreate());
    snap.setStartTime(job.getStartTime());
    snap.setTimeout(job.getTimeout());
    snap.setWorkProgress(job.getWorkProgress());
    snap.setWorkTotal(job.getWorkTotal());
    snap.apply();
    
    return snap;
  }

  /**
   * Returns the duration of the last execution (end time - start time).
   * 
   * @return
   */
  public Long getDuration()
  {
    if (this.getCompleted())
    {
      return this.getEndTime().getTime() - this.getStartTime().getTime();
    }
    else
    {
      return null;
    }
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.runwaysdk.system.scheduler.ExecutableJob#execute()
   */
  @Override
  public void execute(ExecutionContext executionContext)
  {
    // do nothing by default
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.runwaysdk.system.scheduler.JobIF#getLocalizedDisplayLabel()
   */
  @Override
  public String getLocalizedDescription()
  {
    return this.getDescription().getValue();
  }

  /**
   * Ensures the state of the Job is valid for the given operation.
   */
  private void validateOperation(AllJobOperation operation)
  {
    if (!this.isAppliedToDB())
    {
      String msg = "Cannot call operation [" + operation + "] on job [" + this + "] because it is not persisted.";
      throw new JobNotPersistedException(msg, this, operation);
    }
  }

  public synchronized void start()
  {
    validateOperation(AllJobOperation.START);

    for (JobListener jobListener : this.listeners.values())
    {
      SchedulerManager.addJobListener(this, jobListener);
    }

    SchedulerManager.schedule(this);
  }

  @Request
  public void stop()
  {
    validateOperation(AllJobOperation.STOP);

    synchronized (this)
    {
      this.lock();
      this.setCanceled(true);
      this.setPaused(false);
      this.apply();
      this.unlock();
    }
  }

  @Request
  public void pause()
  {
    validateOperation(AllJobOperation.PAUSE);

    synchronized (this)
    {
      if (this.getPauseable())
      {
        this.lock();
        this.setPaused(true);
        this.setRunning(false);
        this.apply();
        this.unlock();
      }
    }
  }

  @Request
  public void resume()
  {
    validateOperation(AllJobOperation.RESUME);

    synchronized (this)
    {
      this.lock();
      this.setPaused(false);
      this.setRunning(true);
      this.apply();
      this.unlock();
    }
  }

  @Request
  public void cancel()
  {
    validateOperation(AllJobOperation.CANCEL);

    synchronized (this)
    {
      this.lock();
      this.setCanceled(true);
      this.apply();
      this.unlock();
    }
  }

  /**
   * 
   */
  @Override
  public void apply()
  {

    // If a job id is not set generate a unique id in its place.
    String jobId = this.getJobId();
    if (jobId == null || jobId.trim().length() == 0)
    {
      String id = IDGenerator.nextID();
      this.setJobId(id);
    }

    // Set the display label to the job id if one is not set already
    ExecutableJobDescription desc = this.getDescription();
    String value = desc.getDefaultValue();
    if (value == null || value.trim().length() == 0)
    {
      desc.setDefaultValue(this.getJobId());
    }

    super.apply();

    if (this.getCronExpression() != null && this.getCronExpression().length() > 0)
    {
      SchedulerManager.schedule(this, this.getCronExpression());
    }
    else
    {
      SchedulerManager.remove(this);
    }
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.runwaysdk.business.Element#delete()
   */
  @Override
  public void delete()
  {
    // Remove all scheduled jobs
    SchedulerManager.remove(this);

    super.delete();
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.runwaysdk.system.scheduler.JobBase#toString()
   */
  @Override
  public String toString()
  {
    String clazz = this.getClassDisplayLabel();
    String id = this.getJobId();
    String desc = this.getDescription().getValue();

    if (id != null && desc != null && id == desc)
    {
      return "[" + clazz + "] - " + desc;
    }
    else if (id != null && desc != null)
    {
      return "[" + clazz + "] - " + desc + " (" + id + ")";
    }
    else
    {
      return "[" + clazz + "] - " + this.getId();
    }
  }

}