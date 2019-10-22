import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge> {
	int s, e, value;
	public Edge(int s, int e, int value) {
		this.s = s;
		this.e = e;
		this.value = value;
	}

	@Override
	public int compareTo(Edge other) {
		return Integer.compare(value, other.value);
	}
}
public class Main {

	static int parent[];
	static int result = 0;

	public static void union(int x, int y) {
		int xRoot = find(x);
		int yRoot = find(y);
		if(xRoot != yRoot) {
			parent[xRoot] = y;
		}
	}

	public static int find(int x) {
		if(x == parent[x]) {
			return x;
		}
		parent[x] = find(parent[x]);
		return parent[x];
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		PriorityQueue<Edge> q = new PriorityQueue<Edge>();
		parent = new int[N+1];
		
		for(int i = 1; i <= N; i++) {
			parent[i] = i;
		}
		
		for(int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			q.add(new Edge(s, e, cost));
		}

		while(!q.isEmpty()) {
			Edge edge = q.poll();
			int s = edge.s;
			int e = edge.e;
			int value = edge.value;
			int sRoot = find(s);
			int eRoot = find(e);
 
			//싸이클이 있다면 패스
			if(sRoot == eRoot) {
				continue;
			}

			union(s, e);
			result += value;
		}

		System.out.println(result);
		br.close();
	}
}

