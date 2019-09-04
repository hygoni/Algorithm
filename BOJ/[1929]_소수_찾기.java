import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

//Time Complexity : O(N root(N))

public class Main {
	
	public static boolean isPrime(int n) {
		if(n == 1) return false;
		
		for(int i = 2; i*i <= n; i++) {
			if(n % i == 0)
				return false;
		}
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		Scanner input = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int m = input.nextInt();
		int n = input.nextInt();
		
		for(int i = m; i <= n; i++) {
			if(isPrime(i)) {
				bw.write(i + "\n");
			}
				
		}
		
		bw.flush();
		bw.close();
		input.close();
	}
	
	
}

