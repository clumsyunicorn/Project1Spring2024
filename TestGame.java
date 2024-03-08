package PokemonPack;

public class TestGame {

	public static void main(String[] args) {
		PokemonGame game = new PokemonGame();
		//game.runGame();
		
		MonteSim sim = new MonteSim(100);
		sim.runSim();
		
		RareCandyMonteSim rareSim = new RareCandyMonteSim(100);
		rareSim.runSim();
		
//		//Testing for StatsLibrary
		StatsLibrary test = new StatsLibrary();
//		ArrayList<Double> A = new ArrayList<>();
//		
//		A.add(12.0);
//		A.add(32.0);
//		A.add(11.0);
//		A.add(55.0);
//		A.add(10.0);
//		A.add(23.0);
//		A.add(14.0);
//		A.add(30.0);
//		
//		
//		double mean = test.findMean(A);
//		double median = test.findMedian(A);
//		double mode = test.findMode(A);
//		double std = test.findSTD(A);
//		
//		System.out.println("This is the mean/average of your array of numbers: " + mean);
//		System.out.println("This is the median of your array of numbers: " + median);
//		System.out.println("This is the mode of your array of numbers: " + mode);
//		System.out.println("This is the Standard Deviation of your array of numbers: " + std);
//		
//		
//		//Testing SetOperations
//		ArrayList<String> A = new ArrayList<>();
//		
//		A.add("monday");
//		A.add("tuesday");
//		A.add("wednesday");
//		A.add("thurday");
//		A.add("friday");
//		A.add("saturday");
//		A.add("sunday");
//		
//		ArrayList<String> B = new ArrayList<>();
//		
//		B.add("cat");
//		B.add("dog");
//		B.add("animal");
//		B.add("monday");
//		B.add("tuesday");
//		B.add("blah");
//		
//		ArrayList<String> S = new ArrayList<>();
//		
//		S.add("wednesday");
//		S.add("thurday");
//		S.add("friday");
//		S.add("saturday");
//		S.add("sunday");
//		S.add("cat");
//		S.add("dog");
//		S.add("animal");
//		S.add("monday");
//		S.add("tuesday");
//		S.add("blah");
//		
//		
//		System.out.println("This is the union of the sets: \n" + test.findUnion(A, B));
//		System.out.println("This is the intersection of the sets: \n" + test.findInter(A, B));
//		System.out.println("This is the complement of subset A: \n" + test.findComp(S, A));
		
//		//Testing Binomial Distribution
//		System.out.println("Answer: " + StatsLibrary.binomialDistribution(5, 4, .7));	
		
	}

}
