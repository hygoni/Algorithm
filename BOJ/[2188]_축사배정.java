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

public class Main {
	static Map<Integer, Map<Integer, Integer>> graph;
	static Map<Integer, Integer> prev;
	static final int INF = Integer.MAX_VALUE;
	public static boolean bfs(int src, int dst) {
		Map<Integer, Boolean> visited = new HashMap<>();
		Queue<Integer> q = new LinkedList<>();
		visited.put(src, true);
		q.add(src);
		while(!q.isEmpty()) {
			int u = q.poll();
			Iterator<Integer> iter = graph.get(u).keySet().iterator();
			while(iter.hasNext()) {
				int v = iter.next();
				if(!visited.getOrDefault(v, false) && graph.get(u).get(v) > 0) {
					prev.put(v, u);
					visited.put(v, true);
					q.add(v);
				}
			}
		}
		
		return visited.getOrDefault(dst, false);
	}
	
	public static int fordFulkerson(int src, int dst) {
		int maxFlow = 0;
		while(bfs(src, dst)) {
			int pathFlow = INF;
			for(int v = dst; v != src; v = prev.get(v)) {
				int u = prev.get(v);
				pathFlow = Math.min(pathFlow, graph.get(u).get(v));
			}
			
			for(int v = dst; v != src; v = prev.get(v)) {
				int u = prev.get(v);
				graph.get(u).put(v, graph.get(u).get(v) - pathFlow);
				graph.get(v).put(u, graph.get(v).get(u) + pathFlow);
			}
			maxFlow += pathFlow;
		}
		
		return maxFlow;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		graph = new HashMap<>();
		prev = new HashMap<>();
		
		
		for(int i = 1; i <= N + M + 2; i++) {
			graph.put(i, new HashMap<>());
		}
		
		//소 처리
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			st.nextToken();
			
			while(st.hasMoreTokens()) {
				int v = Integer.parseInt(st.nextToken());
				graph.get(i).put(N+v, 1);
				graph.get(N+v).put(i, 0);
			}
		}
		
		int src = N + M + 1;
		int dst = N + M + 2;
		//src - 소 연결
		for(int i = 1; i <= N; i++) {
			graph.get(src).put(i, 1);
			graph.get(i).put(src, 0);
		}
		//축사 - dst 연결
		for(int i = N+1; i <= N+M; i++) {
			graph.get(i).put(dst, 1);
			graph.get(dst).put(i, 0);
		}
		
		int answer = fordFulkerson(src, dst);
		System.out.println(answer);
		br.close();
	}
}
