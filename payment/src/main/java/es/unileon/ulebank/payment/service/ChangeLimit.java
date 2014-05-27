package es.unileon.ulebank.payment.service;

import javax.validation.constraints.Min;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ChangeLimit {

	 /** Logger for this class and subclasses */
    protected final Log logger = LogFactory.getLog(getClass());

    @Min(100)
    private int diaryLimit;
    
    @Min(300)
    private int monthlyLimit;

    /**
     * Setter of the diary limit
     * @param i
     */
    public void setDiaryLimit(int i) {
        diaryLimit = i;
        logger.info("Diary Limit set to " + i);
    }

    /**
     * Getter of the diary limit
     * @return
     */
    public int getDiaryLimit() {
        return diaryLimit;
    }
    
    /**
     * Setter of the monthly limit
     * @param i
     */
    public void setMonthlyLimit(int i) {
        monthlyLimit = i;
        logger.info("Monthly Limit set to " + i);
    }

    /**
     * Getter of the monthly limit
     * @return
     */
    public int getMonthlyLimit() {
        return monthlyLimit;
    }
}