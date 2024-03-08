package PokemonPack;

/**
 * Represents the Pokemon Bulbasaur with unique attacks and gameplay mechanics.
 * Inherits from the Pokemon class and implements the Attackable interface.
 */
public class Bulbasaur extends Pokemon implements Attackable{
	
	/**
	 * Initializes a new instance of Bulbasaur with predefined attacks and energy requirements.
	 */
	public Bulbasaur() {
		super("Bulbasaur", "Leech Seed", "Vine Whip", "Grass");
		this.setHp(70);
	}
	
	/**
	 * Executes one of Bulbasaur's attacks based on the player's choice.
	 * 
	 * @param target The Pokemon being targeted for the attack.
	 * @param attackChoice The player's chosen attack (1 or 2).
	 */
	@Override
	public void playCard(Pokemon target, int attackChoice) {
		if (attackChoice == 1) {
			attackOne(target);
		} else {
			attackTwo(target);
		}
	}
	
	/**
	 * Performs the Leech Seed attack, dealing damage and healing Bulbasaur.
	 * 
	 * @param target The Pokemon being attacked.
	 */
	@Override
	public void attackOne(Pokemon target) {

		//deal 20 damage and Heal 20.
		int currentHp = target.getHp();
		int resultHp = currentHp - 20;
		
		int thisCurrentHp = this.getHp();
		
		if (thisCurrentHp <= 50) {
			this.setHp(thisCurrentHp + 20);
		}
		
		target.setHp(resultHp);
	}
	/**
	 * Performs the Vine Whip attack, dealing damage to the target Pokemon.
	 * 
	 * @param target The Pokemon being attacked.
	 */
	@Override
	public void attackTwo(Pokemon target) {
		//deal 30 damage.
		int currentHp = target.getHp();
		int resultHp = currentHp - 30;
		
		target.setHp(resultHp);
	}
	
}
