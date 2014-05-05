package com.runwaysdk.system.ontology;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.runwaysdk.business.Relationship;
import com.runwaysdk.business.ontology.Term;
import com.runwaysdk.business.ontology.TermAndRel;
import com.runwaysdk.dataaccess.MdRelationshipDAOIF;
import com.runwaysdk.dataaccess.MdTermDAOIF;
import com.runwaysdk.dataaccess.MdTermRelationshipDAOIF;
import com.runwaysdk.dataaccess.transaction.Transaction;
import com.runwaysdk.query.OIterator;

public class TermUtil extends TermUtilBase
{
  private static final long serialVersionUID = -1933843303;
  
  public TermUtil()
  {
    super();
  }
  
  /**
   * MdMethod, delegates to the ontology strategy.
   * 
   * @param termId
   * @param relationshipTypes
   * @return
   */
  public static com.runwaysdk.business.ontology.Term[] getAllAncestors(java.lang.String termId, java.lang.String[] relationshipTypes)
  {
    List<Term> terms = new ArrayList<Term>();
    Term parent = Term.get(termId);
    
    for (String relType : relationshipTypes) {
      terms.addAll(parent.getAllAncestors(relType).getAll());
    }
    
    return terms.toArray(new Term[terms.size()]);
  }
  
  /**
   * MdMethod, delegates to the ontology strategy.
   * 
   * @param termId
   * @param relationshipTypes
   * @return
   */
  public static com.runwaysdk.business.ontology.Term[] getAllDescendants(java.lang.String termId, java.lang.String[] relationshipTypes)
  {
    List<Term> terms = new ArrayList<Term>();
    Term parent = Term.get(termId);
    
    for (String relType : relationshipTypes) {
      terms.addAll(parent.getAllDescendants(relType).getAll());
    }
    
    return terms.toArray(new Term[terms.size()]);
  }
  
  /**
   * MdMethod, returns the direct ancestors of the given term, with the given relationship type. The TermAndRels are sorted by display label. 
   * 
   * @param termId
   * @param relationshipTypes
   * @return
   */
  public static com.runwaysdk.business.ontology.TermAndRel[] getDirectAncestors(java.lang.String termId, java.lang.String[] relationshipTypes)
  {
    List<TermAndRel> tnrs = new ArrayList<TermAndRel>();
    Term parent = Term.get(termId);
    
    for (String relType : relationshipTypes) {
      OIterator<? extends Relationship> parentRels = parent.getParentRelationships(relType);
      
      for (Relationship rel : parentRels) {
        tnrs.add(new TermAndRel((Term) rel.getChild(), relType, rel.getId()));
      }
    }
    
    // Sort by displayLabel
    Collections.sort(tnrs, new Comparator<TermAndRel>(){
      public int compare(TermAndRel t1, TermAndRel t2) {
        return t1.getTerm().getDisplayLabel().getValue().compareToIgnoreCase(t2.getTerm().getDisplayLabel().getValue());
      }
    });
    
    return tnrs.toArray(new TermAndRel[tnrs.size()]);
  }
  
  /**
   * MdMethod, returns the direct descendants of the given term, with the given relationship type. The TermAndRels are sorted by display label. 
   * 
   * @param termId
   * @param relationshipTypes
   * @return
   */
  public static com.runwaysdk.business.ontology.TermAndRel[] getDirectDescendants(java.lang.String termId, java.lang.String[] relationshipTypes)
  {
    List<TermAndRel> tnrs = new ArrayList<TermAndRel>();
    Term parent = Term.get(termId);
    
    for (String relType : relationshipTypes) {
      OIterator<? extends Relationship> childRels = parent.getChildRelationships(relType);
      
      for (Relationship rel : childRels) {
        tnrs.add(new TermAndRel((Term) rel.getChild(), relType, rel.getId()));
      }
    }
    
    // Sort by displayLabel
    Collections.sort(tnrs, new Comparator<TermAndRel>(){
      public int compare(TermAndRel t1, TermAndRel t2) {
        return t1.getTerm().getDisplayLabel().getValue().compareToIgnoreCase(t2.getTerm().getDisplayLabel().getValue());
      }
    });
    
    return tnrs.toArray(new TermAndRel[tnrs.size()]);
  }
  
  /**
   * MdMethod
   * 
   * @param childId
   * @param oldParentId
   * @param oldRelType
   * @param newParentId
   * @param newRelType
   * @return
   */
  @Transaction
  public static com.runwaysdk.business.Relationship addAndRemoveLink(java.lang.String childId, java.lang.String oldParentId, java.lang.String oldRelType, java.lang.String newParentId, java.lang.String newRelType)
  {
    Term child = (Term) Term.get(childId);
    Term oldParent = (Term) Term.get(oldParentId);
    Term newParent = (Term) Term.get(newParentId);
    
    return child.addAndRemoveLink(oldParent, oldRelType, newParent, newRelType);
  }
  
  /**
   * MdMethod
   * 
   * @param childId
   * @param parentId
   * @param relationshipType
   * @return
   */
  @Transaction
  public static com.runwaysdk.business.Relationship addLink(java.lang.String childId, java.lang.String parentId, java.lang.String relationshipType)
  {
    Term child = (Term) Term.get(childId);
    Term parent = (Term) Term.get(parentId);
    
    return child.addLink(parent, relationshipType);
  }
  
  /**
   * MdMethod
   * 
   * @param childId
   * @param parentId
   * @param relationshipType
   */
  @Transaction
  public static void removeLink(java.lang.String childId, java.lang.String parentId, java.lang.String relationshipType)
  {
    Term child = (Term) Term.get(childId);
    Term parent = (Term) Term.get(parentId);
    
    child.removeLink(parent, relationshipType);
  }
  
  /**
   * (Currently Server-only) convenience method, fetches all direct descendants of all valid relationship types.
   * 
   * @param termId
   * @return
   */
//  public static TermAndRel[] getDirectDescendants(String termId) {
//    return getDirectDescendants(termId, getAllParentRelationships(termId));
//  }
  
  /**
   * (Currently Server-only) convenience method, returns all relationships that this term is a valid parent in.
   * 
   * @param termId
   * @return
   */
  public static String[] getAllParentRelationships(String termId) {
    Term term = (Term) Term.get(termId);
    
    MdTermDAOIF mdTerm = term.getMdTerm();
    List<MdRelationshipDAOIF> mdRelationships = mdTerm.getAllParentMdRelationships();
    
    String[] rels = new String[mdRelationships.size()];
    
    int index = 0;
    for(MdRelationshipDAOIF mdRelationshipDAOIF : mdRelationships)
    {
      if(mdRelationshipDAOIF instanceof MdTermRelationshipDAOIF)
      {
        rels[index] = mdRelationshipDAOIF.definesType();
        index++;
      }
    }
    
    return rels;
  }
  
}
