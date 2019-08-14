//Type of problem : Ad Hok

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String line;
		while(false == (line = input.nextLine()).isEmpty()) {
			StringTokenizer tokenizer = new StringTokenizer(line, " ");
			int n_members = Integer.parseInt(tokenizer.nextToken());
			int budget = Integer.parseInt(tokenizer.nextToken());
			int n_hotels = Integer.parseInt(tokenizer.nextToken());
			int n_weeks = Integer.parseInt(tokenizer.nextToken());
			int[] min_costs = new int[n_hotels];
			
			for(int i = 0; i < n_hotels; i++) {
				int[] beds = new int[n_weeks];
				int[] costs = new int[n_weeks];
				int price = Integer.parseInt(input.nextLine());
				line = input.nextLine();
				tokenizer = new StringTokenizer(line, " ");
				for(int j = 0; j < n_weeks; j++) {
					beds[j] = Integer.parseInt(tokenizer.nextToken());
				}
				for(int j = 0; j < n_weeks; j++) {
					if(beds[i] < n_members) {
						costs[j] = -1;
					} else {
						costs[j] = price * n_members;
					}
				}
				Arrays.sort(costs);
				if(costs[n_weeks-1] == -1) {
					min_costs[i] = -1;
				} else {
					for(int j = 0; j < n_weeks; j++) {
						if(costs[i] != -1) {
							min_costs[i] = costs[i]; 
							break;
						}
					}
				}
			}
			
			Arrays.sort(min_costs);
			if(min_costs[n_hotels-1] == -1) {
				System.out.println("stay home");
			} else {
				for(int i = 0; i < n_hotels; i++) {
					if(min_costs[i] != -1) {
						if(min_costs[i] > budget) {
							System.out.println("stay home");
						} else {
							System.out.println(min_costs[i]);
							break;
						}
					}
				}
			}
		}
		
		input.close();
	}

}
