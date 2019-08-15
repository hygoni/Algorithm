import java.io.IOException;
import java.util.Collections;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

//Type of problem : List
//Time Complexity : O(N)

public class Main {

	
		public static void dfs(int n, LinkedList<LinkedList<Integer>> graph, boolean[] checked) {
			if(checked[n]) {
				return;
			}
			
			checked[n] = true;
			System.out.print(n + " ");
			Collections.sort(graph.get(n));
			Iterator iter = graph.get(n).iterator();
			while(iter.hasNext()) {
				int u = (int) iter.next();
				dfs(u, graph, checked);
			}
		}
		
		public static void bfs(LinkedList<LinkedList<Integer>> graph, boolean[] checked, Deque<Integer> q) {
			if(q.isEmpty()) return;
			
			int n = q.poll();
			checked[n] = true;
			System.out.print(n + " ");
			Collections.sort(graph.get(n));
			Iterator<Integer> iter = graph.get(n).iterator();
			while(iter.hasNext()){
				int v = iter.next();
				if(checked[v]) continue;
				checked[v] = true;
				q.add(v);
			}
				bfs(graph, checked, q);			
		}

        public static void main(String[] args) throws IOException {
                
                Scanner input = new Scanner(System.in);
                LinkedList<LinkedList<Integer>> graph = new LinkedList<LinkedList<Integer>>();
                
                int n = input.nextInt();
                boolean checked[] = new boolean[n+1];
                int m = input.nextInt(); //간선의 수
                int v = input.nextInt(); //시작점
                
                for(int i = 0; i < n+1; i++) {
                	graph.add(new LinkedList<Integer>());
                }
                
                for(int i = 0; i < m; i++) {
                	int x = input.nextInt();
                	int y = input.nextInt();
                	graph.get(x).add(y);
                	graph.get(y).add(x); //양방향 그래프 이므로
                }
                
                dfs(v, graph, checked);
                System.out.println();
                checked = new boolean[n+1];
                Deque<Integer> q = new LinkedList<Integer>();
                q.push(v);
                bfs(graph, checked, q);
                
                input.close();
        }
}

