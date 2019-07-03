import java.util.Stack;
import java.util.Scanner;
public class Main {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		Stack<Integer> stack = new Stack<Integer>();
		for(int i = 0; i < n; i++){
			String line = input.next();
			if(line.contains("push")){
				int x = Integer.parseInt(input.next());
				stack.push(x);
			} else if(line.contains("pop")){
				if(stack.size() > 0)
					System.out.println(stack.pop());
				else
					System.out.println(-1);
				
			} else if(line.contains("top")){
				if(stack.size() > 0)
					System.out.println(stack.peek());
				else
					System.out.println(-1);
			} else if(line.contains("empty")){
				System.out.println(stack.isEmpty() ? 1 : 0);
			} else if(line.contains("size")){
				System.out.println(stack.size());

			}
		}
	}
}

