import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int data[][] = new int[6+1][2];
		int ans = 0;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int gender = Integer.parseInt(st.nextToken());
			int grade = Integer.parseInt(st.nextToken());
			data[grade][gender]++;
		}
		br.close();
		
		for(int i = 1; i <= 6; i++) {
			for(int j = 0; j <= 1; j++) {
				if(0 < data[i][j] && data[i][j] < K) {
					ans++;
				} else {
					ans += (data[i][j] / K);
					ans += (data[i][j] % K == 0 ? 0 : 1);
				}
			}
		}
		System.out.println(ans);
	}
}
