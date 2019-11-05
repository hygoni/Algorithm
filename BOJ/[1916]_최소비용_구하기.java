import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Pair implements Comparable<Pair> {
	int v, cost;
	
	public Pair(int v, int cost) {
		this.v = v;
		this.cost = cost;
	}
	
	@Override
	public int compareTo(Pair o) {
		return Integer.compare(this.cost, o.cost);
	}
	
}
public class Main {
	static int N, M;
	static final int INF = Integer.MAX_VALUE;
	static LinkedList<Pair> graph[];
	public static void dijkstra(int src, int dst) {
		int dist[] = new int[N+1];
		PriorityQueue<Pair> q = new PriorityQueue<Pair>();
		
		for(int i = 1; i <= N; i++) {
			dist[i] = INF;
		}
		
		dist[src] = 0;
		q.add(new Pair(src, 0));
		
		while(!q.isEmpty()) {
			Pair now = q.poll();
			if(dist[now.v] > now.cost) {
				continue;
			}
			
			Iterator<Pair> iter = graph[now.v].iterator();
			while(iter.hasNext()) {
				Pair next = iter.next();
				if(dist[next.v] > dist[now.v] + next.cost) {
					dist[next.v] = dist[now.v] + next.cost;
					q.add(new Pair(next.v, dist[next.v]));
				}
			}
		}
		System.out.println(dist[dst]);
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		graph = new LinkedList[N+1];
		
		for(int i = 1; i <= N; i++) {
			graph[i] = new LinkedList<Pair>();
		}
		//그래프 생성
		for(int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			graph[s].add(new Pair(e, cost));
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int src = Integer.parseInt(st.nextToken());
		int dst = Integer.parseInt(st.nextToken());
		br.close();
		dijkstra(src, dst);
	}
}
