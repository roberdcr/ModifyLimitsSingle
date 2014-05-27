package es.unileon.ulebank.payment.service;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import es.unileon.ulebank.payment.domain.Card;

public class SimpleCardManagerTests {

	 private SimpleCardManager productManager;
	    
	    private Card product;
	    
	    @Before
	    public void setUp() throws Exception {
	        productManager = new SimpleCardManager();
	        
	        product = new Card();
	        product.setType("CREDIT");
	        product.setCardNumber(1);
	        product.setBuyLimitDiary(100.00);
	        product.setBuyLimitMonthly(1000.00);
	        product.setCashLimitDiary(100.00);
	        product.setCashLimitMonthly(1000.00);

	    }

	    @Test
	    public void testGetProductsWithNoProducts() {
	        productManager = new SimpleCardManager();
	        assertNull(productManager.getCard());
	    }
	    
	    @Test
	    public void testChangeBuyLimits() {
	    	productManager.setCard(product);
	        productManager.changeBuyLimits(150.00, 1500.00);

	        assertEquals(150.00, product.getBuyLimitDiary(), 0);
	        assertEquals(1500.00, product.getBuyLimitMonthly(), 0);      
	    }
	    
	    @Test
	    public void testChangeCashLimits() {
	    	productManager.setCard(product);
	        productManager.changeCashLimits(150.00, 1500.00);

	        assertEquals(150.00, product.getCashLimitDiary(), 0);
	        assertEquals(1500.00, product.getCashLimitMonthly(), 0);      
	    }
}