import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static boolean visited[];
	static StringBuilder sb;
	static int arr[];
	public static void combination(int n, int m, int size) {
		if(size == m) {
			for(int i = 0; i < m; i++){
				sb.append(arr[i]).append(" ");
			}
			sb.append("\n");
			return;
		}

		for(int i = 1; i <= n; i++) {
			if(visited[i] == false) {
				visited[i] = true;
				arr[size] = i;
				combination(n, m, size + 1);
				visited[i] = false;
			}
		}
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		br.close();
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		sb = new StringBuilder();
		arr = new int[m];
		visited = new boolean[n+1];
		combination(n, m, 0);
		System.out.println(sb);
	}
}
