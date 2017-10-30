import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
public class BoomerBackAtGiftShop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int howManyCases = sc.nextInt();
		int check = 0;
		int [] trigger = new int [howManyCases];


		for(int i = 0; howManyCases > i; i++) {
			int howManyPurchases = sc.nextInt();
			int total = 0;
			int totalItems = 0;
			ArrayList<Double> prices = new ArrayList<Double>();
			ArrayList<Integer> numberOfItems = new ArrayList<Integer>();
			for(int j = 0; howManyPurchases > j; j++) {
				int items = sc.nextInt() * 100;
				numberOfItems.add(items);
				double price = sc.nextDouble() * 100;
				prices.add(price);

			}
			double boomersCash = sc.nextDouble();
			boomersCash = boomersCash * (100 * 100);

			//Check which one was the least price
			while(total <= boomersCash && prices.size() > 0) {
				int minIndexP = prices.indexOf(Collections.min(prices)); //Got min price
				//Find how many items I can add
				for(int j = 0; j < numberOfItems.get(minIndexP); j++) {
					total = (int) (prices.get(minIndexP) * 1) + total;
					if(total <= boomersCash) {
						totalItems = 1 + totalItems;
					}
					else {
						trigger[i] = totalItems/100;
						check = -1;
						break;
					}
				}
				if(total > boomersCash) {
					break;
				}
				numberOfItems.remove(minIndexP);
				prices.remove(minIndexP);
			}
			if(check == 0) {
				trigger[i] = totalItems/100;
			}
			check = 0;

		}
		for(int i = 0; trigger.length > i; i++) {
			System.out.println(trigger[i]);
		}

	}
}

