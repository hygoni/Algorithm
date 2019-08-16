import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

//Type of problem : Graph
//Time Complexity : O(N + M)

public class Main {
	
	static LinkedList<Integer>[] graph;
	static int[] color;
	
	public static void dfs(int v, int color_) {
		if(color[v] > 0) //visited
			return;
		
		color[v] = color_;
		
		Iterator<Integer> iter = graph[v].iterator();
		while(iter.hasNext()) {
			int u = iter.next();
			dfs(u, color_);
		}
		
	}


	public static void main(String[] args) throws IOException {
		Scanner input = new Scanner(System.in);
		int t = input.nextInt();
		
		for(int case_ = 0; case_ < t; case_++) {
			int m = input.nextInt();
			int n = input.nextInt();
			int v = input.nextInt(); //배추의 수
			graph = new LinkedList[m*n];
			color = new int[m*n+1];
			for(int i = 0; i < m*n; i++) {
				graph[i] = new LinkedList<Integer>();
			}
			
			char[][] map = new char[m][n];
			for(int i = 0; i < v; i++) {
				int x = input.nextInt();
				int y = input.nextInt();
				map[x][y] = '1';
			}
			
			//그래프 그리기
			for(int i = 0; i < m; i++) {
				for(int j = 0; j < n; j++) {
					//좌
					if(map[i][j] != '1')
						continue;
					
					if((j != 0) && (map[i][j-1] == '1')) {
						graph[i * n + j].add(i * n + j - 1);
					}
					
					//우
					if((j != n-1) && (map[i][j+1] == '1')) {
						graph[i * n+ j].add(i * n + j + 1);
					}
						
					//상
					if((i != 0) && (map[i-1][j] == '1')) {
						graph[i * n + j].add((i-1) * n + j);
					}
					//하
					if((i != m-1) && (map[i+1][j] == '1')) {
						graph[i * n + j].add((i+1) * n + j);
					}
						
				}
			}
			
			for(int i = 0; i < m; i++) {
				for(int j = 0; j < n; j++) {
					int color_ = i * n + j + 1;
					if(map[i][j] != 0)
						dfs(i * n + j, color_);	
				}
			}
			
			boolean[] colors = new boolean[n*m+1];
			int n_worms = 0;
			for(int i = 0; i < colors.length; i++) {
				if((colors[color[i]] == false) && color[i] != 0) {
					n_worms++;
					colors[color[i]] = true;
				}
			}
			System.out.println(n_worms);
			
			
		}
		
		input.close();

	}
}

