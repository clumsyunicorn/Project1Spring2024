package PokemonPack;

/**
 * Defines the capabilities for a Pokemon to perform attacks.
 * This interface requires implementing classes to define two attack methods.
 */
public interface Attackable {
    /**
     * Performs the first attack on a given target Pokemon.
     * 
     * @param target The Pokemon being targeted for the attack.
     */
    public void attackOne(Pokemon target);
    
    /**
     * Performs the second attack on a given target Pokemon.
     * 
     * @param target The Pokemon being targeted for the attack.
     */
    public void attackTwo(Pokemon target);
}
