import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static int gcd(int a, int b) {

		while(b != 0) {
			int r = a % b;
			a = b;
			b = r;
		}
		
		return a;
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int[] arr = new int[n];
			long sum = 0;
			
			for(int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			for(int i = 0; i < n-1; i++) {
				for(int j = i+1; j < n; j++) {
					sum += gcd(arr[i], arr[j]);
				}
			}

			System.out.println(sum);
		}
		
		br.close();
	}
}

