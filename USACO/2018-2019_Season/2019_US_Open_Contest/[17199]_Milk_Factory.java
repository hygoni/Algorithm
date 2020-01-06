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
		graph.put(v, new HashMap<>());
	}
	
	public void addEdge(T from, T to, int weight) {
		graph.get(from).put(to, weight);
	}
	
	public void addFlow(T from, T to, int amount) {
		int flow = graph.get(from).get(to);
		graph.get(from).put(to, flow + amount);
	}
	
	public Integer getWeight(T u, T v) {
		return graph.get(u).get(v);
	}
	
	public Iterator<T> getVertexIterator(){
		return graph.keySet().iterator();
	}
	
	public Iterator<T> getNeighborsIterator(T v){
		return graph.get(v).keySet().iterator();
	}

	public int numberOfVertexes() {
		return graph.keySet().size();
	}
}

public class Main {
	static int beingReached[] = new int[100+1];
	public static boolean isValid(int x, int y) {
		return (x >= 0) && (x < 10) && (y >= 0) && (y < 10);
	}
	
	public static int bfs(int src, DirectedGraph<Integer> graph) {
		Queue<Integer> q = new LinkedList<>();
		Map<Integer, Boolean> visited = new HashMap<>();
		q.add(src);
		visited.put(src, true);
		
		while(!q.isEmpty()) {
			int u = q.poll();
			Iterator<Integer> iter = graph.getNeighborsIterator(u);
			while(iter.hasNext()) {
				int v = iter.next();
				if(visited.get(v) == null) {
					q.add(v);
					visited.put(v, true);
				}
			}
		}
		
		Iterator<Integer> iter = visited.keySet().iterator();
		while(iter.hasNext()) {
			int v = iter.next();
			if(src == v) {
				continue;
			}
			beingReached[v]++;
		}
		return src;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		DirectedGraph<Integer> graph = new DirectedGraph<>();
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 1; i <= N; i++) {
			graph.addVertex(i);
		}
		
		for(int i = 0; i < N-1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			graph.addEdge(s, e, 1);
		}
		
		for(int v = 1; v <= N; v++) {
			bfs(v, graph);
		}
		int ans = -1;
		for(int v = 1; v <= 100; v++) {
			if(beingReached[v] == N-1) {
				ans = v;
				break;
			}
		}
		
		System.out.println(ans);
		br.close();
	}
}
