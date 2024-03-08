package PokemonPack;

/**
 * Represents the Pokemon Squirtle, known for its water-based attacks.
 * Inherits from Pokemon and implements the Attackable interface.
 */
public class Squirtle extends Pokemon implements Attackable {
    
    /**
     * Constructs a Squirtle with specific attacks and energy requirements.
     */
    public Squirtle() {
        super("Squirtle", "Bubble", "Water Gun", "Water");
        setHp(50);
    }
    
    /**
     * Executes one of Squirtle's attacks based on the player's choice.
     * 
     * @param target The Pokemon being targeted for the attack.
     * @param attackChoice The player's chosen attack (1 for Bubble, 2 for Water Gun).
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
     * Performs the Bubble attack, potentially paralyzing the target Pokemon.
     * 
     * @param target The Pokemon being attacked.
     */
    @Override
    public void attackOne(Pokemon target) {
        if(flipCoin()) {
            target.setParalyzed(true);
            System.out.println("Opponent's Pokemon has been paralyzed for 1 turn.");
        }
    }

    /**
     * Performs the Water Gun attack, dealing damage to the target Pokemon.
     * 
     * @param target The Pokemon being attacked.
     */
    @Override
    public void attackTwo(Pokemon target) {
        // Deal 20 damage.
        int currentHp = target.getHp();
        int resultHp = currentHp - 20;
        target.setHp(resultHp);
    }
}
