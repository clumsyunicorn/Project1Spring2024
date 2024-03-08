package PokemonPack;

import java.util.ArrayList;
import java.util.Random;

/**
 * Represents a Pokemon card with abilities to attach energy, perform attacks, and track status effects.
 */
public class Pokemon extends Card {
	
	private static String cardType = "Pokemon";
	private ArrayList<Energy> attachedEnergy = new ArrayList<>();
	private String cardName;
	private String attackOneName;
	private String attackTwoName;
	private String energyRequired;
	private boolean isParalyzed = false;
	private int energyCount = 0;
	private int hp;
	
	/**
	 * Creates a Pokemon card with specified attacks and energy requirements.
	 * 
	 * @param cardName The name of the Pokemon.
	 * @param attackOneName The name of the first attack.
	 * @param attackTwoName The name of the second attack.
	 * @param energyRequired The type of energy required for attacks.
	 */
	public Pokemon(String cardName, String attackOneName, String attackTwoName, String energyRequired) {
		super(cardType, cardName);
		this.cardName = cardName;
		this.attackOneName = attackOneName;
		this.attackTwoName = attackTwoName;
		this.energyRequired = energyRequired;
	}
	
	/**
	 * Gets the current hit points (HP) of the Pokemon.
	 * 
	 * @return The current HP of the Pokemon.
	 */
	public int getHp() {
		return this.hp;
	}
	
	/**
	 * Sets the hit points (HP) of the Pokemon.
	 * 
	 * @param userInputHp The HP value to set.
	 */
	public void setHp(int userInputHp) {
		this.hp = userInputHp;
	}
	
	/**
	 * Gets the name of the Pokémon's first attack.
	 * 
	 * @return The name of the first attack.
	 */
	public String getAttackOneName() {
		return this.attackOneName;
	}
	
	/**
	 * Gets the name of the Pokémon's second attack.
	 * 
	 * @return The name of the second attack.
	 */
	public String getAttackTwoName() {
		return this.attackTwoName;
	}
	
	/**
	 * Gets the type of energy required for the Pokémon's attacks.
	 * 
	 * @return A string representing the required energy type.
	 */
	public String getEnergyRequired() {
		return this.energyRequired;
	}
	
	/**
	 * Sets the type of energy required for the Pokémon's attacks.
	 * 
	 * @param energyRequired A string representing the new required energy type.
	 */
	public void setEnergyRequired(String energyRequired) {
		this.energyRequired = energyRequired;
	}
	
	/**
	 * Sets the paralysis status of the Pokémon.
	 * 
	 * @param status True if the Pokémon is to be paralyzed, false otherwise.
	 */
	public void setParalyzed(boolean status) {
		this.isParalyzed = status;
	}
	
	/**
	 * Checks if the Pokémon is currently paralyzed.
	 * 
	 * @return True if the Pokémon is paralyzed, false otherwise.
	 */
	public boolean getIfParalyzed() {
		return this.isParalyzed;
	}
	
	/**
	 * Attaches an energy to the Pokemon if it matches the required energy type.
	 * 
	 * @param energy The energy to attach.
	 */
	public void attachEnergy(Energy energy) {
        if (energy.getEnergyType() == this.energyRequired) {
        	this.attachedEnergy.add(energy);
            System.out.println(energy.getEnergyType() + " energy attached to " + this.getCardName());
            this.energyCount++;
        } else {
        	System.out.println("Incorrect energy attached, " + this.energyRequired + " energy is required!");
        }
    }
	
	/**
	 * Returns a list of attached energy cards to the Pokémon.
	 * 
	 * @return An ArrayList of Energy objects attached to the Pokémon.
	 */
	public ArrayList<Energy> getAttachedEnergies() {
        return this.attachedEnergy;
    }
	
	/**
	 * Gets the count of energy cards attached to the Pokémon.
	 * 
	 * @return The number of attached energy cards.
	 */
	public int getEnergyCount() {
		return this.energyCount;
	}
	
	/**
	 * Determines if the Pokemon is knocked out.
	 * 
	 * @return True if the Pokemon's HP is 0 or less, false otherwise.
	 */
	public boolean isKnockedOut() {
		if (this.hp <= 0) {
			return true;
		}
		return false;
	}
	
	/**
	 * Prints a description of the Pokemon's attacks and energy requirements.
	 */
	public void getDesc() {
		System.out.println(this.cardName + " has two attacks:\n" + this.attackOneName + " requiring 1 " + this.energyRequired + " energy.\n" + 
	this.attackTwoName + " requiring 2 " + this.energyRequired + " energy.\n");
	}
	
	public void playCard(Pokemon target, int attackChoice) {
		
	}
	
	/**
	 * Simulates flipping a coin to support random decision making in the game.
	 * 
	 * @return True for heads, false for tails.
	 */
	public boolean flipCoin() {
		Random rng = new Random();
		int coin = rng.nextInt(2);
		if(coin == 1) {
			return true;
		}
		return false;
	}
	
}