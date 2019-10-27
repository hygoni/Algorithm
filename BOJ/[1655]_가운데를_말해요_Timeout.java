import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		List<Integer> list = new ArrayList<Integer>();
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < n; i++) {
			
			int x = Integer.parseInt(br.readLine());
			list.add(x);
			Collections.sort(list);
			int size = list.size();
			if(size % 2 == 0) {
				sb.append(Math.min(list.get(size/2), list.get(size/2-1))).append("\n");
			} else {
				sb.append(list.get(size/2)).append("\n");
			}
			
		}
		System.out.print(sb);
		br.close();
	}
}
