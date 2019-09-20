import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	static boolean visited[];
	static LinkedList<Integer> list;
	static BufferedWriter bw;
	public static void combination(int n, int m) throws IOException {
		if(list.size() == m) {
			Iterator<Integer> iter = list.iterator();
			while(iter.hasNext()) {
				bw.write(iter.next() + " ");
			}
			bw.write("\n");
		}
		for(int i = 1; i <= n; i++) {
			if(visited[i] == false) {
				visited[i] = true;
				list.addLast(i);
				combination(n, m);
				list.removeLast();
				visited[i] = false;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		Scanner input = new Scanner(System.in);
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = input.nextInt();
		int m = input.nextInt();
		list = new LinkedList<Integer>();
		visited = new boolean[n+1];
		combination(n, m);
		bw.flush();
		input.close();
	}
}

