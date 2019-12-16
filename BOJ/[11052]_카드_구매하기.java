import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int bars[] = new int[n+1];
		int d[] = new int[n+1];
		d[0] = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= n; i++) {
			bars[i] = Integer.parseInt(st.nextToken());
			d[i] = bars[i];
		}
		
		for(int i = 1; i <= n; i++) {
			int max = d[i];
			for(int j = 1; j <= i; j++) {
				max = Math.max(max, bars[j] + d[i-j]);
			}
			d[i] = max;
		}
		System.out.println(d[n]);
		br.close();
	}
}
