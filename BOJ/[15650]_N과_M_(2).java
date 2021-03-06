import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int output[];
	static boolean visited[];
	public static void perm(int n, int r, int depth) {
		if(depth == r) {
			if(isAscending(output, r)) {
				print(output, r);
			}
		} else {
			for(int i = 0; i < visited.length; i++) {
				if(!visited[i]) {
					output[depth] = i+1;
					visited[i] = true;
					perm(n, r, depth+1);
					visited[i] = false;
				}
			}
		}
		
	}
	
	public static void print(int[] output, int r) {
		for(int i = 0; i < r; i++) {
			sb.append(output[i]).append(" ");
		}
		sb.append("\n");
	}
	
	public static boolean isAscending(int output[], int r) {
		for(int i = 1; i < r; i++) {
			if(output[i-1] > output[i]) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		output = new int[n];
		visited = new boolean[n];
		perm(n, r, 0);
		System.out.println(sb);
		br.close();
	}
}
