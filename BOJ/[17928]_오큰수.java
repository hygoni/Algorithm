import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int num[] = new int[n];
		int ans[] = new int[n];
		Deque<Integer> stack = new LinkedList<Integer>();

		for(int i = 0; i < n; i++) {
			ans[i] = -1;
		}

		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i < n; i++) {
			if(stack.size() == 0) {
				stack.push(i);
			} else {
				while(num[stack.peek()] < num[i]) {
					ans[stack.pop()] = num[i];
					if(stack.size() == 0) {
						break;
					}
				} stack.push(i);
			}
		}
		
		for(int i = 0; i < n; i++) {
			bw.write(ans[i] + " ");
		}
		
		bw.flush();
		br.close();
		bw.close();
	}
}

