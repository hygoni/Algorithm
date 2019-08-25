import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	
	static LinkedList<Integer>[] graph;
	static boolean[] visited;
	
	public static void dfs(int v) {
		if(visited[v] == true) return;
		
		visited[v] = true;
		Iterator<Integer> iter = graph[v].iterator();
		while(iter.hasNext()) {
			dfs(iter.next());
		}
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int t = input.nextInt();
		
		while(t-- > 0) {
			int n_numbers = input.nextInt();
			graph = new LinkedList[n_numbers];
			visited = new boolean[n_numbers];
			for(int i = 1; i <= n_numbers; i++) {
				graph[i-1] = new LinkedList<Integer>();
				graph[i-1].add(input.nextInt() - 1);
			}
			
			int n_cycles = 0;
			for(int i = 0; i < n_numbers; i++) {
				if(visited[i] == false) {
					dfs(i);
					n_cycles++;
				}
			}
			System.out.println(n_cycles);
		}
		input.close();
	}
}

