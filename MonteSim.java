package PokemonPack;

import java.util.Collections;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;

/**
 * This class performs a Monte Carlo simulation to calculate the probability of drawing a certain number
 * of Pokemon cards from a deck.
 */
public class MonteSim {
    // Variable to hold the number of iterations.
    private int iter;

    /**
     * Constructs a MonteSim object with the specified number of iterations.
     *
     * @param iter The number of iterations for the simulation.
     */
    public MonteSim(int iter) {
        this.iter = iter;
    }

    /**
     * Runs the Monte Carlo simulation.
     */
    public void runSim() {
        try (FileWriter write = new FileWriter("sim_results.csv")) {
            write.append("Pokemon, Probability\n");

            for (int pokeCount = 1; pokeCount <= 60; pokeCount++) {
                int good = 0;

                for (int i = 0; i < iter; i++) {
                    ArrayList<String> deck = new ArrayList<>();

                    for (int j = pokeCount; j < 60; j++) {
                        deck.add("P");
                    }

                    for (int j = pokeCount; j < 60; j++) {
                        deck.add("E");
                    }
                    Collections.shuffle(deck);

                    // Check if the deck size is at least 7
                    if (deck.size() >= 7 && deck.subList(0, 7).contains("P")) {
                        good++;
                    }
                }

                double avg = ((double) good) / iter;
                write.append(pokeCount + "," + avg + "\n");
            }

        } catch (IOException e) {
            System.out.println("Failed to write to csv file.");
            e.printStackTrace();
        }
    }
}
