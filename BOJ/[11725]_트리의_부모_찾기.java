import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	
	static ArrayList<Integer>[] tree;
	static BufferedWriter bw;
	static int parent[];
	static boolean visited[];
	
	public static void dfs(int v) {
		visited[v] = true;
		for(int i = 0 ;i < tree[v].size(); i++) {
			int node = tree[v].get(i);
			if(visited[node] == false) {
				parent[node] = v;
				dfs(node);
			}
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		tree = new ArrayList[n+1];
		parent = new int[n+1];
		visited = new boolean[n+1];
		
		for(int i = 0; i <= n; i++) {
			tree[i] = new ArrayList<Integer>();
		}
		
		for(int i = 1; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			tree[v1].add(v2);
			tree[v2].add(v1);			
		}
		
		dfs(1);
		
		for(int i = 2; i <= n; i++) {
			bw.write(parent[i] + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}

