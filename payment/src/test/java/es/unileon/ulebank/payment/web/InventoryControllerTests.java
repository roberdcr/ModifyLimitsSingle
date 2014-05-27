package es.unileon.ulebank.payment.web;

import java.util.Map;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import es.unileon.ulebank.payment.service.SimpleCardManager;

public class InventoryControllerTests {

    @Test
    public void testHandleRequestView() throws Exception{		
        InventoryController controller = new InventoryController();
        controller.setProductManager(new SimpleCardManager());
        ModelAndView modelAndView = controller.handleRequest(null, null);		
        assertEquals("changeLimits", modelAndView.getViewName());
        assertNotNull(modelAndView.getModel());
	@SuppressWarnings("unchecked")
        Map<String, Object> modelMap = (Map<String, Object>) modelAndView.getModel().get("model");
        String nowValue = (String) modelMap.get("now");
        assertNotNull(nowValue);
    }
}