import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

class AbsComparator implements Comparator<Integer> {

	@Override
	public int compare(Integer x, Integer y) {
		int absX = Math.abs(x);
		int absY = Math.abs(y);
		if(absX == absY) {
			return Integer.compare(x, y);
		} else {
			return Integer.compare(absX, absY);
		}
	}
	
}
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> q = new PriorityQueue<Integer>(1, new AbsComparator());
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < n; i++) {
			int x = Integer.parseInt(br.readLine());
			if(x == 0) {
				Integer min = q.poll();
				if(min == null) {
					min = 0;
				}
				sb.append(min).append("\n");
			} else {
				q.add(x);
			}
		}
		System.out.print(sb);
		br.close();
	}
}
