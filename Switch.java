package PokemonPack;

import java.util.Scanner;

/**
 * Represents the Switch trainer card, classified as a Supporter. This card allows
 * the player to swap their active Pokemon with one from their bench.
 */
public class Switch extends Trainer {
	private static String trainerType = "Supporter";
	private static String cardName = "Switch";
	
	/**
	 * Constructs a Switch trainer card.
	 */
	public Switch() {
		super(trainerType, cardName);
	}
	
	/**
	 * Executes the effect of the Switch card, allowing the player to select a Pokemon
	 * from their bench to swap with their active Pokemon. Uses scanner for user input
	 * to select the bench Pokemon.
	 * 
	 * @param player The player executing the card's effect.
	 */
	@Override
	public void playCard(Player player) {
		Scanner scanner = new Scanner(System.in);
		int index = 0;
		if (!player.bench.isEmpty()) {
			System.out.println("Choose a card from your bench to switch with your active pokemon.\n");
			player.printBench();
			System.out.println("Active Pokemon:\n" + player.active.printCard());
			System.out.println("Input index ->");
			index = scanner.nextInt();
			player.bench.add(player.active);
			player.active = player.bench.get(index);
			player.bench.remove(index);
			System.out.println(player.active.getCardName() + " is your new active pokemon!");
		} else {
			System.out.println("Bench is empty!");
			return;
		}
	}
}
