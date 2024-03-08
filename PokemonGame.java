package PokemonPack;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Manages the flow of the Pokemon game, including player setup, turn mechanics,
 * and win conditions.
 */
public class PokemonGame {
    
    // Define the players.
    private Player player1;
    private Player player2;
    
    // Scanner object for user input.
    private Scanner scanner;
    
    /**
     * General constructor for the Pokemon game.
     */
    public PokemonGame() {
        // Instantiate the players.
        this.player1 = new Player("Player 1");
        this.player2 = new Player("Player 2");
        this.scanner = new Scanner(System.in);
    }
    
    /**
     * Constructor for the Pokemon game with specified player names.
     * 
     * @param player1Name The name of the first player.
     * @param player2Name The name of the second player.
     */
    public PokemonGame(String player1Name, String player2Name) {
        // Instantiate the players with specified names.
        this.player1 = new Player(player1Name);
        this.player2 = new Player(player2Name);
        this.scanner = new Scanner(System.in);
    }
    
    /**
     * Set up the players' decks and select active Pokemon for each player.
     * 
     * @param player The player to set up.
     */
    public void setUp(Player player) {
        player.setUpPlayer(player);
        
        System.out.println("Select your active Pokemon.");
        
        player.active = (Pokemon)(pickCard(player, "Pokemon"));
        player.hand.remove(player.active);
        player.active.getDesc();
    }
    
    /**
     * Simulate the game until one player's prize pile is empty.
     */
    public void runGame() {
        System.out.println("<Begin Game>");
        instructions();
        setUp(player1);
        setUp(player2);
                
        while(!checkWinner()) {
            player1.drawCard();
            playerTurn(player1, player2);
            if(checkWinner()) {
                break;
            } else {
                player2.drawCard();
                playerTurn(player2, player1);
            }
        }
        
    }
    
    /**
     * Execute a player's turn, including actions like attacking, playing cards, and switching Pokemon.
     * 
     * @param attacker The player whose turn it is.
     * @param victim The opponent player.
     */
    public void playerTurn(Player attacker, Player victim) {
		boolean turnContinue = true;
		int index = 0;
		int playCount = 0;
		
		//print the current game state for the players review.
		System.out.println(attacker.getName() + "'s turn!\n");
		System.out.println("-------------------------------------------------");
		
		while(turnContinue) {
			System.out.println("-------------------------------------------------");
			if (attacker.active != null) {
				System.out.println("Active Pokemon:\n" + attacker.active.printCard());
			}
			System.out.println("\nWould you like to:\n" + "1)Attack.\n" + "2)Play a Trainer.\n" + "3)Change Active Pokemon.\n" + 
			"4)Attach Energy.\n" + "5)Add Pokemon to bench.\n" + "6)Print " + attacker.getName() + "'s hand & bench.\n" + "7)Finish turn.\n" + "Indicate index ->");
			
			index = scanner.nextInt();
			
			switch(index) {
			case 1:
				if(checkParalyzed(attacker.active)) {
					break;
				} else if (attacker.active == null) {
					System.out.println("You must choose an active pokemon from your bench!");
					break;
				}
				attack(attacker, victim);
				turnContinue = false;
				break;
			case 2:
				if (!hasCardType(attacker, "Trainer")) {
					break;
				}
				useTrainerCard(attacker);
				break;
			case 3:
				if (attacker.bench.isEmpty()) {
					System.out.println("Bench is empty!");
					break;
				}
				changeActivePokemon(attacker);
				attacker.active.getDesc();
				turnContinue = false;
				break;
			case 4:
				if (playCount > 0) {
					System.out.println("You can only attach 1 energy!");
					break;
				} else if (!hasCardType(attacker, "Energy")) {
					break;
				}
				useEnergyCard(attacker);
				playCount++;
				break;
			case 5:
				if (!hasCardType(attacker, "Pokemon")) {
					break;
				}
				addPokemonToBench(attacker);
				break;
			case 6:
				attacker.printHand();
				attacker.printBench();
				break;
			case 7:
				turnContinue = false;
			default:
				System.out.println("Invalid response. Try again.");
			}
		}
		
	}
	
    /**
     * Checks if the player has a card of the specified type in their hand.
     * 
     * @param player The player whose hand is being checked.
     * @param type The type of card being searched for.
     * @return true if the player has a card of the specified type, false otherwise.
     */
    public boolean hasCardType(Player player, String type) {
        boolean good = false;
        for (Card card : player.hand) {
            if(card.getCardType().equals(type)) {
                good = true;
                break;
            }
        }
        
        if (!good) {
            System.out.println("There are no " + type + " cards. Choose another option.");
        } 
        
        return good;
    }

    /**
     * Allows the player to pick a card of the specified type from their hand.
     * 
     * @param player The player picking the card.
     * @param type The type of card to pick (e.g., "Pokemon", "Energy").
     * @return The card chosen by the player.
     */
    public Card pickCard(Player player, String type) {
        Card temp = null;
        
        System.out.println("Choose a " + type + " card from your hand:\n");
        player.printHand();
        System.out.println("Indicate index ->");
        
        int index = scanner.nextInt();
        temp = player.hand.get(index);
        if (!temp.getCardType().equals(type)) {
            System.out.println("Wrong card type. Try Again.");
            temp = pickCard(player, type);
        }
        
        return temp;
    }

