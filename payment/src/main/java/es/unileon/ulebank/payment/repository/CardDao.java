package es.unileon.ulebank.payment.repository;

import es.unileon.ulebank.payment.domain.Card;

/**
 * Interfaz para el acceso al contenido de la BBDD
 * @author Rober dCR
 * @date 27/05/2014
 * @brief  interface que definira la funcionalidad de la implementacion DAO
 */
public interface CardDao {

    public Card getCard(int id);

    public void saveProduct(Card card);

}
