package PokemonPack;

/**
 * Represents an Energy card in the Pokemon game, extending the generic Card class.
 * This class specifies the type of energy provided by the card.
 */
public class Energy extends Card {
	
	private static final String cardType = "Energy";
	private String energyType;
	
	/**
	 * Constructs an Energy card with a specified type.
	 *
	 * @param energyType The type of energy this card provides (e.g., Water, Fire, Electric).
	 */
	public Energy(String energyType) {
		super(cardType, energyType);
		this.energyType = energyType;
	}
	
	/**
	 * Returns the type of energy provided by this card.
	 *
	 * @return The energy type of this card.
	 */
	public String getEnergyType() {
		return energyType;
	}
}
