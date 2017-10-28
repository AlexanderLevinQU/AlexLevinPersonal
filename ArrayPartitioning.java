import java.util.Scanner;

public class ArrayPartitioning {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Integer pivot = sc.nextInt();
		

		sc.nextLine(); //Create space

		String [] numbers = sc.nextLine().split(" ");
		Integer [] numbersInts = new Integer[numbers.length];
		for(int i = 0; numbers.length > i; i++) {
			numbersInts[i] = Integer.parseInt(numbers[i]);
		}

		for(int i = 0; numbers.length > i; i++){
			for(int j = i + 1; numbers.length > j; j++ ) {
				if(numbersInts[i] > pivot) {
					Integer temp = numbersInts[i];
					numbersInts[i] = numbersInts[j];
					numbersInts[j] = temp;
				}
				
			}
			
		}
		
		for(int i = 0; numbers.length > i; i++) {
			if(numbers.length - 1 == i) {
				System.out.print(numbersInts[i]);
			}
			else {
				System.out.print(numbersInts[i] + " ");
			}

		}


	}

}
