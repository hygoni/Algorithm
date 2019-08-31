import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
	
	// Should I push?
	// 리턴값이 1: push, 0: pop, -1: 불가능함
	public static int shouldPush(Deque<Integer> stack, int num[], int i) {
		if(stack.size() == 0) { //스택이 비었거나
			return 1;
		} else if(stack.peek() < num[i]) { //출력해야 하는 문자열이 나오기 전까지는 Push
			return 1;
		} else {
			if(stack.peek() == num[i]) { //출력해야 하는 문자열에 도달한 경우 Pop
				return 0;
			} else { //도달할 수 없는 경우 불가능한 문자열임.
				return -1;
			}
		}

	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int num[] = new int[n];
		Deque<Integer> stack = new LinkedList<Integer>();
		StringBuilder sb = new StringBuilder();

		
		for(int i = 0; i < n; i++) {
			num[i] = Integer.parseInt(br.readLine());
		}
		
		int s = 0; //출력한 것들(?)
		int k = 1; //push한 숫자
		while(true) {
			int result = shouldPush(stack, num, s);
			if(result == 1) {
				sb.append("+\n");
				stack.push(k++);
			} else if(result == 0) {
				sb.append("-\n");
				stack.pop();
				s++;
				if(s >= num.length) {
					break;
				}
			} else { //불가능
				sb = new StringBuilder(); //문자열 리셋
				sb.append("NO\n");
				break;
			}
		}

		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
}

