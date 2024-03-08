package PokemonPack;

/**
 * Represents the Research Professor trainer card, classified as a Supporter card.
 * This card allows a player to refresh their hand by discarding the current hand
 * and drawing a new one.
 */
public class ResearchProfessor extends Trainer {
	
	private static String trainerType = "Supporter";
	private static String cardName = "Research Professor";
	
	/**
	 * Constructs a Research Professor trainer card.
	 */
	public ResearchProfessor() {
		super(trainerType, cardName);
	}
	
	/**
	 * Plays the Research Professor card, causing the player to discard their hand
	 * and draw a new hand. 
	 * 
	 * @param player The player who plays the Research Professor card.
	 */
	@Override
	public void playCard(Player player) {
		// Implementation of the card's effect.
	}
}
