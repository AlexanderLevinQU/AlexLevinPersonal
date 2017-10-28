import java.util.Scanner;

public class ReverseInt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Read in Integer
		Scanner sc = new Scanner(System.in);
		String number1 = sc.nextLine();
		Integer number = Integer.valueOf(number1);
		Integer length = number.toString().length();
		Integer r;
		Integer result;
		String adding;
		String resultinString = "";
		int reversenum = 0;
		//Don't make length >= or you will get a trailing 0
		for(int i = 0; length > i; i++) {
			 r = number % 10;
			 adding = r.toString();
			 resultinString = resultinString + adding;
			 //make new number divide by 10 so you get new r
			 number = number / 10;
			 //reversenum = r + reversenum * 10; Do it without a string			 
			
		}
		//replace 0's
		resultinString = resultinString.replaceFirst ("^0*", "");
		result = Integer.parseInt(resultinString);
		
		System.out.println(result);
		//System.out.println(reversenum); // Without A string
		
		sc.close();

	}

}
