import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int[][] num = new int[10][101];
		
		for(int i = 0; i < 10; i++) {
			if(i == 0)
				num[i][1] = 0;
			else
				num[i][1] = 1;
		}
		
		for(int i = 2; i <= n; i++) {
			for(int j = 0; j < 10; j++) {
				if(j == 0) {
					num[j][i] = num[j+1][i-1];
				}
				else if(j == 9) {
					num[j][i] = num[j-1][i-1];
				}
				else {
					num[j][i] = ( num[j-1][i-1] + num[j+1][i-1] ) % 1_000_000_000;
				}
			}
		}
		
		long sum = 0;
		for(int i = 0; i < 10; i++) {
			sum += num[i][n];
		}
		System.out.println(sum % 1_000_000_000);
		
	}


}
