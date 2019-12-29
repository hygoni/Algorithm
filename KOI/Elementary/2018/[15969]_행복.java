import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int min = 1000;
		int max = 0;
		for(int i = 0; i < n; i++) {
			int score = Integer.parseInt(st.nextToken());
			min = Math.min(min, score);
			max = Math.max(max, score);
		}
		System.out.println(max-min);
		br.close();
	}
}
