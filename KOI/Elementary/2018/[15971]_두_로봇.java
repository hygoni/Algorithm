import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

class DirectedGraph<T> {
	private Map<T, Map<T, Integer>> graph;
	private Map<T, T> prev;
	public DirectedGraph() {
		this.graph = new HashMap<>();
	}
	
	/* basic functions of graph */
	
	public void addVertex(T v) {
		this.graph.put(v, new HashMap<>());
	}
	
	public void addEdge(T from, T to, int weight) {
		weight = graph.get(from).getOrDefault(to, 0) + weight;
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
	
	public boolean containsKey(T key) {
		return graph.containsKey(key);
	}
	
}
public class Main {
	static final int INF = Integer.MAX_VALUE;
	public static Map<Integer, Integer> bfs(int src, int dst, DirectedGraph<Integer> graph) {
		Queue<Integer> q = new LinkedList<>();
		Map<Integer, Boolean> visited = new HashMap<>();
		Map<Integer, Integer> prev = new HashMap<>();
		q.add(src);
		
		while(!q.isEmpty()) {
			int u = q.poll();
			Iterator<Integer> iter = graph.getNeighborsIterator(u);
			while(iter.hasNext()) {
				int v = iter.next();
				if(!visited.getOrDefault(v, false)) {
					prev.put(v, u);
					q.add(v);
					visited.put(v, true);
				}
			}
		}
		
		return prev;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		DirectedGraph<Integer> graph = new DirectedGraph<>();
		
		int N = Integer.parseInt(st.nextToken());
		int n1 = Integer.parseInt(st.nextToken());
		int n2 = Integer.parseInt(st.nextToken());
		
		for(int i = 1; i <= N; i++) {
			graph.addVertex(i);
		}
		
		for(int i = 0; i < N-1; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int dist = Integer.parseInt(st.nextToken());
			
			graph.addEdge(u, v, dist);
			graph.addEdge(v, u, dist);
		}
		
		Map<Integer, Integer> prev = bfs(n1, n2, graph);
		int total = 0;
		int ans = INF;
		for(int v = n2; v != n1; v = prev.get(v)) {
			int u = prev.get(v);
			total += graph.getWeight(u, v);
		}
		
		for(int v = n2; v != n1; v = prev.get(v)) {
			int u = prev.get(v);
			int dist = graph.getWeight(u, v);
			ans = Math.min(ans, total - dist);
		}
		
		if(n1 == n2) {
			ans = 0;
		}
        
		System.out.println(ans);		 
		br.close();
	}
}
