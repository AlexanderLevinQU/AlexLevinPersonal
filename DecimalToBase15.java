import java.util.Scanner;

public class DecimalToBase15 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Integer number = sc.nextInt();

		Integer base = 15;
		int remainder;
		int newNumber;
		Integer powerOf = 0;


		while(number > Math.pow(base, powerOf)) {

			powerOf++; //So you can get the highest power it goes too
			if(Math.pow(base, powerOf) > number) { //Create a check incase its to big
				powerOf--;
				break;
			}
		}


		while(powerOf > -1) {
			newNumber = (int) (number / Math.pow(base, powerOf)); // Integer divison is necessary!!
			remainder = (int) (number % Math.pow(base, powerOf));
			if(newNumber == 10) {
				System.out.print('A');
				number = remainder;
				powerOf--;
			}
			else if(newNumber == 11) {
				System.out.print('B');
				number = remainder;
				powerOf--;
			}
			else if(newNumber == 12) {
				System.out.print('C');
				number = remainder;
				powerOf--;
			}
			else if(newNumber == 13) {
				System.out.print('D');
				number = remainder;
				powerOf--;
			}
			else if(newNumber == 14) {
				System.out.print('E');
				number = remainder;
				powerOf--;
			}
			else {
				System.out.print(newNumber);
				number = remainder;
				powerOf--;
			}
		}
		sc.close();




	}
}


	


