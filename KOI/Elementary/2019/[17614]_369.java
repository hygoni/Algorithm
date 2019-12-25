import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static int getClapCount(int n) {
		int ans = 0;
		while(n > 0) {
			int digit = n % 10;
			if(digit % 3 == 0 && digit > 0) {
				ans++;
			}
			n /= 10;
		}
		return ans;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int ans = 0;
		for(int i = 1; i <= N; i++) {
			ans += getClapCount(i);
		}
		
		System.out.println(ans);
		br.close();
	}
}

