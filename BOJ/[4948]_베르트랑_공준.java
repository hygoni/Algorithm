import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

//Time Complexity : O(Nlog(log(N))

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner input = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int m = input.nextInt();

		while(m != 0) {
			int n = 2 * m;
			boolean isPrime[] = new boolean[n+1];
			isPrime[1] = true;
			int cnt = 0;

			for(int i = 2; i <= n; i++) {
				if(isPrime[i]) {
					continue;
				}
				for(int j = i+i; j <= n; j += i) {
					isPrime[j] = true;
				}
			}

			for(int i = m+1; i <= n; i++) {
				if(isPrime[i] == false) {
					cnt++;
				}
			}
			bw.write(cnt + "\n");
			bw.flush();
			m = input.nextInt();
		}

		bw.close();
		input.close();
	}
}

