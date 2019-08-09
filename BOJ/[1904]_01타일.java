import java.util.Scanner;


public class Main {
	
	public static void main(String[] args) {
			
		
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int[] memo = new int[n];
		memo[0] = 1;
		memo[1] = 2;
		for(int i = 2; i < n; i++) {
			memo[i] = (memo[i-1] + memo[i-2]) % 15746;
		}
		System.out.println(memo[n-1] % 15746);
		input.close();
		
	}

}
