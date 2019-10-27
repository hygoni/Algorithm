import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> q = new PriorityQueue<Integer>(1, Collections.reverseOrder());
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < n; i++) {
			int x = Integer.parseInt(br.readLine());
			if(x == 0) {
				Integer max = q.poll();
				if(max == null) {
					max = 0;
				}
				sb.append(max).append("\n");
			} else {
				q.add(x);
			}
		}
		System.out.print(sb);
		br.close();
	}
}
