import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

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

	public int numberOfVertexes() {
		return graph.keySet().size();
	}
}

public class Main {
	static char map[];
	public static boolean isValid(int x, int y) {
		return (x >= 0) && (x < 10) && (y >= 0) && (y < 10);
	}
	
	public static int bfs(int src, DirectedGraph<Integer> graph) {
		Queue<Integer> q = new LinkedList<>();
		Map<Integer, Boolean> visited = new HashMap<>();
		int dist[] = new int[graph.numberOfVertexes()];
		q.add(src);
		visited.put(src, true);
		
		while(!q.isEmpty()) {
			Integer u = q.poll();
			Iterator<Integer> iter = graph.getNeighborsIterator(u);
			while(iter.hasNext()) {
				Integer v = iter.next();
				if(visited.get(v) == null) {
					dist[v] = dist[u] + 1;
					q.add(v);
					visited.put(v, true);
					if(map[v] == 'L') {
						return dist[v];
					}
				}
			}
		}
		
		return 0;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new char[10*10];
		DirectedGraph<Integer> graph = new DirectedGraph<>();
		
		for(int y = 0; y < 10; y++) {
			String line = br.readLine();
			for(int x = 0; x < 10; x++) {
				map[y*10+x] = line.charAt(x);
				graph.addVertex(y*10+x);
			}
		}
		
		int dx[] = {-1, 0, 0, 1};
		int dy[] = {0, -1, 1, 0};
		int barn = 0;
		
		for(int y = 0; y < 10; y++) {
			for(int x = 0; x < 10; x++) {
				if(map[y*10+x] == 'B') {
					barn = y*10+x;
				}
				//상하좌우 체크
				for(int i = 0; i < 4; i++) {
					int X = x + dx[i];
					int Y = y + dy[i];
					if(isValid(X, Y)) {
						if(map[Y*10+X] != 'R') {
							graph.addEdge(y*10+x, Y*10+X, 1);
						}
					}
				}
			}
		}
		
		int ans = bfs(barn, graph) - 1;
		System.out.println(ans);
		br.close();
	}
}
