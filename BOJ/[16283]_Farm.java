import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		
		int sheepAns = 0;
		int gutAns = 0;
		int cnt = 0;
		
		for(int sheep = 1; sheep < n; sheep++) {
			int gut = n-sheep;
			if(a * sheep + b * gut == w) {
				cnt++;
				sheepAns = sheep;
				gutAns = gut;
			}
		}
		
		if(cnt == 1) {
			System.out.println(String.format("%d %d", sheepAns, gutAns));
		} else {
			System.out.println(-1);
		}
		
		br.close();
	}
}

