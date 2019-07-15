import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int[] m = new int[n+1];
		m[0] = 1;
		m[1] = 1;
		for(int i = 2; i <= n; i++) {
			m[i] = ( m[i-1] + m[i-2] ) % 10007;
		}
		System.out.println(m[n]);
	}


}
