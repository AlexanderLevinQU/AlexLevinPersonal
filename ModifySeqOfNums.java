import java.util.Scanner;

public class ModifySeqOfNums {

	public static void main(String[] args) {
		//Read in Integer
		Scanner sc = new Scanner(System.in);
		//read in number as string
		String number = sc.nextLine();
		//split input in white space
		//put strings into an array
		String [] number1 = number.split(" ");
		Integer length = number1.length; //didn't bother using was useless
		//iterate over string array
		//convert each string into integer
		Integer r;
		String adding;
		
		for(int i = 0; number1.length > i; i++) {
			 r = Integer.parseInt(number1[i]);			
			 
			 //Check the length of the number compared to the sequence
			 if(r > i ) {
				 r = r;
			 }
			 //if the number is greater then in the sequence switch it
			 else if(r < i) {
				 r = 0;
			 }
			 //convert r back to a string
			 adding = r.toString();
			 //put it back in the place of I replacing or keeping what is same of before
			 number1[i] = adding; 
			 
		}
		//Itterate the through the array to print
		//Make sure the last space doesn't print an extra space 
		//with simple if statement
		for(int i = 0; number1.length> i; i++) {
			if(number1.length - 1 == i) {
				System.out.print(number1[i]);
			}
			else {
				System.out.print(number1[i] + " ");
				
			}
		}
		sc.close();

	}

	}


