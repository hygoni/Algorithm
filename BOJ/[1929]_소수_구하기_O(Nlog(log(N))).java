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
		int n = input.nextInt();
		
		boolean isPrime[] = new boolean[n+1];
		isPrime[1] = true;
		
		for(int i = 2; i <= n; i++) {
			if(isPrime[i]) {
				continue;
			}
			for(int j = i+i; j <= n; j += i) {
				isPrime[j] = true;
			}
		}
		
		for(int i = m; i <= n; i++) {
			if(isPrime[i] == false) {
				bw.write(i + "\n");
			}
		}
		
		bw.flush();
		bw.close();
		input.close();
	}
	
	
}

