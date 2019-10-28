import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		LinkedList<Integer> q = new LinkedList<Integer>();
		
		for(int i = 1; i <= n; i++) {
			q.add(i);
		}
		
		while(q.size() > 1) {
			q.poll();
			if(q.size() > 1) {
				q.add(q.poll());
			}
		}
		System.out.println(q.poll());
		br.close();
	}
}
