

import java.util.Scanner;

public class FibonacciPrinter {

	public static void main(String[] args) {
		/*Write a program that given an integer n, where n >= 1, prints the first n terms of the Fibonacci sequence.
		Recall that the Fibonacci sequence looks like this:
		0 1 1 2 3 5 8 13 (i.e., the first two terms are 0 and 1, respectively, and every other term is the sum of the
		previous two terms in the sequence).
		Sample input:
		6
		Sample output:
		0 1 1 2 3 5
		*/
		
		//Get number for how many fibonacci numbers you want
		Scanner sc = new Scanner(System.in);
		Integer count = sc.nextInt();
		//Check if its >= 1
		while(count < 1) {
			System.out.println("Has to be greater or equal to 1");
			count = sc.nextInt();
		}
		

		printFibonacci(count);
		
		
		

	}
	//Create the Fibonacci Sequence
	public static void printFibonacci(int count) {
		
		
		/*Professor's Solution
		 * Handles Base case in the loop with first print
		 * int fib1 = 0;
		 * int fib2 = 0;
		 * 
		 * while(count > 0)
		 * {
		 * 		System.out.print(fib1 + " ");
		 * 		int tempFib2 = fib2;
		 * 		fib2 = fib1 + fib2;
		 * 		fib1 = tempFib2;
		 * 		n--;
		 *}
		 */
		
		//make base cases in case count is low
		if(count == 1) {
			System.out.print(0);
		}
		else {
			int feb[] =  new int[count];
			//Fibonacci sequence always starts with 1 and 0
			feb[0] = 0;
			feb[1] = 1;
			
	
			
			for(int i=2; i < count; i++){
				feb[i] = feb[i-1] + feb[i-2];
				}

			for(int i=0; i< count; i++){
				if((count - 1) == i) {
					System.out.print(feb[i]);
				}
				else {
					System.out.print(feb[i] + " ");
		
				}
			}
		
		
		}
	
	}
}
