package es.unileon.ulebank.command;

import org.apache.log4j.Logger;

import es.unileon.ulebank.payment.domain.Card;


/**
 * @author Israel
 */
public class ModifyBuyLimitCommand implements Command {
	/**
	 * Logger de la clase
	 */
	private static final Logger LOG = Logger.getLogger(ModifyBuyLimitCommand.class.getName());

	/**
	 * Objeto tarjeta del que se modificaran los datos
	 */
	private Card card;
	/**
	 * Cantidad nueva a modificar
	 */
	private double newAmount;

	/**
	 * Tipo de limite a modificar (diario o mensual)
	 */
	private String type;
	
	/**
	 * Constructor de la clase
	 * @param cardId
	 * @param card
	 * @param amount
	 * @param type
	 * @throws AccountNotFoundException 
	 */
	public ModifyBuyLimitCommand(Card card, double amount, String type) {
		try {
			this.card = card;
			this.newAmount = amount;
			this.type = type;
		} catch (NullPointerException e) {
			LOG.info(e.getMessage());
		}
	}
	
	/**
	 * Realiza la modificacion del limite de compra ya sea diario o mensual
	 * @throws CardNotFoundException 
	 */
	@Override
	public void execute() {
		//Buscamos la tarjeta con el identificador de la misma en la lista de tarjetas de la cuenta
		try {
			//Si el limite a modificar es diario
			if (type.equalsIgnoreCase("diary")) {
				//Cambiamos el limite por el indicado
				this.card.setBuyLimitDiary(newAmount);
			//Si el limite a modificar es mensual
			} else if (type.equalsIgnoreCase("monthly")) {
				//Cambiamos el limite por el indicado
				this.card.setBuyLimitMonthly(newAmount);
			//Si no se indica el tipo de limite a modificar adecuadamente no va a realizar la operacion
			} else {
				LOG.info("Limit type not defined");
			}
		} catch (NullPointerException e) {
			LOG.info(e.getMessage());
		} 
	}

}
