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
		
		int n = input.nextInt();
		input.nextLine();
		
		graph = new LinkedList[n * n];
		for(int i = 0; i < n*n; i++) {
			graph[i] = new LinkedList<Integer>();
		}
		
		color = new int[n * n + 1];
		char[][] map = new char[n][n];
		//입력 받기
		for(int i = 0; i < n; i++) {
			String line = input.nextLine();
			for(int j = 0; j < line.length(); j++) {
				map[i][j] = line.charAt(j);
			}
		}
		
		//그래프 그리기
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				//좌
				if(map[i][j] != '1')
					continue;
				
				if((j != 0) && (map[i][j-1] == '1')) {
					graph[i * n + j].add(i * n + j - 1);
					//graph[i * n + j - 1].add(i * n + j);
				}
					
				//우
				if((j != n-1) && (map[i][j+1] == '1')) {
					graph[i * n + j].add(i * n + j + 1);
					//graph[i * n + j + 1].add(i * n + j);
				}
					
				//상
				if((i != 0) && (map[i-1][j] == '1')) {
					graph[i * n + j].add((i-1) * n + j);
					//graph[(i-1) * n + j].add(i * n + j);
				}
				//하
				if((i != n-1) && (map[i+1][j] == '1')) {
					graph[i * n + j].add((i+1) * n + j);
					//graph[(i+1) * n + j].add(i * n + j);
				}
					
			}
		}
		
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				int color_ = i * n + j + 1;
				if(map[i][j] != '0')
					dfs(i * n + j, color_);	
			}
		}
		
		ArrayList<Integer> aparts = new ArrayList<Integer>();
		for(int i = 1; i < n*n+1; i++) {
			int sum = 0;
			for(int j = 0; j < n*n; j++) {
				if(color[j] == i)
					sum++;
			}
			if(sum != 0)
				aparts.add(sum);
		}
		
		Collections.sort(aparts);
		System.out.println(aparts.size());
		for(int i = 0; i < aparts.size(); i++) {
			System.out.println(aparts.get(i));
		}
		
		input.close();

	}
}

