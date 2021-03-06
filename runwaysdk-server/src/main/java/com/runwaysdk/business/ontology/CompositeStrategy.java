package com.runwaysdk.business.ontology;

import com.runwaysdk.query.OIterator;

public class CompositeStrategy implements OntologyStrategyIF
{
  private OntologyStrategyIF[] strategies;

  public CompositeStrategy(OntologyStrategyIF... strategies)
  {
    this.strategies = strategies;
  }

  @Override
  public boolean isInitialized()
  {
    boolean initialized = true;

    for (OntologyStrategyIF strategy : strategies)
    {
      initialized = initialized && strategy.isInitialized();
    }

    return initialized;
  }

  @Override
  public void initialize(String relationshipType)
  {
    for (OntologyStrategyIF strategy : strategies)
    {
      strategy.initialize(relationshipType);
    }
  }

  @Override
  public void shutdown()
  {
    for (OntologyStrategyIF strategy : strategies)
    {
      strategy.shutdown();
    }
  }

  @Override
  public void reinitialize(String relationshipType)
  {
    for (OntologyStrategyIF strategy : strategies)
    {
      strategy.reinitialize(relationshipType);
    }
  }

  @Override
  public void addLink(Term parent, Term child, String relationshipType)
  {
    for (OntologyStrategyIF strategy : strategies)
    {
      strategy.addLink(parent, child, relationshipType);
    }
  }

  @Override
  public boolean isLeaf(Term term, String relationshipType)
  {
    for (OntologyStrategyIF strategy : strategies)
    {
      return strategy.isLeaf(term, relationshipType);
    }

    return false;
  }

  @Override
  public OIterator<Term> getAllAncestors(Term term, String relationshipType)
  {
    for (OntologyStrategyIF strategy : strategies)
    {
      OIterator<Term> it = strategy.getAllAncestors(term, relationshipType);

      if (it != null)
      {
        return it;
      }
    }

    return null;
  }

  @Override
  public OIterator<Term> getAllDescendants(Term term, String relationshipType)
  {
    for (OntologyStrategyIF strategy : strategies)
    {
      OIterator<Term> it = strategy.getAllDescendants(term, relationshipType);

      if (it != null)
      {
        return it;
      }
    }

    return null;
  }

  @Override
  public OIterator<Term> getDirectAncestors(Term term, String relationshipType)
  {
    for (OntologyStrategyIF strategy : strategies)
    {
      OIterator<Term> it = strategy.getDirectAncestors(term, relationshipType);

      if (it != null)
      {
        return it;
      }
    }

    return null;
  }

  @Override
  public OIterator<Term> getDirectDescendants(Term term, String relationshipType)
  {
    for (OntologyStrategyIF strategy : strategies)
    {
      OIterator<Term> it = strategy.getDirectDescendants(term, relationshipType);

      if (it != null)
      {
        return it;
      }
    }

    return null;
  }

  @Override
  public void add(Term term, String relationshipType)
  {
    for (OntologyStrategyIF strategy : strategies)
    {
      strategy.add(term, relationshipType);
    }
  }

  @Override
  public void removeTerm(Term term, String relationshipType)
  {
    for (OntologyStrategyIF strategy : strategies)
    {
      strategy.removeTerm(term, relationshipType);
    }
  }

  @Override
  public void removeLink(Term parent, Term term, String relationshipType)
  {
    for (OntologyStrategyIF strategy : strategies)
    {
      strategy.removeLink(parent, term, relationshipType);
    }
  }

  @Override
  public void configure(String termClass)
  {
    for (OntologyStrategyIF strategy : strategies)
    {
      strategy.configure(termClass);
    }
  }

  @Override
  public DeleteStrategyProviderIF getDeleteStrategyProvider(Term deleteRoot, String relationshipType)
  {
    for (OntologyStrategyIF strategy : strategies)
    {
      DeleteStrategyProviderIF provider = strategy.getDeleteStrategyProvider(deleteRoot, relationshipType);

      if (provider != null)
      {
        return provider;
      }
    }

    return null;
  }

  @Override
  public void addSynonym(Term term, OntologyEntryIF synonym)
  {
    for (OntologyStrategyIF strategy : strategies)
    {
      strategy.addSynonym(term, synonym);
    }
  }

  @Override
  public void updateSynonym(OntologyEntryIF synonym)
  {
    for (OntologyStrategyIF strategy : strategies)
    {
      strategy.updateSynonym(synonym);
    }
  }

  @Override
  public void removeSynonym(OntologyEntryIF synonym)
  {
    for (OntologyStrategyIF strategy : strategies)
    {
      strategy.removeSynonym(synonym);
    }
  }

  @Override
  public void updateLabel(Term term, String label)
  {
    for (OntologyStrategyIF strategy : strategies)
    {
      strategy.updateLabel(term, label);
    }
  }

}
