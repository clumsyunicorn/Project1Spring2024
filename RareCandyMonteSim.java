package PokemonPack;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/**
 * This class performs a Monte Carlo simulation to calculate the probability of drawing a certain number
 * of Rare Candy cards from a deck.
 */
public class RareCandyMonteSim {
    private int iter;
    
    /**
     * Constructs a RareCandyMonteSim object with the specified number of iterations.
     *
     * @param iter The number of iterations for the simulation.
     */
    public RareCandyMonteSim(int iter) {
        this.iter = iter;
    }
    
    /**
     * Runs the Monte Carlo simulation.
     */
    public void runSim() {
        try (FileWriter writer = new FileWriter("rare_candy_sim_results.csv")) {
            writer.append("Rare Candy Count, Probability\n");

            for (int candyCount = 1; candyCount <= 4; candyCount++) {
                int good = 0;

                for (int i = 0; i < iter; i++) {
                    ArrayList<String> deck = new ArrayList<>();

                    // Add Pokemon
                    for (int j = 0; j < 15; j++) {
                        deck.add("P");
                    }

                    // Add Energy
                    for (int j = 0; j < 15; j++) {
                        deck.add("E");
                    }

                    // Add Rare Candy
                    for (int j = 0; j < candyCount; j++) {
                        deck.add("R");
                    }

                    Collections.shuffle(deck);

                    // Simulate drawing the initial hand
                    if (deck.subList(0, 7).contains("P")) {
                        good++;
                    }
                }

                double avg = ((double) good) / iter;
                writer.append(candyCount + "," + avg + "\n");
            }

        } catch (IOException e) {
            System.out.println("Failed to write to CSV file.");
            e.printStackTrace();
        }
    }
}
