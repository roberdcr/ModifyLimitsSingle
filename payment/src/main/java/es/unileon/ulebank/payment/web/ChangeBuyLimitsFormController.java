package es.unileon.ulebank.payment.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.security.auth.login.AccountNotFoundException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import es.unileon.ulebank.payment.service.CardManager;
import es.unileon.ulebank.payment.service.ChangeLimit;

/**
 * Class Controller of the page buyLimits.jsp
 * @author Rober dCR
 * @date 10/5/2014
 * @brief Concrete controller of buyLimits.jsp which change the buy limits of the card in.
 */
@Controller
@RequestMapping(value="/buyLimits.htm")
public class ChangeBuyLimitsFormController {

    /** Logger for this class and subclasses */
    protected final Log logger = LogFactory.getLog(getClass());

    /**
     * Card which change the limits in
     */
    @Autowired
    private CardManager productManager;

    /**
     * Method that obtains the data of the form in buyLimits.jsp and save the changes in the card
     * @param changeLimit
     * @param result
     * @return
     * @throws IncorrectLimitException
     * @throws AccountNotFoundException 
     * @throws CardNotFoundException 
     * @throws TransactionException 
     * @throws PaymentException 
     */
    @RequestMapping(method = RequestMethod.POST)
    public String onSubmit(@Valid ChangeLimit changeLimit, BindingResult result) {
        if (result.hasErrors()) {
            return "buyLimits";
        }
		
        int diaryLimit = (int) changeLimit.getDiaryLimit();
        int monthlyLimit = (int) changeLimit.getMonthlyLimit();
        logger.info("Modified diary limit: " + diaryLimit + "�.");
        logger.info("Modified monthly limit: " + monthlyLimit + "�.");

        productManager.changeBuyLimits(diaryLimit, monthlyLimit);

        return "redirect:/changeLimits.htm";
    }

    /**
     * Method that sends the data of the card's buy limits to the form in buyLimits.jsp
     * @param request
     * @return
     * @throws ServletException
     */
    @RequestMapping(method = RequestMethod.GET)
    protected ChangeLimit formBackingObject(HttpServletRequest request) throws ServletException {
        ChangeLimit changeLimit = new ChangeLimit();
        changeLimit.setDiaryLimit( (int) this.productManager.getCard().getBuyLimitDiary());
        changeLimit.setMonthlyLimit( (int) this.productManager.getCard().getBuyLimitMonthly());
        return changeLimit;
    }

    /**
     * Setter of the card
     * @param productManager
     */
    public void setProductManager(CardManager productManager) {
        this.productManager = productManager;
    }

    /**
     * Getter of the card
     * @return card
     */
    public CardManager getProductManager() {
        return productManager;
    }

}