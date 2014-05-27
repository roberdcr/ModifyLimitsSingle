package es.unileon.ulebank.payment.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import es.unileon.ulebank.payment.domain.Card;

/**
 * Clase para el acceso a la BBDD
 * @author Rober dCR
 * @date 27/05/2014
 * @brief Clase que implementa los métodos de la interface CardDao para la lectura/escritura
 * de las tarjetas en la base de datos
 */
@Repository(value = "cardDao") //permite creacion automatica de beans de acceso a datos 
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
