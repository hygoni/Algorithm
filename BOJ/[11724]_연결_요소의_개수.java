import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.StringTokenizer;

class DirectedGraph<T> {
	private Map<T, Map<T, Integer>> graph;
	private Map<T, T> prev;
	public DirectedGraph() {
		this.graph = new HashMap<>();
	}
	
	/* basic functions of graph */
	
	public void addVertex(T v) {
		graph.put(v, new HashMap<>());
	}
	
	public void addEdge(T from, T to, int weight) {
		graph.get(from).put(to, weight);
	}
	
	public void addFlow(T from, T to, int amount) {
		int flow = graph.get(from).get(to);
		graph.get(from).put(to, flow + amount);
	}
	
	public int getWeight(T u, T v) {
		return graph.get(u).get(v);
	}
	
	public Iterator<T> getVertexIterator(){
		return graph.keySet().iterator();
	}
	
	public Iterator<T> getNeighborsIterator(T v){
		return graph.get(v).keySet().iterator();
	}
	
}

public class Main {
	static int color[];
	static int max = 0;
	public static int bfs(int start, DirectedGraph<Integer> graph) {
		
		if(color[start] != 0) {
			return color[start];
		}
		
		int col = ++max;		
		LinkedList<Integer> q = new LinkedList<>();
		Map<Integer, Boolean> visited = new HashMap<>();
		visited.put(start, true);
		q.add(start);
		
		while(!q.isEmpty()) {
			int u = q.poll();
			Iterator<Integer> iter = graph.getNeighborsIterator(u);
			while(iter.hasNext()) {
				int v = iter.next();
				if(visited.get(v) == null && color[v] == 0) {
					q.add(v);
					visited.put(v, true);
					color[v] = col;
				}
			}
		}
		
		return col;
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		color = new int[N+1];
		DirectedGraph<Integer> graph = new DirectedGraph<>();
		
		for(int i = 1; i <= N; i++) {
			graph.addVertex(i);
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			graph.addEdge(s, e, 1);
			graph.addEdge(e, s, 1);
		}
		
		for(int i = 1; i <= N; i++) {
			max = Math.max(max,  bfs(i, graph));
		}
		
		System.out.println(max);
		br.close();
	}
}
