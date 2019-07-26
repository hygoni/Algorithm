import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int a = input.nextInt();
		int b = input.nextInt();
		
		Deque<Integer> stack = new LinkedList<Integer>();
		
		int m = a;
		while(m != 0) {
			int r = m % b;
			m = m / b;
			stack.push(r);
		}
		
		int size = stack.size();
		for(int i = 0; i < size; i++) {
			int popped = stack.pop();
			if(popped >= 10) {
				char ch = (char) ('A' + (popped - 10));
				System.out.print(ch);
			} else {
				System.out.print(popped);
			}
		}
		input.close();
		
	}
}