    /**
     * Allows the player to add Pokemon to their bench from their hand.
     * 
     * @param player The player adding Pokemon to their bench.
     */
    public void addPokemonToBench(Player player) {
        boolean good = false;
        
        while (!good) {
            if (player.bench.size() < 5) {
                player.bench.add((Pokemon) pickCard(player, "Pokemon"));
                player.printBench();
                System.out.println("Add another Pokemon? (1 = Yes, 0 = No)");
                int index = scanner.nextInt();
                
                if (index > 0) {
                    addPokemonToBench(player);
                }
            } else {
                System.out.println("You have 5 Pokemon on your bench! (max)");
                good = true;
            }
            good = true;
        }
    }

    /**
     * Allows the player to use an energy card from their hand.
     * 
     * @param player The player using the energy card.
     */
    public void useEnergyCard(Player player) {
        Card temp = pickCard(player, "Energy");
        Energy tempEnergy = (Energy) temp;
        player.active.attachEnergy(tempEnergy);
        player.hand.remove(temp);
    }

    /**
     * Allows the player to use a trainer card from their hand.
     * 
     * @param player The player using the trainer card.
     */
    public void useTrainerCard(Player player) {
        Card temp = pickCard(player, "Trainer");
        Trainer tempTrainer = (Trainer) temp;
        tempTrainer.playCard(player);
        player.hand.remove(temp);
        player.discardPile.add(temp);
    }
	
    /**
     * Allows the player to change their active Pokemon from their bench.
     * 
     * @param player The player making the change.
     */
    public void changeActivePokemon(Player player) {
        boolean good = false;
        
        while (!good) {
            System.out.println("Select a new active Pokemon from your bench.");
            player.printBench();
            System.out.println("Indicate Index ->");
            int index = scanner.nextInt();
            if (index >= 0 && index < player.bench.size()) {
                Pokemon temp = player.bench.get(index);
                player.bench.add(player.active); 
                player.active = temp; 
                player.bench.remove(temp); 
                System.out.println(temp.getCardName() + " is now active.");
                good = true;
            } else {
                System.out.println("Invalid index. Try again.");
            }
        }
    }

    /**
     * Allows the attacking player to perform an attack on the opponent's Pokemon.
     * 
     * @param attacker The player initiating the attack.
     * @param victim The player whose Pokemon is being attacked.
     */
    public void attack(Player attacker, Player victim) {    
        boolean good = false;
        Pokemon temp = attacker.active;
        int energyCount = temp.getEnergyCount();
        int index;
        
        while (!good) {
            System.out.println("Would you like to use\n1)" + temp.getAttackOneName() + "\n" + 
                    "2)" + temp.getAttackTwoName() + "\n" + "3)" + "Select different Option");
            System.out.println("Indicate Index ->");
            index = scanner.nextInt();
            
            switch (index) {
                case 1:
                    if (energyCount >= 1) {
                        temp.playCard(victim.active, index);
                        good = true;
                    } else {
                        System.out.println("You don't have enough energy for " + temp.getAttackOneName() + ".");
                    }
                    break;
                case 2:
                    if (energyCount == 2) {
                        temp.playCard(victim.active, index);
                        good = true;
                    } else {
                        System.out.println("You don't have enough energy for " + temp.getAttackTwoName() + ".");
                    }
                    break;
                case 3:
                    playerTurn(attacker, victim);
                    return;
                default:
                    System.out.println("Invalid index. Try again.");
            } 
            
        }
        
        System.out.println(temp.getCardName() + " has attacked " + victim.active.getCardName() + ".\n"
                + temp.getCardName() + " New HP = " + temp.getHp() + "\n" + victim.active.getCardName()
                + " New HP = " + victim.active.getHp() + "\n");
        
        if (checkKO(victim)) {
            System.out.println(victim.getName() + "'s Pokemon has been KO'd!");
            if (!attacker.prizePile.isEmpty()) {
                attacker.hand.add(attacker.prizePile.remove(attacker.prizePile.size() - 1));
            }
        }
    }

    /**
     * Checks if the victim's active Pokemon is knocked out.
     * 
     * @param player The player whose Pokemon is being checked for knockout.
     * @return true if the Pokemon is knocked out, false otherwise.
     */
    public boolean checkKO(Player player) {
        if (player.active.isKnockedOut()) {
            player.discardPile.add(player.active);
            for (Energy energy : player.active.getAttachedEnergies()) {
                player.discardPile.add(energy);
            }
            player.active = null;
            return true;
        }
        return false;
    }

    /**
     * Runs a Monte Carlo simulation of the game.
     * 
     * @param iter The number of iterations for the simulation.
     */
    public void runMonteSim(int iter) {
        MonteSim sim = new MonteSim(iter);
        sim.runSim();
    }

    /**
     * Displays instructions on how to play the game.
     */
    public void instructions() {
        System.out.println("How to play:\n- Players will take turns where you can either draw a card, play a card, or attack your opponent's Pokemon.\n- "
                + "This continues until one player empties their prize pile.");
    }

    /**
     * Checks if a Pokemon is paralyzed and handles the effect.
     * 
     * @param pokemon The Pokemon being checked for paralysis.
     * @return true if the Pokemon is paralyzed, false otherwise.
     */
    public boolean checkParalyzed(Pokemon pokemon) {
        if (pokemon.getIfParalyzed()) {
            System.out.println(pokemon.getCardName() + " is paralyzed!");
            pokemon.setParalyzed(false);
            return true;
        }
        return false;
    }

    /**
     * Checks if a player has won the game by emptying their prize pile.
     * 
     * @return true if a player has won, false otherwise.
     */
    public boolean checkWinner() {

		if (player1.prizePile.isEmpty()) {
			System.out.println("Game Over! " + player1.getName() + "is the winner!");
			return true;
		} else if (player2.prizePile.isEmpty()) {
			System.out.println("Game Over! " + player2.getName() + "is the winner!");
			return true;
		}
		return false;
	}
}
