package es.unileon.ulebank.payment.repository;

import es.unileon.ulebank.payment.domain.Card;

public class InMemoryProductDao implements CardDao {

    private Card productList;

    public InMemoryProductDao(Card productList) {
        this.productList = productList;
    }
    
	@Override
	public Card getCard(int id) {
		// TODO Auto-generated method stub
		return this.productList;
	}

	@Override
	public void saveProduct(Card card) {
		// TODO Auto-generated method stub
		
	}



}