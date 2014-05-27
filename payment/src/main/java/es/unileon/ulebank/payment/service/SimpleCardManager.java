package es.unileon.ulebank.payment.service;

import es.unileon.ulebank.command.Command;
import es.unileon.ulebank.command.ModifyBuyLimitCommand;
import es.unileon.ulebank.command.ModifyCashLimitCommand;
import es.unileon.ulebank.payment.domain.Card;

public class SimpleCardManager implements CardManager {

    private static final long serialVersionUID = 1L;

	/**
	 * Card which modifies from changeLimits.jsp
	 */
	private Card card;

	@Override
	public Card getCard() {
		return card; 
	}

	@Override
	public void changeBuyLimits(double diary, double monthly) {
		Command buyLimitsDiary = new ModifyBuyLimitCommand(this.card, diary, "diary");
		Command buyLimitsMonthly = new ModifyBuyLimitCommand(this.card, monthly, "monthly");
		buyLimitsMonthly.execute();
		buyLimitsDiary.execute();
	}

	@Override
	public void changeCashLimits(double diary, double monthly) {
		Command cashLimitsDiary = new ModifyCashLimitCommand(this.card, diary, "diary");
		Command cashLimitsMonthly = new ModifyCashLimitCommand(this.card, monthly, "monthly");
		cashLimitsMonthly.execute();
		cashLimitsDiary.execute();
	}

	public void setCard(Card card) {
		this.card = card;
	}
}