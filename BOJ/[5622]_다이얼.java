import java.util.Scanner;

public class Main {
	
	public static int time(String line) {
		char[] arr = line.toCharArray();
		
		for(int i = 0; i < arr.length; i++) {
			if(('A' <= arr[i]) && (arr[i] <= 'C')) {
				arr[i] = 2;
			} else if(('D' <= arr[i]) && (arr[i] <= 'F')) {
				arr[i] = 3;
			} else if(('G' <= arr[i]) && (arr[i] <= 'I')) {
				arr[i] = 4;
			} else if(('J' <= arr[i]) && (arr[i] <= 'L')) {
				arr[i] = 5;
			} else if(('M' <= arr[i]) && (arr[i] <= 'O')) {
				arr[i] = 6;
			} else if(('P' <= arr[i]) && (arr[i] <= 'S')) {
				arr[i] = 7;
			} else if(('T' <= arr[i]) && (arr[i] <= 'V')) {
				arr[i] = 8;
			} else if(('W' <= arr[i]) && (arr[i] <= 'Z')) {
				arr[i] = 9;
			}
		}
		
		int totalTime = 0;
		for(int i = 0; i < arr.length; i++) {
			totalTime += arr[i] + 1;
		}
		
		return totalTime;
	}
	
	public static void main(String ... args) {
		Scanner input = new Scanner(System.in);
		String line = input.nextLine();
		int seconds = time(line);
		
		System.out.println(seconds);
		input.close();
	}
}
