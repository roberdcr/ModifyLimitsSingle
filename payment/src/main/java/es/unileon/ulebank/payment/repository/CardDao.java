package es.unileon.ulebank.payment.repository;

import es.unileon.ulebank.payment.domain.Card;

public interface CardDao {

    public Card getCard(int id);

    public void saveProduct(Card card);

}
