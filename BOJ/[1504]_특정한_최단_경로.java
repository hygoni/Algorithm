import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Pair implements Comparable<Pair> {
	int v, weight;
	public Pair(int v, int weight) {
		this.v = v;
		this.weight = weight;
	}
	@Override
	public int compareTo(Pair o) {
		return Integer.compare(this.weight, o.weight);
	}
}

public class Main {
	static LinkedList<Pair> graph[];
	static int N, E;
	static int INF = Integer.MAX_VALUE;
	public static int dijkstra(int start, int end) throws Exception {
		int dist[] = new int[N+1];
		PriorityQueue<Pair> q = new PriorityQueue<Pair>();
		for(int i = 1; i <= N; i++) {
			if(i == start) {
				dist[i] = 0;
			} else {
				dist[i] = INF;
			}
		}
		q.add(new Pair(start, 0));
		
		while(!q.isEmpty()) {
			Pair now = q.poll();
			Iterator<Pair> iter = graph[now.v].iterator();
			while(iter.hasNext()) {
				Pair next = iter.next();
				if(dist[next.v] > dist[now.v] + next.weight) {
					dist[next.v] = dist[now.v] + next.weight;
					q.add(new Pair(next.v, dist[next.v]));
				}
			}
		}
		
		if(dist[end] == INF) {
			throw new Exception("No path found");
		} else {
			return dist[end];
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		graph = new LinkedList[N+1];
		for(int i = 1; i <= N; i++) {
			graph[i] = new LinkedList<Pair>();
		}
		
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			graph[u].add(new Pair(v, weight));
			graph[v].add(new Pair(u, weight));
		}
		
		st = new StringTokenizer(br.readLine());
		br.close();
		int mid1 = Integer.parseInt(st.nextToken());
		int mid2 = Integer.parseInt(st.nextToken());
		
		try {
			int ans1 = dijkstra(1, mid1);
			ans1 += dijkstra(mid1, mid2);
			ans1 += dijkstra(mid2, N);
			int ans2 = dijkstra(1, mid2);
			ans2 += dijkstra(mid2, mid1);
			ans2 += dijkstra(mid1, N);
			System.out.println(Math.min(ans1, ans2));
			
		} catch (Exception e) {
			System.out.println(-1);
		}
		
	}
}
