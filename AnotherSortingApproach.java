import java.util.Scanner;

public class AnotherSortingApproach {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int arraySize = sc.nextInt(); //UpperBound
		sc.nextLine();
		String[] nums = sc.nextLine().split(" ");
		
		Integer [] numbers = new Integer[nums.length]; 
		Integer [] numbersOutput = new Integer[nums.length];
		
		for(int i = 0; nums.length > i; i++) {
			numbers[i] = Integer.parseInt(nums[i]);
		}
		
		Integer [] counts = new Integer[arraySize];
		
		//Set all the counts to 0
		for(int i = 0; counts.length > i; i++) {
			counts[i] = 0;
		}
		
		for(int i = 0; nums.length > i; i++) {
			counts[numbers[i]]++;
		}
		
		for(int i = 1; i < counts.length; i++) {
			counts[i] = counts[i-1] + counts[i];
		}
		
		for(int i = 0; numbers.length > i; i++) {
			
			//Find Last digit of first Array
			//Use that digit to find index in C array
			//Grab that index at c array and use that index to go to right position in output array
			//Put original number from First array in output
			//Minus the count of that number by 1
			if(numbers[numbers.length - i -1] != null) {
				numbersOutput[counts[numbers[numbers.length - i -1]] - 1] = numbers[numbers.length - i -1];
				counts[numbers[numbers.length - i -1]]--;
			}
			else {
				continue;
			}
			
			
		}
		for(int i = 0; numbers.length > i; i++) {
			numbers[i] = numbersOutput[i];
		}
		for(int i = 0; i < numbers.length; i++) {
			if(numbers[i] == null) {
				continue;
			}
			else if(numbers.length - 1 == i) {
				System.out.print(numbers[i]);
			}
			else {
				System.out.print(numbers[i] + " ");
			}
		}
		
	}

}
