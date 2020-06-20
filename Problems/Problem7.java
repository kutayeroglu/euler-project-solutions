import java.util.Scanner;
import java.lang.Math;

public class main {


	/* THIS PROBLEM WAS TAKEN FROM projecteuler.net
	 * 
	 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
	 * What is the 10 001st prime number?
	 */


	public static void main(String[] args) {

		/*
		 * Prime Numbers with 2 or more digits have the sums of their digits equal to Only one of the following - {1,2,4,5,7,8}
		 * We already know prime numbers below 10 are 2,3,5 and 7. Therefore, our prime counter will start from 4 and will stop at 10 001  
		 */

		Scanner sc = new Scanner(System.in); 
		int position = 1;
		
		while(true) {
			
			System.out.println("Enter which position of prime you want to find: ");
			position  = sc.nextInt();
			
			if(position == -1) break;
			
			//For runtime calculation purposes
			long startTime = System.nanoTime();

			int resultPrime = findPrime(position);
			String endStr = "th";
			
			if(position % 10 == 1) endStr = "st";
			if(position % 10 == 2) endStr = "nd";
			if(position % 10 == 3) endStr = "rd";
	
			System.out.println(position+ endStr+ " prime is " +resultPrime);
			
			//Runtime calculation 
			long endTime = System.nanoTime();
			System.out.println("Total runtime in seconds is: " +(endTime - startTime) / Math.pow(10, 9));

		}
		
		System.out.println("- - - Program terminated - - - ");
			

	}

	private static int findPrime(int position) {

		int primeCounter = 4;
		
		//Base cases
		if(position < 0) throw new IllegalArgumentException();
		if(position == 1) return 2;
		if(position == 2) return 3;
		if(position == 3) return 5;
		if(position == 4) return 7;

		while(true) {

			//Since we know next prime after 7 is 11 we start from there. We go 2 by 2 since no even number is prime other than 2 
			for(int i = 11; i <= Math.pow(10, 9); i += 2) {
				
				//Apart from 2 and 5, all prime numbers have to end in 1, 3, 7 or 9
				if(i % 10 == 1 || i % 10 == 3 || i % 10 == 7 || i % 10 == 9 ) {
					
					if(isPrime(i)) primeCounter++; 

				}
				if(primeCounter == position) return i;
				
			}
			break;
		}
		return -1;
		
	}
	
	private static boolean isPrime(int num) {
		
		if(num <= 1) return false; 
		if(num == 2) return true;
		
		if(num % 2 == 0) return false; 
		
		for(int i=3; i<= num-1; i += 2) {
			
			if(num % i == 0) return false;
		}
		
		return true;
	}
	
}
