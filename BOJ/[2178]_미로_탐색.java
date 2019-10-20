import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.SortedSet;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
	static HashMap<Integer, SortedSet<Integer>> graph;
	static HashMap<Integer, Boolean> visited;
	static HashMap<Integer, Integer> time;
	static int INF = Integer.MAX_VALUE;
	public static void bfs(int v) {
		Queue<Integer> q = new LinkedList<Integer>();
		visited.put(v, true);
		q.add(v);
		while(!q.isEmpty()){
			v = q.poll();
			int timeVal = time.getOrDefault(v, 1);
			for(int v_ : graph.get(v)) {
				if(!visited.get(v_)) {
					visited.put(v_, true);
					q.add(v_);
					
					int min = time.getOrDefault(v_, INF);
					min = Math.min(timeVal + 1, min);
					time.put(v_, min);
				}
			}

		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int rows = Integer.parseInt(st.nextToken());
		int columns = Integer.parseInt(st.nextToken());
		boolean[][] maze = new boolean[rows][columns];
		graph = new HashMap<Integer, SortedSet<Integer>>();
		visited = new HashMap<Integer, Boolean>();
		time = new HashMap<Integer, Integer>();

		for(int i = 0; i < rows * columns; i++ ) {
			graph.put(i, new TreeSet<Integer>());
			visited.put(i, false);
		}

		for(int i = 0; i < rows; i++) {
			String line = br.readLine();
			for(int j = 0; j < line.length(); j++) {
				char ch = line.charAt(j);
				maze[i][j] = (ch == '1' ? true : false);
			}
		}

		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < columns; j++) {
				if(!maze[i][j]) {
					continue;
				}
				
				if(i != 0) {
					if(maze[i-1][j]){
						graph.get(i * columns + j).add((i-1) * columns + j);
					}
				}
				
				if(i != rows-1) {
					if(maze[i+1][j]) {
						graph.get(i * columns + j).add((i+1) * columns + j);
					}
				}

				if(j != 0) {
					if(maze[i][j-1]) {
						graph.get(i * columns + j).add(i * columns + j-1);
					}
				}
				
				if(j != columns-1) {
					if(maze[i][j+1]) {
						graph.get(i * columns + j).add(i * columns + j+1);
					}
				}
			}
		}


		bfs(0);
		System.out.println(time.get(rows * columns - 1));
		br.close();
	}
}

