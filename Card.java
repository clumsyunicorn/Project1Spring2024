package PokemonPack;

/**
 * Represents a generic card in the Pokemon TCG. This base class is extended by specific card types such as Pokemon, Energy, and Trainer cards.
 */
public class Card {
    
    private String cardName; // The name of the card
    private String cardType; // The type of the card: Pokemon, Energy, or Trainer

    /**
     * Constructor for creating a new card with specified type and name.
     * 
     * @param cardType The type of the card.
     * @param cardName The name of the card.
     */
    public Card(String cardType, String cardName) {
        this.cardType = cardType;
        this.cardName = cardName;
    }

    /**
     * Method to perform an action with the card. Intended to be overridden in subclasses.
     * 
     * @param player The player performing the action.
     */
    public void playCard(Player player) {
        // Method intended for override
    }

    /**
     * Sets the card's name.
     * 
     * @param cardName The new name of the card.
     */
    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    /**
     * Returns the card's name.
     * 
     * @return The name of the card.
     */
    public String getCardName() {
        return cardName;
    }

    /**
     * Sets the card's type.
     * 
     * @param cardType The new type of the card.
     */
    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    /**
     * Returns the card's type.
     * 
     * @return The type of the card.
     */
    public String getCardType() {
        return cardType;
    }

    /**
     * Provides a string representation of the card including its name and type.
     * 
     * @return A string representation of the card.
     */
    public String printCard() {
        return "Name: " + cardName + ", Type: " + cardType;
    }
}
