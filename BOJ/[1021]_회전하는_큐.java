import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		LinkedList<Integer> deq = new LinkedList<Integer>();
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		for(int i = 1; i <= n; i++) {
			deq.add(i);
		}
		
		st = new StringTokenizer(br.readLine());
		int answer = 0;
		for(int i = 0; i < m; i++) {
			int target = Integer.parseInt(st.nextToken());
			int index = deq.indexOf(target);
			int left = index;
			int right = deq.size()-index+1;
			if(left < right) {
				while(deq.peek() != target) {
					deq.add(deq.poll());
					answer++;
				}
				deq.poll();
			} else {
				while(deq.peek() != target) {
					deq.addFirst(deq.pollLast());
					answer++;
				}
				deq.poll();
			}
		}
		System.out.println(answer);
		br.close();
	}
}
