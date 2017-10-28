import java.util.Scanner;

public class ComputingXModPowerOfTwo {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
		
		int firstNumber = sc.nextInt();
		int modNumber = sc.nextInt();
		
		int answer = firstNumber - (modNumber * (firstNumber / modNumber));
		
		System.out.print(answer);
		
		/*
		 * or x & (y-1)
		 * 
		 * 
		 */
		
		sc.close();

	}

}
