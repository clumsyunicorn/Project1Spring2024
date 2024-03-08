package PokemonPack;

/**
 * Represents a Trainer card in the Pokemon game, extending the generic Card class.
 * Trainer cards provide various effects and advantages when played in the game.
 */
public class Trainer extends Card {
    
    private static final String cardType = "Trainer";
    private String trainerType;
    
    /**
     * Constructs a Trainer card with a specified type and name.
     *
     * @param trainerType The specific type of Trainer card (e.g., Supporter, Item).
     * @param cardName The name of the Trainer card.
     */
    public Trainer(String trainerType, String cardName) {
        super(cardType, cardName);
        this.trainerType = trainerType;
    }
    
    /**
     * Returns the type of the Trainer card.
     *
     * @return The Trainer card's type.
     */
    public String getTrainerType() {
        return trainerType;
    }
    
    /**
     * Sets the type of the Trainer card.
     *
     * @param trainerType The new type for the Trainer card.
     */
    public void setTrainerType(String trainerType) {
        this.trainerType = trainerType;
    }
}
