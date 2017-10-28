import java.util.ArrayList;
import java.util.Scanner;
//Problem is just 2nd half of merge sort

public class FindingCommonElementsInTwoSortedLists {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String numbersz1 = sc.nextLine();
		String[] numbers1 = numbersz1.split(" ");
		Integer[] array1 = inNumbers(numbers1);
		String numbersz2 = sc.nextLine();
		String[] numbers2 = numbersz2.split(" ");
		Integer[] array2 = inNumbers(numbers2);
		ArrayList<Integer> newArray = new ArrayList<Integer>();
		
		int i = 0;
		int j = 0;
		
		
		while(i < array1.length && j < array2.length) {
			//Deal with index if it is 0
			if(array1.length == 1 && array2.length == 1) {
				if(numbers1[i].equals(numbers2[j])) {
					newArray.add(array1[i]);
					break;
				}
				else {
					break;
				}
				
			}
			else if(array1.length == 1) {
				if(numbers1[i].equals(numbers2[j])){
					newArray.add(array1[i]);
					j++;
					continue;
				}
				else{
					j++;
					continue;
				}
			}
			else if(array2.length == 1) {
				if(numbers1[i].equals(numbers2[j])){
					newArray.add(array2[j]);
					i++;
					continue;
				}
				else{
					i++;
					continue;
				}
				
			}
			//Have to deal with it when it is at the end of the loop
			if(array1.length - 1 == i && array2.length - 1 == j) {
				if(numbers1[i].equals(numbers2[j])) {
					newArray.add(array1[i]);
					break;
				}
				else {
					break;
				}
				
			}
			else if(array1.length - 1 == i && array2.length - 1 > j) {
				if(numbers1[i].equals(numbers2[j])) {
					newArray.add(array1[i]);
					j++;
					continue;
				}
				else {
					j++;
					continue;
				}
			}
			else if(array1.length - 1 > i && array2.length - 1 == j) {
				if(numbers1[i].equals(numbers2[j])) {
					newArray.add(array1[i]);
					i++;
					continue;
				}
				else {
					i++;
					continue;
				}
			}
			
			//For if its normal
			if(numbers1[i].equals(numbers2[j])) {
				newArray.add(array1[i]);
				i++;
				j++;
				continue;
			}
			else if(array1[i] > array2[j]) {
				j++;
				continue;
			}
			else if(array1[i] < array2[j]) {
				i++;
				continue;
			}
			
		}
		
		if(newArray.isEmpty()) {
			System.out.print("NO COMMON INTEGERS");
			System.exit(10); //Can be any number as long its not 0
		}
		//Remove duplicates by creating a new array without duplicates then print the fourth new array
		for(int t = 0; t < newArray.size()- 1; t++) {
			if(newArray.get(t) == newArray.get(t+1)) {
				newArray.remove(t);
			}
		}
		//Have to a double check because we aren't putting the new ones into
		for(int t = 0; t < newArray.size()- 1; t++) {
			if(newArray.get(t) == newArray.get(t+1)) {
				newArray.remove(t);
			}
		}
		
		for(int t = 0; t < newArray.size(); t++) {
			if(t == newArray.size() - 1) {
				System.out.print(newArray.get(t));
			}
			else {
				System.out.print(newArray.get(t) + " ");
			}
		}
		sc.close();
		
		}
	
	public static Integer [] inNumbers(String [] numbers){
		Integer[] numbers1 = new Integer[numbers.length];
		for(int i = 0; i < numbers.length; i++) {
			numbers1[i] = Integer.parseInt(numbers[i]);
		}
		return numbers1;
	}
		
	}
