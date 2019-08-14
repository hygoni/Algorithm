import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;

//Type of problem : Array & Sum
//Time Complexity : O(N)
public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Deque<Integer> stack = new LinkedList<Integer>();
		
		int k = Integer.parseInt(br.readLine());
		stack.push(0);
		
		for(int i = 0; i < k; i++) {
			int n = Integer.parseInt(br.readLine());
			if(n == 0)
				stack.pop();
			else
				stack.push(n);
		}
		
		int size = stack.size();
		int sum = 0;
		for(int i = 0; i < size; i++) {
			sum += stack.pop();
		}
		
		bw.write(sum + "\n");
		bw.flush();
		br.close();
		bw.close();
	}
}

