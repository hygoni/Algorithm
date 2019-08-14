import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;

//Type of problem : Deque
//Time Complexity : O(N)
public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		Deque<Integer> deq = new LinkedList<Integer>();
		int n = Integer.parseInt(br.readLine());
		
		//O(N)
		for(int i = 0; i < n; i++) {
			deq.addLast(i+1);
		}
		
		//O(N)
		while(deq.size() != 1) {
			deq.pollFirst();
			deq.addLast(deq.pollFirst());
		}
		
		bw.write(deq.poll() + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}

