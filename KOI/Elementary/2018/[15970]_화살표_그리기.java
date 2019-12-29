import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		List<Integer> data[] = new ArrayList[n+1];
		
		for(int i = 1; i <= n; i++) {
			data[i] = new ArrayList<Integer>();
		}
		
		for(int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int color = Integer.parseInt(st.nextToken());
			data[color].add(p);
			Collections.sort(data[color]);
		}
		
		int ans = 0;
		//color
		for(int i = 1; i <= n; i++) {
			if(data[i].size() == 1) {
				continue;
			}
			//point
			for(int j = 0; j < data[i].size(); j++) {	
				if(j == 0) {
					ans += (data[i].get(j+1) - data[i].get(j));
				} else if(j == data[i].size()-1) {
					ans += (data[i].get(j) - data[i].get(j-1));
				} else {
					ans += Math.min(data[i].get(j) - data[i].get(j-1), data[i].get(j+1) - data[i].get(j));
				}
			}
		}
		
		System.out.println(ans);		 
		br.close();
	}
}
