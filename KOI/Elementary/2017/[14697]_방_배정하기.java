import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		br.close();
		
		int ans = 0;
		for(int i = 0; i <= N; i++) {
			for(int j = 0; j <= N; j++) {
				for(int k = 0; k <= N ;k++) {
					if(i*A+B*j+C*k == N) {
						ans = 1;
						break;
					}
				}
			}
		}
		
		System.out.println(ans);		
		
	}
}
