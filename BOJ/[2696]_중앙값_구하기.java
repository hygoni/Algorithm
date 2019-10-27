import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int t = 0; t < T; t++) {
			PriorityQueue<Integer> max = new PriorityQueue<Integer>(1, Collections.reverseOrder());
			PriorityQueue<Integer> min = new PriorityQueue<Integer>();
			int n = Integer.parseInt(br.readLine());
			int b = (n-1) / 10 + 1;
			int printed = 0;
			int cnt = 1;
			sb.append((n-1)/2 + 1).append("\n");
			for(int i = 0; i < b; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				while(st.hasMoreTokens()) {
					int num = Integer.parseInt(st.nextToken());
					min.add(num);
					max.add(min.poll());		
					if(min.size() < max.size()) {
						min.add(max.poll());
					}
					if(cnt++ % 2 == 1) {
						sb.append(min.peek()).append(" ");
						printed++;
					}
				}
				if(printed % 9 == 1) {
					sb.append("\n");
					printed = 0;
				}
			}
		}
		System.out.print(sb);
		br.close();
	}
}
