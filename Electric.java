package PokemonPack;

/**
 * Represents Electric energy, a specific type of Energy in the Pokemon game.
 * Extends the Energy class to specify Electric as its energy type.
 */
public class Electric extends Energy{
	
	private static String energyType = "Electric";
	
	/**
	 * Constructs an Electric energy card.
	 */
	public Electric() {
		super(energyType);
	}
}
