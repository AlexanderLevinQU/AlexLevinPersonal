import java.util.Scanner;

public class ShiftingArrayElements {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String [] numbers = sc.nextLine().split(" ");
		String [] numbersShifted = new String[numbers.length];

		Integer numberShifter = sc.nextInt();

		for(int i = 0; numbers.length - numberShifter > i; i++) {
			numbersShifted[i] = numbers[i + numberShifter];	
		}

		//Will always be missing numbes.length - numberShifted elements at the end
		//So just add those in manually
		int whereIsNull = numbers.length - numberShifter;
		for(int i = 0; numberShifter > i; i++) {
			numbersShifted[whereIsNull] = numbers[i];
			whereIsNull++;
		}

		for(int i = 0; numbers.length > i; i++) {
			if(numbers.length - 1 == i) {
				System.out.print(numbersShifted[i]);
			}
			else {
				System.out.print(numbersShifted[i] + " ");
			}


		}
		sc.close();
	}


}

