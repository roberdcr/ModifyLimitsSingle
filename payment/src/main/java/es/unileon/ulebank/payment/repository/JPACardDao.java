package es.unileon.ulebank.payment.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import es.unileon.ulebank.payment.domain.Card;

@Repository(value = "cardDao")
public class JPACardDao implements CardDao {

    private EntityManager em = null;

    /*
     * Sets the entity manager.
     */
    @PersistenceContext
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }

    @Transactional(readOnly = true)
    public Card getCard(int id) {
    	return (Card) em.createQuery("select c from Card c where id =" + id).getSingleResult();
    }

    @Transactional(readOnly = false)
    public void saveProduct(Card card) {
        em.merge(card);
    }

}
