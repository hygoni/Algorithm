//Type of problem : Ad Hok

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		
		for(int i = 0; i < n; i++) {
			int[] arr = new int[3];
			arr[0] = input.nextInt();
			arr[1] = input.nextInt();
			arr[2] = input.nextInt();
			
			Arrays.sort(arr);
			System.out.println(String.format("Case %d: %d", i+1, arr[1]));
		}
		
		input.close();
	}

}
