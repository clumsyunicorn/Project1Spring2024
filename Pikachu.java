package PokemonPack;

/**
 * Represents the Pokemon Pikachu, equipped with electric attacks.
 * Inherits from Pokemon and implements the Attackable interface.
 */
public class Pikachu extends Pokemon implements Attackable{
    
    /**
     * Constructs a Pikachu with specific attacks and energy requirements.
     */
    public Pikachu() {
        super("Pikachu", "Quick Attack", "Electro Ball", "Electric");
        this.setHp(70);
    }
	
    /**
     * Executes one of Pikachu's attacks based on the player's choice.
     * 
     * @param target The Pokemon being targeted for the attack.
     * @param attackChoice The player's chosen attack (1 for Quick Attack, 2 for Electro Ball).
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
     * Performs Quick Attack, dealing minor damage to the target Pokemon.
     * 
     * @param unfortunatePokemon The Pokemon receiving the attack.
     */
	public void attackOne(Pokemon unfortunatePokemon) {
    	//deal 10 damage.
		int currentHp = unfortunatePokemon.getHp();
		int resultHp = currentHp - 10;
		unfortunatePokemon.setHp(resultHp);
	}
    
    /**
     * Performs Electro Ball, dealing significant damage to the target Pokemon.
     * 
     * @param unfortunatePokemon The Pokemon receiving the attack.
     */
    @Override
	public void attackTwo(Pokemon unfortunatePokemon) {
    	//deal 60 damage.
		int currentHp = unfortunatePokemon.getHp();
		int resultHp = currentHp - 60;
		unfortunatePokemon.setHp(resultHp);
	}
    
}
