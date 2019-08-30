import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	public static void main(String ... args) {
		Scanner input = new Scanner(System.in);
		int n_numbers = input.nextInt();
		int[] arr = new int[n_numbers];
		double mean = 0;
		int range = 0;
		int median = 0;
		int first_mode = 0;
		int second_mode = -1;
		int C = 4000;
		int numberCount[] = new int[8001];
		
		for(int i = 0; i < n_numbers; i++) {
			arr[i] = input.nextInt();
			mean += arr[i];
			numberCount[arr[i] + C]++;
		}
		
		for(int i = 0; i < numberCount.length; i++) {
			if(numberCount[i] > numberCount[first_mode]) {
				first_mode = i;
				second_mode = -1;
			} else if(numberCount[i] == numberCount[first_mode]) {
				if(second_mode == -1) {
					second_mode = i;
				}
			}
		}
		
		mean = ((mean) / n_numbers);
		mean = Math.round((mean * 10) / 10);
		Arrays.sort(arr);
		System.out.println((int) mean);
		median = arr[(n_numbers - 1) / 2];
		System.out.println(median);
		
		if(second_mode < 0) {
			System.out.println(first_mode - C);
		} else if(numberCount[first_mode] != numberCount[second_mode]) {
			System.out.println(first_mode - C);
		} else {
			System.out.println(second_mode - C);
		}
		range = arr[n_numbers - 1] - arr[0];
		System.out.println(range);
		
		input.close();
	}
}
