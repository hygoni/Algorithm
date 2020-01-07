import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int ans = 0;
		
		for(int i = 0; i < 5; i++) {
			int n = Integer.parseInt(st.nextToken());
			ans += (n*n);
		}
		
		System.out.println(ans % 10);		
		br.close();
	}
}
