import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		LinkedList<Integer> stack = new LinkedList<Integer>();
		int answer = 0;
		
		for(int i = 0; i < n; i++) {
			int num = Integer.parseInt(br.readLine());
			if(num == 0) {
				answer -= stack.pop();
			} else {
				answer += num;
				stack.push(num);
			}
		}
		System.out.println(answer);
		br.close();
	}
}
