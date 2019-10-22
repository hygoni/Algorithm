import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int INF = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int t = 0; t < T; t++) {
			int n = Integer.parseInt(br.readLine());
			double maxRate = -INF;
			int goodPrice = -1;
			for(int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int gram = Integer.parseInt(st.nextToken());
				int price = Integer.parseInt(st.nextToken());
				double rate = gram / (double) price;
				int cmpResult = Double.compare(rate, maxRate);
				if(cmpResult > 0) {
					maxRate = rate;
					goodPrice = price;
				} else if(cmpResult == 0) {
					goodPrice = Math.min(price, goodPrice);
				}
			}
			sb.append(goodPrice).append("\n");
		}
		
		System.out.println(sb);
		br.close();
	}
}
