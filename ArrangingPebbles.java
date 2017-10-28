import java.util.Scanner;

public class ArrangingPebbles {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String [] pebbles = sc.nextLine().split(" ");
		
		//Create counts for each red white and green
		int redCount = 0;
		int whiteCount = 0;
		int greenCount = 0;
		
		for (int i = 0; pebbles.length > i; i++){
			if(pebbles[i].equals("r")) {
				redCount++;
			}
			else if(pebbles[i].equals("g")) {
				greenCount++;
			}
			else if(pebbles[i].equals("w")) {
				whiteCount++;
			}
		}
		
		for(int i = 0; pebbles.length > i; i++) {
			pebbles[i] = "w";
			if(whiteCount <= i ) {
				pebbles[i] = "g";
				if((greenCount + whiteCount) <= i)
					pebbles[i] = "r";
				
			}
		}
		
		
		/*
		 
		 Condensed all below into the for loop above
		
		for(int i = 0; whiteCount > i; i++){
			pebbles[i] = "w";
		}
		
		for(int j = whiteCount; greenCount + whiteCount > j; j++) {
			pebbles[j] = "g";
		}
		for(int l = whiteCount + greenCount; pebbles.length > l; l++) {
			pebbles[l] = "r";
		}
		*/
		
		for(int i = 0; pebbles.length > i; i++) {
			if(pebbles.length - 1 == i) {
				System.out.print(pebbles[i]);
			}
			else {
				System.out.print(pebbles[i] + " ");
			}
		}
		
		
		
		
		/*
		 Need to be able to nested loops for this one to work
		for(int i = 0; pebbles.length - 1 > i ; i++) {
			if(pebbles[i].equals("r")  && pebbles[i+1].equals("g")) {
				String temp = pebbles[i];
				pebbles[i] = pebbles[i + 1];
				pebbles[i+1] = temp;


			}
			else if(pebbles[i].equals("r") && pebbles[i+1].equals("w")) {
				String temp = pebbles[i];
				pebbles[i] = pebbles[i + 1];
				pebbles[i+1] = temp;


			}
			else if(pebbles[i].equals("g") && pebbles[i+1].equals("w")) {
				String temp = pebbles[i];
				pebbles[i] = pebbles[i + 1];
				pebbles[i+1] = temp;

			}
			else {
				pebbles[i] = pebbles[i];
				pebbles[i+1] = pebbles[i+1];
			}
		}
		*/
		
		
		

	}

}
