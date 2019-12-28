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
	public static <T> int bfs(T start, DirectedGraph<T> graph) {
		Queue<T> q = new LinkedList<T>();
		Map<T, Boolean> visited = new HashMap<>();
		q.add(start);
		visited.put(start, true);
		int ans = 0;
		
		while(!q.isEmpty()) {
			T u = q.poll();
			Iterator<T> iter = graph.getNeighborsIterator(u);
			while(iter.hasNext()) {
				T v = iter.next();
				if(!visited.getOrDefault(v, false)) {
					q.add(v);
					visited.put(v, true);
					ans++;					
				}
			}
		}
		
		return ans;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());

		DirectedGraph<Integer> higherGraph = new DirectedGraph<>();
		DirectedGraph<Integer> lowerGraph = new DirectedGraph<>();
		
		for(int i = 1; i <= N; i++) {
			lowerGraph.addVertex(i);
			higherGraph.addVertex(i);
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int higher = Integer.parseInt(st.nextToken());
			int lower = Integer.parseInt(st.nextToken());
			
			higherGraph.addEdge(lower, higher, 1);
			lowerGraph.addEdge(higher, lower, 1);
		}
		
		int best = 1 + bfs(X, higherGraph);
		int worst = N - bfs(X, lowerGraph);
		System.out.println(String.format("%d %d", best, worst));
		br.close();
	}
}
