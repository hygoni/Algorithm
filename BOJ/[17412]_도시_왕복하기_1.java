import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Edge {
	int dst, weight;
	public Edge(int dst, int weight) {
		this.dst = dst;
		this.weight = weight;
	}
}

public class Main {
	static int graph[][];
	static int prev[];
	static int N, M;
	static int INF = Integer.MAX_VALUE;
	static int residual[][];
	public static boolean bfs(int src, int dst) {
		Queue<Integer> q = new LinkedList<Integer>();
		boolean visited[] = new boolean[N+1];
		visited[src] = true;
		q.add(src);
		prev[src] = -1;
		
		while(!q.isEmpty()) {
			int u = q.poll();
			for(int v = 1; v <= N; v++) {
				if(!visited[v] && residual[u][v] > 0) {
					prev[v] = u;
					q.add(v);
					visited[v] = true;
				}
			}
		}
		
		return visited[dst];
	}
	
	public static int networkFlow(int src, int dst) {
		int maxFlow = 0;
		
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				residual[i][j] = graph[i][j];
			}
		}
		
		while(bfs(src, dst)) {
			int minFlow = INF;
			for(int v = dst; v != src; v = prev[v]) {
				int u = prev[v];
				minFlow = Math.min(minFlow, residual[u][v]);
			}
			
			for(int v = dst; v != src; v = prev[v]) {
				int u = prev[v];
				residual[u][v] -= minFlow;
				residual[v][u] += minFlow; //reverse direction
			}
			
			maxFlow += minFlow;
		}
		return maxFlow;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		graph = new int[N+1][N+1];
		prev = new int[N+1];
		residual = new int[N+1][N+1];

		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			graph[s][e] = 1;
		}
		
		int answer = networkFlow(1, 2);
		System.out.println(answer);
		br.close();
	}
}
