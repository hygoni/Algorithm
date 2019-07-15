import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		for(int i = 1; i <= n; i++) {
			int k = input.nextInt();
			int[] m = new int[11];
			m[1] = 1;
			m[2] = 2;
			m[3] = 4;
			for(int j = 4; j <= k; j++) {
				m[j] = m[j-1] + m[j-2] + m[j-3];
				
			}
			System.out.println(m[k]);
			
		}
		input.close();
	}


}
