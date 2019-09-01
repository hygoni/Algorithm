import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;


public class Main {

	public static boolean isValidBracket(String str, int fromidx, int toidx) {
		Deque<Character> stack = new LinkedList<Character>();
		for(int i = fromidx; i < toidx; i++) {
			char ch = str.charAt(i);

			if(ch == '(') {
				stack.push(ch);
			} else if(ch == ')') {
				if(stack.size() == 0) {
					return false;
				} else {
					if(stack.peek() == '[') {
						return false;
					} else {
						stack.pop();
					}
				}
			} else if(ch == '[') {
				stack.push(ch);
			} else if(ch == ']') {
				if(stack.size() == 0) {
					return false;
				} else {
					if(stack.peek() == '(') {
						return false;
					} else {
						stack.pop();
					}
				}
			}
		}

		if(stack.size() != 0) {
			return false;
		}

		return true;

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();

		while(!line.equals(".")) {
			if(isValidBracket(line, 0, line.length())) {
				System.out.println("yes");
			} else {
				System.out.println("no");
			}
			line = br.readLine();
		}

		br.close();
	}
}

