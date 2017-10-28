import java.util.Scanner;
import java.util.ArrayList;
public class SearchingForPrefixes {
/* The time complexity of this program is Big O(n^2)
 * This is because nested loops are used to iterate through the loop n times and when its two loops thats n^2
 * 
 * The Space complexity of this program is Big O(n)
 * This is because array lengths such as trigger and textChar or O(n) length 
 * and nothing else changes data types
 * 
 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
				
		String pattern = sc.nextLine();
		String text = sc.nextLine();
		
		ArrayList<Character> patternChar = new ArrayList<Character>();
		ArrayList<Character> textChar = new ArrayList<Character>();
		
		//put them into character array
		for(int i = 0; text.length() > i; i++) {
			textChar.add(text.charAt(i));
			
			if(pattern.length() > i) {
			patternChar.add(pattern.charAt(i));
			}
		}
		//Create a trigger array
		Integer [] trigger = new Integer[textChar.size()];
		int t = 0;

		//Now have to search the text for the pattern
		for(int i = 0; textChar.size() > i ; i++) {
			
			if(i == 0) {
				//check if i is equal to first of pattern to check for pattern
				if(textChar.get(i).equals(patternChar.get(0))) {
					for(int j = 0; patternChar.size() > j; j++) {
						//now check if the next are equal
						if(textChar.get(i + j).equals(patternChar.get(j))) {
							//now check if its the last one
							if(j == patternChar.size() - 1) {
								trigger[t] = i;
								t++;
							}

						}
						//If one of them isn't it does a break
						else {
							break;
						}
					}	
				}	
			}
			//Check if the first one of each is a match and the start of a word
			else if(i > 0) {
				if(textChar.get(i).equals(patternChar.get(0)) && Character.isSpaceChar(textChar.get(i-1)) == true) {
					for(int j = 0; patternChar.size() > j; j++) {
						//now check if the next are equal
						if(textChar.get(i + j).equals(patternChar.get(j))) {
							//now check if its the last one
							if(j == patternChar.size() - 1) {
								trigger[t] = i;
								t++;
							}
						}
						else {
							break;
						}
					}	
					 
					
				}
			}
			
		}
		//reset trigger count back to 0
		t = 0;
		
		//If it doesn't have any words matching
		if(trigger[0] == null) {
			System.out.println(" ***A word containing the given prefix was not found.***");
		}

		//Now print them at the right triggers
		for(int i = 0; textChar.size() > i; i++) {
			//check if trigger t is equal to i
			if(trigger[t] != null && trigger[t] == i) {
				//now print everything until j + 1 is a nonalphabetic character
				System.out.print(textChar.get(i));
				//print them out as long as they aren't anything besides normal letters if they are end the loop
				for(int j = i+1; textChar.size() > j; j++) {
					if(!(Character.isAlphabetic(textChar.get(j)))) {
						break;
					}
					System.out.print(textChar.get(j));

				}
				
				//new line for next word and so you can check int in trigger array
				t++;
				System.out.print("\n");
			}
			

		}
		
		
		

	}

}
