package PokemonPack;

/**
 * Represents Water energy, a specific type of Energy within the Pokemon game.
 * This class extends the Energy class, defining the energy type as Water.
 */
public class Water extends Energy {

	private static String energyType = "Water";
	
	/**
	 * Constructs a Water energy card.
	 */
	public Water() {
		super(energyType);
	}
}
