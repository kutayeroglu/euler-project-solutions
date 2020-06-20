import java.lang.Math;

public class main {

	/*THIS PROBLEM WAS TAKEN FROM projecteuler.net 
	 * 
	 * PROBLEM 5 
	 * 
	 * 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
	 * What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
	 * 
	 */

	public static void main (String[] args) {
		
		//Trying to solve wrong user commit use : : : 

		//Calculating startTime to find total execution time 
		long startTime = System.nanoTime();
		
		System.out.println(checkSmallDivisible(20));
		
		long endTime = System.nanoTime();
		
		//System.nanoTime() gives the runtime in nanoseconds. We convert it to seconds. 
		System.out.println("Total runtime in seconds is: " +(endTime - startTime) / Math.pow(10, 9));
	}



	private static int checkSmallDivisible(int upperLimit) {

		/*
		 * Upper limit is 20 in this question 
		 * If a number is divisible by 2 and 5 at the same time its last digit have to be zero
		 */


		for (int i = 30; i <= Math.pow(10, 9); i += 10) {

			for (int j = 3; j <= upperLimit; j++) {

				if (i % j != 0) break;

				if (j == upperLimit && i % j == 0) return i;

			}

		}

		return -1; 

	}



}
