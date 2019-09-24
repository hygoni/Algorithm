import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;

public class EatingWines {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine()); // 1 <= N <= 1백만
		long n_2 = 0;
		long n_1 = 1;
		long fibo_n;
		for(int i = 2; i < n; i++) {
			fibo_n = (n_1 + n_2) % 1_000_000_007;
			n_2 = n_1;
			n_1 = fibo_n;
		}
		
		if(n == 0) {
			bw.write("0\n");
		} else {
			bw.write((n_2 + n_1) % 1_000_000_007 + "\n");
		}
		bw.flush();
		br.close();
		bw.close();
	}
}

