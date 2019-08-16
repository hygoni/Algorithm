import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

//Type of problem : Sort
//Time Complexity : O(N log N)

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
		int[] arr = new int[n];
		
		for(int i = 0; i < n; i++) {
			arr[i] = input.nextInt();
		}
		Arrays.sort(arr);
		
		int m = input.nextInt();
		for(int i = 0; i < m; i++) {
			int target = input.nextInt();
			if(Arrays.binarySearch(arr, target) >= 0)
				System.out.println(1);
			else
				System.out.println(0);
		}
		
		input.close();

	}



}

