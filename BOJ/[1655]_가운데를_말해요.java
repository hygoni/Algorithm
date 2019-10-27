import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(1, Collections.reverseOrder());
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < n; i++) {
			int num = Integer.parseInt(br.readLine());
			if(maxHeap.size() <= minHeap.size()) {
				maxHeap.add(num);
			} else {
				minHeap.add(num);
			}
			
			if(maxHeap.size() > 0 && minHeap.size() > 0 && maxHeap.peek() > minHeap.peek()) {
				minHeap.add(maxHeap.poll());
				maxHeap.add(minHeap.poll());
			}
			
			int size = maxHeap.size() + minHeap.size();
			if(size % 2 == 0) {
				sb.append(Math.min(maxHeap.peek(), minHeap.peek())).append("\n");
			} else {
				sb.append(maxHeap.peek()).append("\n");
			}
		}
		System.out.println(sb);
		br.close();
	}
}
