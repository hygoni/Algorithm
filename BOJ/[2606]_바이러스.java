import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

//Type of problem : Graph
//Time Complexity : O(N + M)

public class Main {
	
	static boolean[] visited;
	static LinkedList<Integer>[] graph;
	
	public static void dfs(int v) {
		if(visited[v])
			return;
		
		visited[v] = true;
		Iterator<Integer> iter = graph[v].iterator();
		while(iter.hasNext()) {
			int u = iter.next();
			dfs(u);
		}
	}


	public static void main(String[] args) throws IOException {
		Scanner input = new Scanner(System.in);
		int n_comp = input.nextInt();
		graph = new LinkedList[n_comp+1];
		visited = new boolean[n_comp+1];
		
		for(int i = 0; i < n_comp+1; i++) {
			graph[i] = new LinkedList<Integer>();
		}
		
		int n_edge = input.nextInt();
		for(int i = 0; i < n_edge; i++) {
			int x = input.nextInt();
			int y = input.nextInt();
			graph[x].add(y);
			graph[y].add(x);
			
		}
		
		dfs(1);
		
		int n_infected = 0;
		for(int i = 0; i < visited.length; i++) {
			if(visited[i])
				n_infected++;
		}
		
		System.out.println(n_infected - 1); //1번 컴퓨터는 제외
		
		input.close();

	}
}

