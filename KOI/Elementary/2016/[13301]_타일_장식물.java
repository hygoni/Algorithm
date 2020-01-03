import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long fibo[] = new long[N+1];
		long perimeter[] = new long[N+1];

		fibo[1] = 1;
		if(N >= 2) {
			fibo[2] = 1;			
		}
		for(int i = 3; i <= N; i++) {
			fibo[i] = fibo[i-1] + fibo[i-2];
		}
		
		perimeter[1] = 4;
		if(N >= 2) {
			perimeter[2] = 6;
		}
		for(int i = 3; i <= N; i++) {
			perimeter[i] = 2 * (fibo[i-1] + fibo[i]) + 2 * fibo[i];
		}
		
		System.out.println(perimeter[N]);
	}
}

