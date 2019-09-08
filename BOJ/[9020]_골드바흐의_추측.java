import java.util.Scanner;

public class Main {

	public static void main(String[] args) {	 
		Scanner input = new Scanner(System.in);
		int T = input.nextInt();
		boolean isNotPrime[] = new boolean[10000+1];
		StringBuilder sb = new StringBuilder();
		isNotPrime[0] = true;
		for(int i = 2; i <= 10000; i++) {
			for(int j = i + i; j <= 10000; j+=i) {
				isNotPrime[j-1] = true;
			}
		}

		for(int t = 0; t < T; t++) {
			int n = input.nextInt();
			int left = 0;
			int right = 0;
			int diff = 100000;
			for(int i = 2; i <= 10000; i++) {
				if(isNotPrime[i-1] == false) {
					if(i >= n) {
						break;
					}
					int j = n-i;
					if(isNotPrime[j-1] == true) {
						continue;
					} else {
						if(diff > Math.abs(i-j)) {
							diff = Math.abs(i-j);
							left = i;
							right = j;
						}
					}
				}
			}
			sb.append(left + " " + right + "\n");
		}
		System.out.println(sb);
		input.close();
	}
}

