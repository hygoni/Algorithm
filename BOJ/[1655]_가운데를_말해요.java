import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> max = new PriorityQueue<Integer>(1, Collections.reverseOrder());
		PriorityQueue<Integer> min = new PriorityQueue<Integer>();
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < n; i++) {
			int num = Integer.parseInt(br.readLine());
			min.add(num);
			max.add(min.poll());
			
			if(min.size() < max.size()) {
				min.add(max.poll());
			}
			
			if(min.size() > max.size()) {
				sb.append(min.peek());
			} else {
				sb.append(Math.min(min.peek(), max.peek()));
			}
			sb.append("\n");
		}
		System.out.println(sb);
		br.close();
	}
}
