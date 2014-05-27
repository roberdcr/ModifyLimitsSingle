package es.unileon.ulebank.command;

import org.apache.log4j.Logger;

import es.unileon.ulebank.payment.domain.Card;


/**
 * @author Israel
 */
public class ModifyCashLimitCommand implements Command {
	/**
	 * Logger de la clase
	 */
	private static final Logger LOG = Logger.getLogger(ModifyCashLimitCommand.class.getName());

	/**
	 * Objeto tarjeta cuyos limites se van a modificar
	 */
	private Card card;
	/**
	 * Nueva cantidad a modificar
	 */
	private double newAmount;

	/**
	 * Tipo de limite a modificar (diario o mensual)
	 */
	private String type;

	/**
	 * Constructor de la clase
	 * @param cardId
	 * @param office
	 * @param dni
	 * @param accountHandler
	 * @param amount
	 * @param type
	 * @throws AccountNotFoundException 
	 */
	public ModifyCashLimitCommand(Card card, double amount, String type) {
		try {
			this.card = card;
			this.newAmount = amount;
			this.type = type;
		} catch (NullPointerException e) {
			LOG.info(e.getMessage());
		}
	}

	/**
	 * Realiza la modificacion del limite de extraccion en cajero ya sea diario o mensual
	 * @throws CardNotFoundException 
	 * @throws IncorrectLimitException 
	 */
	@Override
	public void execute() {
		//Buscamos la tarjeta con el identificador de la misma en la lista de tarjetas de la cuenta
		try {			
			//Si el limite a modificar es diario
			if (type.equalsIgnoreCase("diary")) {
				//Cambiamos el limite por el indicado
				this.card.setCashLimitDiary(newAmount);
				//Si el limite a modificar es mensual
			} else if (type.equalsIgnoreCase("monthly")) {
				//Cambiamos el limite por el indicado
				this.card.setCashLimitMonthly(newAmount);
				//Si no se indica el tipo de limite a modificar adecuadamente no va a realizar la operacion
			} else {
				LOG.info("Limit type not defined");
			}
		} catch (NullPointerException e) {
			LOG.info(e.getMessage());
		}
	}

}
