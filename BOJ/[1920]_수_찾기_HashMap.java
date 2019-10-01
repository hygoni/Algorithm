import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Set;
import java.util.StringTokenizer;


public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();

		for(int i = 0; i < n; i++) {
			map.put(Integer.parseInt(st.nextToken()), true);
		}

		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int target[] = new int[m];
		for(int i = 0; i < m; i++) {
			target[i] = Integer.parseInt(st.nextToken());
		}

		Set<Integer> keySet = map.keySet();
		for(int i = 0; i < m; i++) {
			int t = target[i];
			int ans = (keySet.contains(t)) ? 1 : 0; 
			bw.write(ans + "\n");
		}

		bw.flush();
		bw.close();
		br.close();

	}
}

