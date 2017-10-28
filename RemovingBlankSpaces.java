import java.util.ArrayList;
import java.util.Scanner;


public class RemovingBlankSpaces {

	public static void main(String[] args) {
		//Find How many lines first
		Scanner sc = new Scanner(System.in);

		int howManyLines = sc.nextInt();
		sc.nextLine(); // Clear space

		String [] text = new String[howManyLines];


		//Put them in the string array
		for(int i = 0; i < howManyLines; i++) {
			text[i] = sc.nextLine();
		}
		
		ArrayList<Character> characters = new ArrayList<Character>();

		//Now put them in a character ray
		//Must Create a character array with a mutable size
		
		// JUST NEED A CHECK TO KEEP THINGS BEFORE word
		//TO DO THIS FIND THE FIRST INSTANCE OF AN ALPHABETIC word
		//AND THEN START 2nd COUNT THERE
		int check = 0;
		
		for(int i = 0; i < howManyLines; i++) {
			//Count spaces before first text so you can add all this into the text and don't lose spaces
			for(int d = 0; d < text[i].length(); d++) {
				if(Character.isAlphabetic(text[i].charAt(d))) {
					check = d;
					break;
				}	
			}
			//Add in text where you should
			for(int j = 0; j < text[i].length(); j++) {
				//Add in spaces until it gets to the first word (aka check)
				if( j < check) {
					characters.add(text[i].charAt(j));
				}
				//Add character if its alphabetic
				else if(Character.isAlphabetic(text[i].charAt(j))) {
					characters.add(text[i].charAt(j));
				}
				//if its white space don't and if one after is white space don't either(so no multiple white space)
				//It will add above if its just one white space
				else if(Character.isWhitespace(text[i].charAt(j)) && Character.isSpaceChar(text[i].charAt(j+1))) {
					
				}
				//Add in characters otherwise (, . ? etc...)
				else {
					characters.add(text[i].charAt(j));
				}	
				}
			//Now print everything out
			for(int c = 0; c < characters.size(); c++) {
				System.out.print(characters.get(c));
			}
			//Print a new line for next set of words
			System.out.print("\n");
			//Clear characters to check for new line
			characters.removeAll(characters);
			//reset check
			check = 0;
			}

		}
	}

	