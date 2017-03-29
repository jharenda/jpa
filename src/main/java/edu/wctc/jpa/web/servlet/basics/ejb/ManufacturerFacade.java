package edu.wctc.jpa.web.servlet.basics.ejb;

import edu.wctc.jpa.web.servlet.basics.model.Manufacturer;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * This class is an imlementation of the AbstractFacade, typed to handle
 * Manufacturer entities. It is also a Stateless EJB Session Bean. EJBs have
 * many sophisticated features, but for this demo it's the ability to
 * auto handle JTA transactions (the EJB container does this).
 * 
 * @author jlombardo
 */
@Stateless
public class ManufacturerFacade extends AbstractFacade<Manufacturer> {
    @PersistenceContext(unitName = "sample_PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ManufacturerFacade() {
        super(Manufacturer.class);
    }
    public list<Manufacturer>findByState(String state) {
        String jpql = "Select m  from Manufacturer m wehre m.sate = ?1";
               TypedQuery<Manufacturer> q = getEntityManager().createQuery(jpql.Manufaccturer.class);
               q.setParameter(1,state);
               q.setMaxResults(10);
               return q.getResultList(); 
               
        Stringjpql = "Select m  from Manufacturer m wehre m.sate = state;       "
                + "//only diff is there
             //  q.setParameter("state,state);  
               
  TypedQuery           
             
             
    }
    
    
    /**
     * Find by state
     * @param state - the target state
     * @return all manufacturers in that state
     */
    public List<Manufacturer> findByState(String state) {
//        String jpql = "select m from Manufacturer m where m.state = ?1";
//        TypedQuery<Manufacturer> q = 
//                getEntityManager().createQuery(jpql, Manufacturer.class);
//        q.setParameter(1, state);
//        q.setMaxResults(10); // optional
//        return q.getResultList();

//        String jpql = "select m from Manufacturer m where m.state = :state";
//        TypedQuery<Manufacturer> q = 
//                getEntityManager().createQuery(jpql, Manufacturer.class);
//        q.setParameter("state", state);        
//        return q.getResultList();

        TypedQuery<Manufacturer> q = 
              getEntityManager().createNamedQuery("Manufacturer.findByState", 
                      Manufacturer.class);
        q.setParameter("state", state);
        return q.getResultList();
    }
    
    
    //https://plunchete.wordpress.com/2007/05/30/jpql-and-how-to-delete-objects-in-jpa/
    String jpql = "delete from M m where m.id = ?1"; 
           TypedQuery<Manufacturer> q = 
               getEntityManager().createQuery(jpql, Manufacturer.class);
      q.setParameter(1, id);
       q.setMaxResults(10); // optional
       return q.getResultList();
}
public void deleteById(String id) {
Manufacturer mfg = this.getEnityMananger().find(Manufacturer.class, new Integer(id));
this.getEntityManager().remove(mfg);
}

public String convertToUpper(String manufac) {

// find man by
String jpql = "Select m from Manufactuer where m.id =?1";

// scalar experssion is where clause

String converted = query.executeUpdate((UPPER(JPQL))); 



}