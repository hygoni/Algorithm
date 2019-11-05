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
	static final int INF = Integer.MAX_VALUE;
	static LinkedList<Pair> graph[];
	static int V;
	static int E;
	public static void dijkstra(int start) {
		StringBuilder sb = new StringBuilder();
		PriorityQueue<Pair> q = new PriorityQueue<Pair>();
		int dist[] = new int[V+1];
		boolean check[] = new boolean[V+1];
		
		//거리 초기화
		for(int i = 0; i <= V; i++) {
			dist[i] = INF;
		}
		
		//시작노드 설정
		dist[start] = 0;
		check[start] = true;
		q.add(new Pair(start, 0));
		
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
		
		for(int i = 1; i <= V; i++) {
			if(dist[i] == INF) {
				sb.append("INF");
			} else {
				sb.append(dist[i]);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		int start =  Integer.parseInt(br.readLine());
		graph = new LinkedList[V+1];
		
		for(int i = 0; i <= V; i++) {
			graph[i] = new LinkedList<Pair>();
		}
		
		//그래프 연결 (인접리스트)
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			Pair p = new Pair(e, cost);
			graph[s].add(p);
		}
		br.close();	
		dijkstra(start);
	}
}
