import java.util.Scanner;

public class CountNumberOfBits_ANDandShift {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		
		int count = 0;
		
		while(number != 0) {
			
			count = count + (number & 1);
			number = number >>> 1;
		}
		
		System.out.print(count);

	}

}
