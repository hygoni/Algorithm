import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static LinkedList<Integer> graph[];
	static int N;
	static int M;
	static int inDegree[];
	public static void topologicalSort() {
		Queue<Integer> q = new LinkedList<Integer>();
		StringBuilder sb = new StringBuilder();
		
		for(int i = 1; i <= N; i++) {
			if(inDegree[i] == 0) {
				q.add(i);
			}
		}
		
		for(int i = 1; i <= N; i++) {
			int u = q.poll();
			sb.append(u).append(" ");
			Iterator<Integer> iter = graph[u].iterator();
			while(iter.hasNext()) {
				int v = iter.next();
				inDegree[v]--;
				if(inDegree[v] == 0) {
					q.add(v);
				}
			}
		}
        
		System.out.println(sb);
	}
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		graph = new LinkedList[N+1];
		inDegree = new int[N+1];
		
		for(int i = 1; i <= N; i++) {
			graph[i] = new LinkedList<Integer>();
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			graph[s].add(e);
			inDegree[e]++;
		}
		
		topologicalSort();
		br.close();
	}
}
