import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int INF = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int t = 0; t < T; t++) {
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int cost[] = new int[n+1];
			int d[][] = new int[n+1][n+1];
			int sum[] = new int[n+1];
			
			for(int i = 1; i <= n; i++) {
				cost[i] = Integer.parseInt(st.nextToken());
			}
			
			for(int i = 1; i <= n; i++) {
				sum[i] = sum[i-1] + cost[i];
			}
			
			for(int k = 1; k < n; k++) {
				for(int i = 1; i <= n-k; i++) {
					d[i][i+k] = INF;
					for(int j = i; j < i + k; j++) {
						d[i][i+k] = Math.min(d[i][i+k], d[i][j] + d[j+1][i+k]); 
					}
					d[i][i+k] += sum[i+k] - sum[i-1];
				}
			}
			sb.append(d[1][n]).append("\n");
		}
		System.out.println(sb);
		br.close();
	}
}

