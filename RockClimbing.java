import java.util.Scanner;

public class RockClimbing {

	public static void main(String[] args) {
		//Need 3 things
		//Highest point achieved so just addition of all the numbers
		//Also need a current point to find the highestpoint
		Integer currentPoint = 0;
		Integer highestPoint = 0;
		//Finishing point
		Integer finishingPoint = 0;
		//Total Positive distance
		Integer positiveDistance = 0;
		//Get Integers first
		Scanner sc = new Scanner(System.in);

		Integer howMany = sc.nextInt();
		//Have to make an array to store all the strings
		String [] containNumbers = new String[howMany];

		sc.nextLine(); //To give a space for the loop

		for(int i = 0; howMany > i; i++) {
			//Get String to split it Later
			containNumbers[i] = sc.nextLine(); //will split it later for use
			//System.out.println("read a string");
		}

		//Now have an array of ContainNumbers[number][String of Numbers] so have to create a String and work on it at the same time.
		for(int i = 0; howMany > i; i++) {
			//Now have my string to work on every time
			String [] numbers = containNumbers[i].split(" ");
			//Need to get every number
			for(int j = 0; numbers.length > j ; j++) {
				//Now have my string to work on every time

				Integer numbersInString = Integer.parseInt(numbers[j]);
				//Now we do the math with the numbers

				//Number traveling
				currentPoint = numbersInString + currentPoint;
				//finishingpoint, can't go lower then 0. Add all the numbers up
				//Make sure current point never goes less then 0 first for everything
				if(currentPoint < 0) {
					currentPoint = 0;
					finishingPoint = currentPoint;
				}
				else {
					//Last but not least we need the total positive distance
					//So first check if current distance is greater then 0
					finishingPoint = currentPoint;

				}

				if(numbersInString > 0 ) {
					positiveDistance = positiveDistance + numbersInString;
				}

				//Calculate highest point
				//Make sure its in a different if statement so it will run
				if(currentPoint > highestPoint) {
					highestPoint = currentPoint;
				}
				else {
					//Stays Same does nothing but easier for other people to understand if I write
					highestPoint = highestPoint;
				}
				//Last but not least we need the total positive distance
				//So first check if current distance is greater then 0
			}
			//Now print it all out
			System.out.println(highestPoint + " " + finishingPoint + " " + positiveDistance);
			highestPoint = 0;
			finishingPoint = 0;
			positiveDistance = 0;
			currentPoint = 0;

		}
		sc.close();


	}

}
