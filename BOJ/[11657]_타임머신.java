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
	public static void bellmanFord(int start, int end) {
		StringBuilder sb = new StringBuilder();
		int dist[] = new int[N+1];
		PriorityQueue<Pair> q = new PriorityQueue<Pair>();
		for(int i = 1; i <= N; i++) {
			if(i == start) {
				dist[i] = 0;
			} else {
				dist[i] = INF;
			}
		}
		
		boolean updated = false;
		for(int i = 1; i <= N; i++) {
			updated = false;
			for(int j = 1; j <= N; j++) {
				Iterator<Pair> iterE = graph[j].iterator();
				while(iterE.hasNext()) {
					Pair next = iterE.next();
					if(dist[j] != INF && dist[next.v] > dist[j] + next.weight) {
						dist[next.v] = dist[j] + next.weight;
						updated = true;
					}
				}
			}	
		}
		
		for(int i = 2; i <= N; i++) {
			if(updated) {
				sb = new StringBuilder("-1\n");
				break;
			} else if(dist[i] == INF) {
				sb.append("-1\n");
			} else {
				sb.append(dist[i]).append("\n");
			}
		}
		System.out.println(sb);		
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
		}
		
		br.close();
		bellmanFord(1, N);
		
	}
}
