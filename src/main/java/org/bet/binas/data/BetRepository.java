/**
 * 
 */
package org.bet.binas.data;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.bet.binas.model.Betlist;

/**
 * @author Joao
 *
 */

@ApplicationScoped
public class BetRepository {

    @Inject
    private EntityManager em;

//    public User findById(Long id) {
//        return em.find(User.class, id);
//    }
//
//    public User findByEmail(String email) {
//        CriteriaBuilder cb = em.getCriteriaBuilder();
//        CriteriaQuery<User> criteria = cb.createQuery(User.class);
//        Root<User> user = criteria.from(User.class);
//        // Swap criteria statements if you would like to try out type-safe criteria queries, a new
//        // feature in JPA 2.0
//        // criteria.select(user).where(cb.equal(user.get(User_.name), email));
//        criteria.select(user).where(cb.equal(user.get("email"), email));
//        return em.createQuery(criteria).getSingleResult();
//    }
//
//    public List<Betlist> findAllOrderedByName() {
//        CriteriaBuilder cb = em.getCriteriaBuilder();
//        CriteriaQuery<Betlist> criteria = cb.createQuery(Betlist.class);
//        Root<Betlist> betlist = criteria.from(Betlist.class);
//        // Swap criteria statements if you would like to try out type-safe criteria queries, a new
//        // feature in JPA 2.0
//        // criteria.select(user).orderBy(cb.asc(user.get(User_.name)));
//        criteria.select(betlist).orderBy(cb.asc(betlist.get("betname")));
//        return em.createQuery(criteria).getResultList();
//    }
}