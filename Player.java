package PokemonPack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Represents a player in the Pokemon game.
 * This class manages the player's deck, hand, bench, prize pile, and discard pile,
 * as well as the currently active Pokemon.
 */
public class Player {
    public ArrayList<Card> deck = new ArrayList<>();
    public ArrayList<Card> hand = new ArrayList<>();
    public ArrayList<Pokemon> bench = new ArrayList<>();
    public ArrayList<Card> prizePile = new ArrayList<>();
    public ArrayList<Card> discardPile = new ArrayList<>();
    public Pokemon active;
    public String playerName;
    
    /**
     * Constructs a new Player with a specified name.
     *
     * @param name The name of the player.
     */
    public Player(String name) {
        this.playerName = name;
    }
    
    /**
     * Returns the player's name.
     *
     * @return The name of the player.
     */
    public String getName() {
    	return playerName;
    }
    
    /**
     * Sets the player's name.
     *
     * @param name The new name for the player.
     */
    public void setName(String name) {
    	this.playerName = name;
    }
    /**
     * Generates a random deck for the player, consisting of Pokemon, Trainers, and Energy cards.
     */
    public void generateDeck() {
    	Random rng = new Random();
    	
    	//add some random Pokemon.
    	for (int i = 0; i < 20; i++) {
    		int x = rng.nextInt(3) + 1;
    		
    		switch(x) {
    		case 1:
    			this.deck.add(new Bulbasaur());
    		case 2:
    			this.deck.add(new Pikachu());
    		case 3:
    			this.deck.add(new Squirtle());
    		}
    	}
    	
    	//add some trainers.
    	for (int i = 0; i < 20; i++) {
    		int x = rng.nextInt(3) + 1;
    		
    		switch(x) {
    		case 1:
    			this.deck.add(new ResearchProfessor());
    		case 2:
    			this.deck.add(new NestBall());
    		case 3:
    			this.deck.add(new Switch());
    		}
    	}
    	
    	//add some energy
    	for (int i = 0; i < 20; i++) {
    		int x = rng.nextInt(3) + 1;
    		
    		switch(x) {
    		case 1:
    			this.deck.add(new Water());
    		case 2:
    			this.deck.add(new Electric());
    		case 3:
    			this.deck.add(new Grass());
    		}
    	}
    	
    	Collections.shuffle(this.deck);
    }
    
    /**
     * Draws the prize pile from the top of the deck.
     */
    public void drawPrizePile(){
    	if (!this.deck.isEmpty() & prizePile.isEmpty()) {
    		for (int i = 0; i < 6; i++) {
    			this.prizePile.add(this.deck.remove(this.deck.size() - 1));
    		}
    	}
    }
    /**
     * Draws a single card from the deck and adds it to the hand.
     */
    public void drawCard() {
        if (!this.deck.isEmpty()) {
        	this.hand.add(this.deck.remove(this.deck.size() - 1));
        }
    }
    /**
     * Draws seven cards from the deck to form the player's starting hand.
     */
    public void drawHand(){
    	if (!this.deck.isEmpty()) {
    		for (int i = 0; i < 7; i++) {
        		drawCard();
        	}
    	}
    }
    /**
     * Prints the current cards in the player's hand for review.
     */
    public void printHand() {
    	System.out.println(this.playerName + "'s Hand:\n");
    	int index = 0;
    	
    	for (Card card : this.hand) {
    		System.out.println("Index: " + index + "\n" + card.printCard() + "\n");
    		index++;
    	}
    }
    /**
     * Prints the current Pokemon on the player's bench for review.
     */
    public void printBench() {
    	System.out.println(this.playerName + "'s Bench:\n");
    	int index = 0;
    	
    	for (Pokemon Pokemon : this.bench) {
    		System.out.println("Index: " + index + "\n" + Pokemon.printCard() + "\n");
    		index++;
    	}
    }
    /**
     * Prepares the player for the game by generating a deck, drawing the prize pile, and drawing the starting hand.
     */
  	public void setUpPlayer(Player player) {
  		player.generateDeck();
  		player.drawPrizePile();
  		player.drawHand();
  		System.out.println("-------------------------------------------------");
  	}
    
}
