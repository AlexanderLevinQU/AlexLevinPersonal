import java.util.Scanner;

public class ReplacingRightmostZeroesWithOnes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int number = sc.nextInt();

		/*
		int numberComp = number ^ ((Integer.highestOneBit(number) * 2 ) - 1);
		int finalNumber;
		int biggestTwosNumber = (Integer.highestOneBit(number) * 2) - 1;	
		
		if((number & 1) == 1 || number == 0) {
			System.out.print(number);
		}
		else if(number < 0) {
		}
		else {
			finalNumber = numberComp - number;
			System.out.print(finalNumber & biggestTwosNumber);	
		}
		 */
		if(number == 0) {
			System.out.print(number);
		}
		else {
			number = (number - 1) | number;
			System.out.print(number);
		}
	}

}
