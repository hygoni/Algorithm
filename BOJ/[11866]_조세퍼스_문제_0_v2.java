import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		LinkedList<Integer> q = new LinkedList<Integer>();
		
		
		for(int i = 1; i <= n; i++) {
			q.add(i);
		}
		
		sb.append("<");
		int th = 1;
		while(!q.isEmpty()) {
			if(th % k == 0) {
				sb.append(q.poll());
				if(q.size() > 0) {
					sb.append(", ");
				} else {
					sb.append(">");
				}
			} else {
				q.add(q.poll());
			}
			th++; 
		}
		System.out.println(sb);
		br.close();
	}
}
