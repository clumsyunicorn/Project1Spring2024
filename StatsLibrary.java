package PokemonPack;
import java.util.ArrayList;
import java.lang.Math;
import java.math.BigInteger;

/**
 * This class provides methods for calculating statistical measures.
 */
public class StatsLibrary {
	
	/**
     * Calculates the mean (average) of a list of numbers.
     * 
     * @param userInputNumbers The list of numbers for which to find the mean.
     * @return The mean of the numbers in the list.
     */
    public static double findMean(ArrayList<Double> userInputNumbers){
        double result = 0;
        double sum = 0;

        for(double singleElement : userInputNumbers){
            sum = sum + singleElement;
        }
        result = sum / userInputNumbers.size();
        return result;
    }
    
    /**
     * Calculates the median of a list of numbers.
     * 
     * @param userInputNumbers The list of numbers for which to find the median.
     * @return The median of the numbers in the list.
     */
    public static double findMedian(ArrayList<Double> userInputNumbers) {
        double result = 0;
        double size = userInputNumbers.size();
        boolean ordered;
        double x = 0;
        
        // Sort the list
        for(int i = 0; i < size - 1; i++) {
            ordered = false;
            for(int j = 0; j < size - i - 1; j++) {
                if(userInputNumbers.get(j) > userInputNumbers.get(j+1)) {
                    x = userInputNumbers.get(j);
                    userInputNumbers.set(j, userInputNumbers.get(j+1));
                    userInputNumbers.set(j+1, x);
                    ordered = true;
                }
            }
            if(!ordered) {
                break;
            }
        }
        
        // Calculate median based on list order
        if (size %2 == 0) {
            // even
            double m1 = userInputNumbers.get((int) ((size/2.0)-1.0));
            double m2 = userInputNumbers.get((int) ((size/2.0)));
            result = (m1 + m2) / 2;
        } else {
            // odd
            result = userInputNumbers.get((int) (size/2));
        }
        
        return result;
    }
	
	//I used bubble sort as inspiration https://www.geeksforgeeks.org/bubble-sort/
	public static double findMode(ArrayList<Double> userInputNumbers) {
		double result = 0;
		double max = 0;
		double temp = 0;
		int j = 0;
		int size = userInputNumbers.size();
			
		for (double element: userInputNumbers) {
			
			for(int i = 0; i < size; i++) {
				if(element == userInputNumbers.get(i)) {
					temp++;
				}
			}
			if (temp > max) {
				max = temp;
				result = element;
			}
			temp = 0;
		}
	return result;
	}
	
	/**
     * Calculates the standard deviation of a list of numbers.
     * 
     * @param userInputNumbers The list of numbers for which to find the standard deviation.
     * @return The standard deviation of the numbers in the list.
     */
	//Inspired by https://www.geeksforgeeks.org/java-program-to-calculate-standard-deviation/
	public static double findSTD(ArrayList<Double> userInputNumbers) {
		
		//Mean
		double std = 0;
		int total = userInputNumbers.size();
		double mean = findMean(userInputNumbers);
		
		//Difference of the squares
//		double[] sqrDif = new double[total];
        for (int i = 0; i < total; i++) {
            std = std + Math.pow(userInputNumbers.get(i) - mean, 2);
        }
        
        //Average the differences
		std = Math.sqrt(std/total);
		return std;
	}
	
	/**
     * Finds the union of two sets represented as ArrayLists.
     * 
     * @param A The first set.
     * @param B The second set.
     * @return The union of sets A and B.
     */
	public ArrayList<String> findUnion(ArrayList<String> A, ArrayList<String> B) {
		ArrayList<String> union = new ArrayList<>();
		boolean repeat = false;
		
		//iterate through lists and compare elements
		for (String element: A) {
			union.add(element);
		}
		
		for (String element: B) {
			for (int i = 0; i < union.size(); i++) {
				if (union.get(i) == element) {
					repeat = true;
					break;
				}
			}
			
			//check if element exists already
			if (!repeat) {
				union.add(element);
			}
		}		
		
		//check if exclusive
		if (union.isEmpty()){
			
			union.add("A and B are Mutually Exclusive");
		}
				
		return union;
	}
	
	/**
     * Finds the intersection of two sets represented as ArrayLists.
     * 
     * @param A The first set.
     * @param B The second set.
     * @return The intersection of sets A and B.
     */
	public ArrayList<String> findInter(ArrayList<String> A, ArrayList<String> B) {
		
		ArrayList<String> inter = new ArrayList<>();
		
		//add all elements that are in both A AND B
		for (String elementA: A) {
			for (String elementB: B) {
				if (elementA == elementB) {
					inter.add(elementA);
				}
			}
		}
		
		return inter;
	}
	
