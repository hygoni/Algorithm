import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
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
		graph.put(v, new HashMap<>());
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
	
	public Iterator<T> getVertexIterator(T v){
		return graph.keySet().iterator();
	}
	
	public Iterator<T> getNeighborsIterator(T v){
		return graph.get(v).keySet().iterator();
	}
	
	public boolean containsKey(String key) {
		return graph.containsKey(key);
	}
	
	/* Network Flow */
	
	public boolean bfs(T src, T dst) {
		Map<T, Boolean> visited = new HashMap<>();
		Queue<T> q = new LinkedList<T>();
		q.add(src);
		
		while(!q.isEmpty()) {
			T u = q.poll();
			Iterator<T> iter = this.getNeighborsIterator(u);
			while(iter.hasNext()) {
				T v = iter.next();
				if(!visited.getOrDefault(v, false) && this.getWeight(u, v) > 0) {
					visited.put(v, true);
					prev.put(v, u);
					q.add(v);
				}
			}
		}
		
		return visited.getOrDefault(dst, false);
	}
	
	/**
	 * Ford-Fulkerson method is used to get max flow
	 * so time complexity is min(O(VE^2), O(EF))
	 * */
	public int getMaxFlow(T src, T dst) {
		this.prev = new HashMap<>();
		int maxFlow = 0;
		
		while(bfs(src, dst)) {
			int pathFlow = Integer.MAX_VALUE;
			
			for(T v = dst; !v.equals(src); v = prev.get(v)) {
				T u = prev.get(v);
				pathFlow = Math.min(pathFlow, this.getWeight(u, v));
			}
			
			for(T v = dst; !v.equals(src); v = prev.get(v)) {
				T u = prev.get(v);
				this.addFlow(u, v, -pathFlow);
				this.addFlow(v, u, +pathFlow);
			}
			
			maxFlow += pathFlow;
		}
		
		return maxFlow;
	}
}


public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		final String SOURCE = "A";
		final String  SINK = "Z";
		final int N = Integer.parseInt(br.readLine());
		DirectedGraph<String> graph = new DirectedGraph<>();
		
		graph.addVertex(SOURCE);
		graph.addVertex(SINK);
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			String e = st.nextToken();
			int weight = Integer.parseInt(st.nextToken());
			
			if(!graph.containsKey(s)) {
				graph.addVertex(s);
			}
			if(!graph.containsKey(e)) {
				graph.addVertex(e);
			}
			
			graph.addEdge(s, e, weight);
			graph.addEdge(e, s, weight);
		}
		
		br.close();
		
		int ans = graph.getMaxFlow(SOURCE, SINK);
		System.out.println(ans);
	}
}
