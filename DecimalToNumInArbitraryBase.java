import java.util.Scanner;

public class DecimalToNumInArbitraryBase {

	public static void main(String[] args) {
		// Open scanner and get first and second integer
		Scanner sc = new Scanner(System.in);
		Integer number = sc.nextInt();
		Integer base = sc.nextInt();
		int remainder;
		int newNumber;

		//Now convert number to new base
		//Must do the math
		//find the int that is the biggest power of 8 
		//That is less then the number to find how many times
		//To itterate through the loop
		Integer powerOf = 0;
		while(number > Math.pow(base, powerOf)) {
			powerOf++; //So you can get the highest power it goes too
			if(Math.pow(base, powerOf) > number) {
				powerOf--;
				break;
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

		sc.close();

	}

}