	/**
     * Finds the complement of a set represented as an ArrayList.
     * 
     * @param list The set from which to find the complement.
     * @param A The subset to subtract from the set to find the complement.
     * @return The complement of set A in the set represented by list.
     */
	public ArrayList<String> findComp(ArrayList<String> list, ArrayList<String> A) {
		
		//remove all elements that are in A
		for (String element: A) {
			for (int i = 0; i < list.size(); i++) {
				if(element == list.get(i)) {
					list.remove(i);
				}			
			}
		}
		
		return list;
	}	
	
	/**
     * Calculates the factorial of a non-negative integer using BigInteger for large numbers.
     * 
     * @param n The non-negative integer for which to calculate the factorial.
     * @return The factorial of the input integer.
     */
	public static BigInteger factorial2(int n) {
	    BigInteger result = BigInteger.ONE;

	    // 0! = 1
	    if (n == 0) {
	        return result;
	    }

	    for (int i = 1; i <= n; i++) {
	        result = result.multiply(BigInteger.valueOf(i));
	    }

	    return result;
	}

	
	/**
     * Calculates the factorial of a non-negative integer using int for smaller numbers.
     * 
     * @param n The non-negative integer for which to calculate the factorial.
     * @return The factorial of the input integer.
     */
	public static Integer factorial(int n) {
		int result = 1;
		
		//0! = 1
		if (n == 0){
			return result;
		}
		
		for (int i = 1; i <= n; i++) {
			result *= i; 
		}
		
		return result;
	}
	
	
	
	/**
     * Calculates the conditional probability of event A given event B.
     * 
     * @param A The probability of event A.
     * @param B The probability of event B.
     * @return The conditional probability of event A given event B.
     */
	public static double conditional(double A, double B) {
		//Calculate joint probability
		double result = (A*B)/B;
		
		return result;
	}
	
	/**
     * Calculates the Bayesian probability of event A given event B.
     * 
     * @param A The probability of event A.
     * @param B The probability of event B.
     * @return The Bayesian probability of event A given event B.
     */
	public static double bayes(double A, double B) {
		
		double result = ((conditional(B,A))*(A))/B;
		
		return result;
	}
	
	/**
     * Determines whether two events are independent.
     * 
     * @param A The probability of event A.
     * @param B The probability of event B.
     * @return True if the events are independent, otherwise false.
     */
	public static boolean independence(double A, double B) {
		
		if (conditional(A, B) == A) {
			return true;
		} else if (conditional(B, A) == B) {
			return true;
		} 
		
		return false;
	}
	
	/**
     * Calculates the number of combinations of selecting y items from a set of n items.
     * 
     * @param n The total number of items in the set.
     * @param y The number of items to select.
     * @return The number of combinations.
     */
	public static double combination(int n, int y) {
		
		double result = (factorial(n))/((factorial(y))*(factorial(n-y)));
		
		return result;	
	}
	
	/**
     * Calculates the number of permutations of selecting y items from a set of n items.
     * 
     * @param n The total number of items in the set.
     * @param y The number of items to select.
     * @return The number of permutations.
     */ 
	public static double permutation(int n, int y) {
		
		double result = factorial(n)/factorial((n-y));
		
		return result;	
	}
	
	/**
     * Calculates the probability of a binomial distribution.
     * 
     * @param n The number of trials.
     * @param y The number of successes.
     * @param p The probability of success in a single trial.
     * @return The probability of the binomial distribution.
     */
	public static double binomialDistribution(int n, int y, double p){
		
		double result = (combination(n, y)) * (Math.pow(p, y)) * (Math.pow((1-p), (n-y)));
		
		return result;
		
	}
	
	/**
     * Calculates the probability of a geometric distribution.
     * 
     * @param y The number of trials until the first success.
     * @param p The probability of success in a single trial.
     * @return The probability of the geometric distribution.
     */
	public static double geometricDistribution(int y, double p) {
		
		double result = (Math.pow((1-p), (y-1))) * p;
		
		return result;
	}
	
	/**
     * Calculates the probability of a negative binomial distribution.
     * 
     * @param y The number of trials until the rth success.
     * @param r The number of successes.
     * @param p The probability of success in a single trial.
     * @return The probability of the negative binomial distribution.
     */
	public static double negativeBinomialDistribution(int y, int r, double p) {
		
		double result = (combination((y-1), (r-1)))*(Math.pow(p, r))*(Math.pow((1-p), (y-r)));
		
		return result;
	}
	
	/**
     * Calculates the probability of a hypergeometric distribution.
     * 
     * @param n The number of draws.
     * @param y The number of successes in the sample.
     * @param r The number of successes in the population.
     * @param N The size of the population.
     * @return The probability of the hypergeometric distribution.
     */

	public static double hyperGeometricDistribution(int n, int y, int r, int N) {
		
		double result = ((combination(r, y)) * (combination((N - r), (n - y))))/ combination(N, n);
		
		return result;
	}

}
