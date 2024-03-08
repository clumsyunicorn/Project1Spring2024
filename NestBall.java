package PokemonPack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Represents the Nest Ball trainer card, a Supporter card allowing the player
 * to add a Pokemon from their deck to their bench.
 */
public class NestBall extends Trainer{
    
    private static String trainerType = "Supporter";
    private static String cardName = "Nest Ball";
    
    /**
     * Constructs a Nest Ball trainer card.
     */
    public NestBall() {
        super(trainerType, cardName);
    }
    
    /**
     * Executes the effect of the Nest Ball card, adding a Pokemon from the player's deck
     * to their bench. Player interaction via the scanner is required to select the Pokemon.
     * 
     * @param player The player executing the card's effect.
     */
    @Override
    public void playCard(Player player) {
        System.out.println("Select a Pokémon from your deck to add to your bench:");
        Scanner scanner = new Scanner(System.in);
        ArrayList<Pokemon> temp = new ArrayList<>();
        int index = 0;
        for (Card card : player.deck) {
            if(card.getCardType() == "Pokemon") {
                temp.add((Pokemon)card);
                System.out.println("Index: " + index + card.printCard());
                index++;
            }
        }
        
        System.out.println("Input index ->");
        index = scanner.nextInt();
        
        player.bench.add(temp.get(index));
        
        System.out.println(temp.get(index).getCardName() + " added to the bench!");
        
        Collections.shuffle(player.deck);
    }
}
