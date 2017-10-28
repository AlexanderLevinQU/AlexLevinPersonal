import java.util.Scanner;

public class BoomerAtGiftShop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int howManyCases = sc.nextInt();
		int [] triggerString = new int[howManyCases];


		for(int i = 0; howManyCases > i; i++) {
			int howManyPurchases = sc.nextInt();
			int total = 0;
			for(int j = 0; howManyPurchases > j; j++) {
				int items = sc.nextInt() * 100;
				double price = sc.nextDouble() * 100;

				total = (int) ((items * price) + total);

			}

			double boomersCash = sc.nextDouble();
			boomersCash = boomersCash * (100 * 100);
			
			if(boomersCash > total) {
				triggerString[i] = 1;
				//System.out.println("BOOMER HAS MORE THAN ENOUGH");
			}
			else if(boomersCash < total) {
				triggerString[i] = 2;
			//	System.out.println("BOOMER NEEDS MORE MONEY");
			}
			else if (boomersCash == total) {
			//	System.out.println("BOOMER HAS THE EXACT AMOUNT HE NEEDS");
				triggerString[i] = 3;

			}
		
		}
		
		for(int i = 0; howManyCases > i; i++) {
			if(triggerString[i] == 1) {
				System.out.println("BOOMER HAS MORE THAN ENOUGH");
			}
			else if(triggerString[i] == 2) {
				System.out.println("BOOMER NEEDS MORE MONEY");
			}
			else if (triggerString[i] == 3) {
				System.out.println("BOOMER HAS THE EXACT AMOUNT HE NEEDS");

			}
			
		}
		sc.close();


	}

}
