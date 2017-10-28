import java.util.Scanner;


public class FizzBuzzSeveralInts {

	public static void main(String[] args) {
		//Create Scanner
		Scanner sc = new Scanner(System.in);
		//Read in Integers
		int howMany = sc.nextInt();
		int[] integers = new int[howMany];
		for(int i = 0; i < howMany; i++)
		{
		    integers[i] = sc.nextInt();
		}
		//Create fizzbuzz first one goes through how many numbers
		//Second one goes through the specific integer
		for(int i = 0; howMany > i; i++) {
	        for(int j = 1; integers[i] >= j; j++) {
	        	if(j%5 == 0 && j%3 == 0) {
	        		System.out.println("FizzBuzz");
	        		}
	        	else {
	        		if(j%3 == 0 ) {
	        			System.out.println("Fizz");
	        				
	        			}
	        		else if(j%5 == 0) {
	        			System.out.println("Buzz");
	        			}
	        				
	        				
	        		else {
	        			System.out.println(j);
	        			}

	        			}
	        		}
	        	}
	        	
	        	
	        
	        
	        
		


		sc.close();

}
}
