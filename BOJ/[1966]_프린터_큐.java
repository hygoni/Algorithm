import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Document implements Comparable<Document>{
	int value, idx;
	public Document(int value, int idx) {
		this.value = value;
		this.idx = idx;
	}
	@Override
	public int compareTo(Document o) {
		return Integer.compare(this.value, o.value);
	}
	
	@Override
	public String toString() {
		return Integer.toString(value);
	}
}

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int idx = Integer.parseInt(st.nextToken());
			Deque<Document> q = new LinkedList<Document>();
			PriorityQueue<Document> max = new PriorityQueue<Document>(Collections.reverseOrder());
			st = new StringTokenizer(br.readLine());
			
			for(int i = 0; i < n; i++) {
				Document doc = new Document(Integer.parseInt(st.nextToken()), i);
				max.add(doc);
				q.add(doc);
			}
			
			int cnt = 0;
			while(!q.isEmpty()) {
				if(q.peek().value < max.peek().value) {
					q.add(q.poll());
				} else {
					cnt++;
					if(q.peek().idx == idx) {
						break;
					}
					q.poll();
					max.poll();
				}
			}
			sb.append(cnt).append("\n");
		}
		System.out.print(sb);
		br.close();
	}
}
