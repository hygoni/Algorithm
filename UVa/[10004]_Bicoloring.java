import java.io.IOException;
import java.util.Collections;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

//Type of problem : Graph
//Time Complexity : O(N + M)

public class Main {

	static LinkedList<Integer>[] graph;
	static boolean[] visited;
	static int[] color; 
    static boolean bicolorable;
    
		public static void dfs(int v) {
			if(visited[v]) {
				return;
			}
			
			visited[v] = true;
			Iterator<Integer> iter = graph[v].iterator();
			
			while(iter.hasNext()) {
				int u = (int) iter.next();
				if(color[v] == 1) {
					if(color[u] == 1) {
						bicolorable = false;
					} else {
						color[u] = 2;
					}
				} else if(color[v] == 2) {
					if(color[u] == 2) {
						bicolorable = false;
					} else {
						color[u] = 1;
					}
				}
				dfs(u);
			}
		}
		

        public static void main(String[] args) throws IOException {
                
                Scanner input = new Scanner(System.in);
                int n = input.nextInt(); //정점의 수
                while(n != 0) {
                    int m = input.nextInt(); //간선의 수
                    graph = new LinkedList[n];
                    visited = new boolean[n];
                    color = new int[n];
                    int v = 0;
                    bicolorable = true;
                    
                    for(int i = 0; i < n; i++) {
                    	graph[i] = new LinkedList<Integer>();
                    }
                    
                    //간선 입력받기
                    for(int i = 0; i < m; i++) {
                    	int x = input.nextInt();
                    	int y = input.nextInt();
                    	v = x;
                    	graph[x].add(y);
                    	graph[y].add(x);
                    }
                    
                    color[v] = 1;
                    dfs(v);
                    
                    if(bicolorable) {
                    	System.out.println("BICOLORABLE.");
                    } else {
                    	System.out.println("NOT BICOLORABLE.");
                    }
                    
                    n = input.nextInt();
                }
                
                
                
                input.close();
                
        }
}

