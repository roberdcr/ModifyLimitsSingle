package es.unileon.ulebank.payment.domain;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CardTests {

    private Card card;

    @Before
    public void setUp() throws Exception {
        card = new Card();
    }

    @Test
    public void testSetAndGetDescription() {
        String testType = "aDescription";
        assertNull(card.getType());
        card.setType(testType);
        assertEquals(testType, card.getType());
    }

    @Test
    public void testSetAndGetBuyLimitDiary() {
        double buyLimitDiary = 100.00;
        assertEquals(0, 0, 0);    
        card.setBuyLimitDiary(buyLimitDiary);
        assertEquals(buyLimitDiary, card.getBuyLimitDiary(), 0);
    }
    
    @Test
    public void testSetAndGetBuyLimitMonthly() {
        double buyLimitMonthly = 100.00;
        assertEquals(0, 0, 0);    
        card.setBuyLimitMonthly(buyLimitMonthly);
        assertEquals(buyLimitMonthly, card.getBuyLimitMonthly(), 0);
    }
    
    @Test
    public void testSetAndGetCashLimitDiary() {
        double cashLimitDiary = 100.00;
        assertEquals(0, 0, 0);    
        card.setCashLimitDiary(cashLimitDiary);
        assertEquals(cashLimitDiary, card.getCashLimitDiary(), 0);
    }
    
    @Test
    public void testSetAndGetCashLimitMonthly() {
        double cashLimitMonthly = 100.00;
        assertEquals(0, 0, 0);    
        card.setCashLimitMonthly(cashLimitMonthly);
        assertEquals(cashLimitMonthly, card.getCashLimitMonthly(), 0);
    }

}