package PokemonPack;

/**
 * Represents Grass energy, a specific type of Energy in the Pokemon game.
 * This class extends the Energy class, specifying the energy type as Grass.
 */
public class Grass extends Energy {
	
	private static String energyType = "Grass";
	
	/**
	 * Constructs a Grass energy card.
	 */
	public Grass() {
		super(energyType);
	}
	
}
