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
	static int N;
	static int M;
	static int X;
	static int toHome[];
	static int toParty[];
	public static void dijkstra(int start) {
		StringBuilder sb = new StringBuilder();
		PriorityQueue<Pair> q = new PriorityQueue<Pair>();
		int dist[] = new int[N+1];
		
		//거리 초기화
		for(int i = 0; i <= N; i++) {
			dist[i] = INF;
		}
		
		//시작노드 설정
		dist[start] = 0;
		q.add(new Pair(start, 0));
		
		while(!q.isEmpty()) {
			Pair now = q.poll();
			//거리의 최솟값이 도움이 되지 않는 간선은 제외
			if(dist[now.v] > now.cost) {
				continue;
			}
			
			Iterator<Pair> iter = graph[now.v].iterator();
			while(iter.hasNext()) {
				Pair next = iter.next();
				if(dist[next.v] > dist[now.v] + next.cost) {
					dist[next.v] = dist[now.v] + next.cost;
					//큐에 넣는 이유는?
					q.add(new Pair(next.v, dist[next.v]));
				}
			}
		}
		
		if(start == X) {
			toHome = dist;
		} else {
			toParty[start] = dist[X];
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X =  Integer.parseInt(st.nextToken());
		graph = new LinkedList[N+1];
		toParty = new int[N+1];
		toHome = new int[N+1];
		
		for(int i = 0; i <= N; i++) {
			graph[i] = new LinkedList<Pair>();
		}
		
		//그래프 연결 (인접리스트)
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			Pair p = new Pair(e, cost);
			graph[s].add(p);
		}
		br.close();	
		
		for(int i = 1; i <= N; i++) {
			dijkstra(i);
		}
		
		int max = 0;
		for(int i = 1; i <= N; i++) {
			max = Math.max(max, toHome[i] + toParty[i]);
		}
		System.out.println(max);
	}
}
