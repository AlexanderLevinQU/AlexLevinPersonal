import java.util.Scanner;

public class CountingOccurencesOfMaximum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String [] numbers = sc.nextLine().split(" ");
		int count = 0;
		Integer maxNumber = 0;
		
		for(int i = 0; numbers.length  > i; i++) {
			Integer number = Integer.parseInt(numbers[i]);
			if(number >= maxNumber) {
				maxNumber = number;
			}
		}
		String maxNumberString = maxNumber.toString();
		
		//Iterate through array and count how many are equal to maxNumber
		for(int i = 0; numbers.length > i; i++) {
			if(maxNumberString.equals(numbers[i])) {
				count++;
			}
		}
		
		System.out.print(count);
		sc.close();
		
	}

}
