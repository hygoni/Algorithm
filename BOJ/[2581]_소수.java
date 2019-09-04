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
		int cnt = 0;
		int min = 0;
		int sum = 0;
		
		for(int i = m; i <= n; i++) {
			if(isPrime(i)) {
				if((min > i) || (min == 0)) {
					min = i;
				}
				sum += i;
				cnt++;
			}
				
		}
		
		if(cnt == 0) {
			bw.write(-1 + "\n");
		} else {
			bw.write(sum + "\n");
			bw.write(min + "\n");
		}
		
		bw.flush();
		bw.close();
		input.close();
	}
	
	
}

