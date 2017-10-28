 import java.util.Scanner;

public class KeywordSearch_CaseInsensitive {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String searchedWord = sc.nextLine();
		String text = sc.nextLine();
		int count = 0;
		int wordCount = 0;

		Character [] searching = new Character[searchedWord.length()];
		Character [] text2 = new Character[text.length()];

		//Make them into character arrays so comparing is easier
		for(int i = 0; text2.length > i; i++) {
			if(searching.length > i) {
				searching[i] = searchedWord.charAt(i);
				searching[i] = Character.toLowerCase(searching[i]);
			}
			text2[i] = text.charAt(i);
			text2[i] = Character.toLowerCase(text2[i]);
		}

		//Start checks in text 
		for(int i = 0; text.length() > i; i++) {
			if(Character.isAlphabetic(text2[i]) == true) {
				//If the text is equal to the first letter
				if(text2[i].compareTo(searching[0]) == 0) {
					for(int j = 1; searching.length > j; j++) {
						//Check if the next oneis alphabetic ->DONTNEEDTHISIF YOU CHECK IF ITS EQUAL TO NEXT ONE
						if(Character.isAlphabetic(text2[i + j])) {
							//Check if they are the same (searching and text)
							if(text2[i + j].compareTo(searching[j]) == 0) {
								//Check if length is to big(pattern fits in text)
								if(i < text2.length - searching.length) {
									//Check if one under it is a letter 
									if(Character.isAlphabetic(text2[searching.length + i]) == false){
										//check if the one past is a letter
										if(i == 0) {
											count++; //Add one to correct letters
											if(count == searching.length - 1)/*whiteSpace*/ {
												wordCount++; //Add one to the word count
											}
										}
										//Check if one behind isn't a letter(so its its own word)
										else if(Character.isAlphabetic(text2[i-1]) == false) {
											count++;


											if(count == searching.length - 1)/*whiteSpace*/ {
												wordCount++;
											}

										}	//Check if pattern is at end of word and make sure that doesn't count
									}

								}
								//If its equal to i then you don'tneed to check if 1 after or 1 behind is a letter
								else if(text2.length - searching.length < i || text2.length - searching.length == i ) {
									count++;

									if(i == 0) {
										count++;
										if(count == searching.length - 1)/*whiteSpace*/ {
											wordCount++;
										}
									}
									
									//check if 1 behind is a letter
									else if(Character.isAlphabetic(text2[i-1]) == false) {
										count++;

										if(count == searching.length - 1)/*whiteSpace*/ {
											wordCount++;
										}

									}	//Check if pattern is at end of word and make sure that doesn't count

								}

							}

						}

					}

				}

			}
			count = 0;

		}

		System.out.println(wordCount);
		sc.close();
	}
}

