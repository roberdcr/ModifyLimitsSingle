package es.unileon.ulebank.payment.service;

import es.unileon.ulebank.command.Command;
import es.unileon.ulebank.command.ModifyBuyLimitCommand;
import es.unileon.ulebank.command.ModifyCashLimitCommand;
import es.unileon.ulebank.payment.domain.Card;
import es.unileon.ulebank.payment.repository.CardDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SimpleCardManager implements CardManager {

    private static final long serialVersionUID = 1L;

    @Autowired
    private CardDao cardDao;

    public void setCardDao(CardDao cardDao) {
        this.cardDao = cardDao;
    }

	@Override
	public Card getCard() {
		return this.cardDao.getCard(1); 
	}

	@Override
	public void changeBuyLimits(double diary, double monthly) {
		Card card = this.cardDao.getCard(1);
		Command buyLimitsDiary = new ModifyBuyLimitCommand(card, diary, "diary");
		Command buyLimitsMonthly = new ModifyBuyLimitCommand(card, monthly, "monthly");
		buyLimitsMonthly.execute();
		buyLimitsDiary.execute();
		this.cardDao.saveProduct(card);
	}

	@Override
	public void changeCashLimits(double diary, double monthly) {
		Card card = this.cardDao.getCard(1);
		Command cashLimitsDiary = new ModifyCashLimitCommand(card, diary, "diary");
		Command cashLimitsMonthly = new ModifyCashLimitCommand(card, monthly, "monthly");
		cashLimitsMonthly.execute();
		cashLimitsDiary.execute();
		this.cardDao.saveProduct(card);
	}

}