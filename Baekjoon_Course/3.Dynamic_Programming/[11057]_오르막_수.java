import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		
		int num[][] = new int[n][10];
		
		
		for(int i = 0; i < 10; i++) {
			num[0][i] = 1; //맨 처음엔 다 1개씩 있음
		}

		for(int i = 1; i < n; i++) {
			for(int j = 0; j < 10; j++) {
				int sum = 0;
				for(int k = 9-j; k < 10; k++) {
					sum += num[i-1][9-k];
					sum %= 10_007;
				}
				num[i][j] = sum;
				
			}
		}
		
		//n자리의 오르막 수의 개수 출력
		int sum = 0;
		for(int i = 0; i < 10; i++) {
			sum += num[n-1][i];
		}
		
		System.out.println(sum % 10_007);
		
		input.close();

	}


}
