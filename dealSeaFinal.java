package advProblemSolvingFinalProject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class dealSeaFinal {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		JFrame parent = new JFrame();
		System.out.println("What are you searching for");
		String keywords = sc.nextLine();
		String [] keywordsArray = keywords.split(" ");
		sc.nextLine(); //Get Space
		System.out.print("How many minutes do you want it to run before stopping and doing again: ");
		int timeInMinutes = sc.nextInt();
		keywords.trim(); //Get rid of excess Spaces because they give special characters

		if(keywordsArray.length > 1) {
			keywords.replaceAll(" ", "+");
		}

		Runnable getData = new Runnable() {
			public void run() {
				//Get information from website
				String url = "https://dealsea.com/search?q="+keywords+"&search_mode=Deals";
				Document document = null;
				try {
					document = Jsoup.connect(url).get();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Elements allContent = document.select(".dealcontent");
				Elements titles = document.select(".dealcontent strong a");


				ArrayList<Integer> triggerExpired = new ArrayList<Integer>();
				ArrayList<String> realDeals = new ArrayList<String>();
				ArrayList<String> linksOfDeals = new ArrayList<String>();

				for (Element expired: allContent) {
					String lowerText = expired.text().toLowerCase();
					if(lowerText.contains("expired")) {
						triggerExpired.add(1);
					}else {
						triggerExpired.add(0);
					}
				}
				//Figure OUT A WAY TO COMBINE BOTH TO COMPARE
				//PROBABLY HAVE TO SELECT A BIGGER SCOPE TO FIX THIS PROBLEM
				int i = 0; //i is the count
				for (Element title : titles) {
					String lowerTitle = title.text().toLowerCase();
					if(lowerTitle.contains(keywords.toLowerCase())) {
						if(triggerExpired.get(i) == 0) {
							realDeals.add(title.text());//Add element into list now check for price + and go to them
							linksOfDeals.add(title.attr("abs:href"));

						}
					}
					i++;

				}
				ArrayList<Integer> prices = getPrices(linksOfDeals);
				//Find Min to show!
				Integer minPIndex = prices.indexOf(Collections.min(prices));
				String bestDeal = realDeals.get(minPIndex);
				JOptionPane.showMessageDialog(parent, bestDeal);
			}
		};
		ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
		executor.scheduleAtFixedRate(getData, 0, timeInMinutes, TimeUnit.MINUTES);
		sc.close();
	}

	public static ArrayList<Integer> getPrices(ArrayList<String> links){
		ArrayList<Integer> prices = new ArrayList<Integer>();
		for(int i = 0; links.size() > i; i++) {
			/*
			 * Still not really sure how to deal with multiple prices in a deal
			 * with this algorithm it will just get rid of 2 prices from one of the possible deals
			 * because the number will be way to high
			 * Probably should find all prices and split
			 */
			Document document = null;
			try {
				document= Jsoup.connect(links.get(i)).get();
			}
			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Elements price = document.select("#dealTitle span.price");

			for(Element thePrice : price) {
				StringBuilder sPrice = new StringBuilder(thePrice.text());
				if(!(sPrice.toString().contains("$"))) continue;
				//Remove all characters in the string that aren't numeric
				for(int j = 0; j < sPrice.length(); j++) {
					Character c = sPrice.charAt(j);
					if(Character.isDigit(c)) {
						continue;
					}else {
						sPrice = sPrice.deleteCharAt(j);
						j--; //Have to keep setting the count lower if deleted
					}
				}
				try {
					Integer actPrice = Integer.parseInt(sPrice.toString().trim());
					prices.add(actPrice);
				}
				catch(Exception e){
					continue;
				}
			}
		}
		return prices;
	}

}

