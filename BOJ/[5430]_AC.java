import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static <T> String listToString(List<T> list) {
		StringBuilder sb = new StringBuilder();
		Iterator<T> iter = list.iterator();
		sb.append("[");
		while(iter.hasNext()) {
			sb.append(iter.next());
			if(iter.hasNext()) {
				sb.append(",");
			}
		}
		sb.append("]");
		return sb.toString();
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		next:
		for(int t = 0; t < T; t++) {
			String cmd = br.readLine();
			int n = Integer.parseInt(br.readLine());
			String list = br.readLine();
			list = list.substring(1, list.length()-1);
			StringTokenizer st = new StringTokenizer(list, ",");
			boolean isRotated = false;
			LinkedList<Integer> deq = new LinkedList<Integer>();
			
			while(st.hasMoreTokens()) {
				deq.add(Integer.parseInt(st.nextToken()));
			}
			
			for(int i = 0; i < cmd.length(); i++) {
				char ch = cmd.charAt(i);
				if(ch == 'R') {
					isRotated = !isRotated;
				} else {
					if(deq.size() == 0) {
						sb.append("error\n");
						continue next;
					}
					if(isRotated) {
						deq.pollLast();
					} else {
						deq.poll();
					}
				}
			}
			if(isRotated) {
				Collections.reverse(deq);
			}
			sb.append(listToString(deq)).append("\n");
		}
		System.out.println(sb);
		br.close();
	}
}
