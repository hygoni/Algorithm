import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;
import java.math.*;

public class Main {
	

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String a = input.next();
		int b = input.nextInt();
		
		Deque<Integer> stack = new LinkedList<Integer>();
		for(int i = 0; i < a.length(); i++) {
			char ch = a.charAt(i);
			if('0' <= ch && ch <= '9') {
				stack.push(ch - '0');
			}
			else {
				stack.push(ch - 'A' + 10);
			}
		}
		
		int size = stack.size();
		int sum = 0;
		for(int i = 0; i < size; i++) {
			int n = stack.pop();
			sum += n * Math.pow(b, i);
		}
		
		System.out.println(sum);
		
		input.close();
		
	}
}

