package es.unileon.ulebank.payment.repository;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import es.unileon.ulebank.payment.domain.Card;


public class JPAProductDaoTests {

    private ApplicationContext context;
    private CardDao cardDao;

    @Before
    public void setUp() throws Exception {
        context = new ClassPathXmlApplicationContext("classpath:test-context.xml");
        cardDao = (CardDao) context.getBean("cardDao");
    }

    @Test
    public void testGetCard() {
        Card product = cardDao.getCard(1);
        assertEquals(product.getCardNumber(), 1, 0);	   
    }

    @Test
    public void testSaveCard() {

        Card card = cardDao.getCard(1);
        card.setCashLimitMonthly(2000.00);
        
        cardDao.saveProduct(card);

        Card card2 = cardDao.getCard(1);
        assertEquals(card2.getCashLimitMonthly(), 2000.00, 0.01);

    }
}
