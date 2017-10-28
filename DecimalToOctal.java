import java.util.Scanner;

public class DecimalToOctal {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Integer number = sc.nextInt();
		Integer base = 8;
		int remainder;
		int newNumber;

		//Find the highest powerOf that divides into the Integer Number
		Integer powerOf = 0;
		while(number > Math.pow(base, powerOf)) {
			powerOf++; //So you can get the highest power it goes too
			//Make sure to go one down if its to big because
			//the while loop doesn't check that
			if(Math.pow(base, powerOf) > number) {
				powerOf--;
				break;//Manually exit a loop
			}
		}

		//Now you have the highest power
		//Get your numbers!
		for(int i = 0; powerOf >= 0; i++) {
			newNumber = (int) (number / Math.pow(base, powerOf)); // Integer divison is necessary!!
			remainder = (int) (number % Math.pow(base, powerOf));
			System.out.print(newNumber);
			number = remainder;
			powerOf--;
		}





		//Remainder Way
		//Has some errors at the end

		/*Integer octal = 0;
		int number2;
		while(number > 0) {
			int remainder;
			// Integer division so you will get a different number 

			remainder = number % 8; // a(number) - b(number2)}

			//Put numbers in to a new number
			//octal = remainder + octal * 10;
			octal = remainder * 1000 + octal;
			number = number/8;
			octal = octal/10;

		}
		/*
		//Need to reverse the number now because it is printed backwards
		//Becomes Obselete if you go up to while loop 
		 	int tempDigit = 0;

	        while (octal > 0){

	            tempDigit = octal % 10;
	            System.out.print(tempDigit);
	            octal = octal / 10;
	        }
		System.out.print(octal);
		 */

		sc.close();

	}

}
