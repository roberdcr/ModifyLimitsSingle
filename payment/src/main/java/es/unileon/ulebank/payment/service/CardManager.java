package es.unileon.ulebank.payment.service;

import java.io.Serializable;

import es.unileon.ulebank.payment.domain.Card;

/**
 * Card Manager Interface
 * @author Rober dCR
 * @date 10/05/2014
 * @brief Interface for the managers used to modify card attributes
 */
public interface CardManager extends Serializable {

	/**
	 * Method that changes the cash limits using the command with the limits from buyLimits.jsp
	 * @param diary
	 * @param monthly
	 */
	public void changeCashLimits(double diary, double monthly);

	/**
	 * Method that changes the buy limits using the command with the limits from buyLimits.jsp
	 * @param diary
	 * @param monthly
	 */
	public void changeBuyLimits(double diary, double monthly);

	/**
     * Method that returns the card of the management
     * @return
     */
	public Card getCard();

}
