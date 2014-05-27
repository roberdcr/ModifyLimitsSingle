package es.unileon.ulebank.payment.domain;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="card") 
public class Card implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int cardNumber;
    
    @Column(name = "type")
    private String type;
    
    @Column(name = "buyLimitDiary")
    private double buyLimitDiary;
    
    @Column(name = "buyLimitMonthly")
    private double buyLimitMonthly;
    
    @Column(name = "cashLimitDiary")
	private double cashLimitDiary;
	
    @Column(name = "cashLimitMonthly")
    private double cashLimitMonthly;
    
    public String getType() {
        return type;
    }
    
    public void setType(String type) {
        this.type = type;
    }
    
    public double getBuyLimitDiary() {
        return buyLimitDiary;
    }
    
    public void setBuyLimitDiary(double buyLimitDiary) {
        this.buyLimitDiary = buyLimitDiary;
    }
    
    public double getBuyLimitMonthly() {
		return buyLimitMonthly;
	}

	public void setBuyLimitMonthly(double buyLimitMonthly) {
		this.buyLimitMonthly = buyLimitMonthly;
	}

	public double getCashLimitDiary() {
		return cashLimitDiary;
	}

	public void setCashLimitDiary(double cashLimitDiary) {
		this.cashLimitDiary = cashLimitDiary;
	}

	public double getCashLimitMonthly() {
		return cashLimitMonthly;
	}

	public void setCashLimitMonthly(double cashLimitMonthly) {
		this.cashLimitMonthly = cashLimitMonthly;
	}

	public int getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(int cardNumber) {
		this.cardNumber = cardNumber;
	}
	
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("Description: " + type + ";");
        buffer.append("Price: " + buyLimitDiary);
        return buffer.toString();
    }

}
