import java.util.Stack;
import java.util.Scanner;
public class Main {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		Stack<Character> left = new Stack<Character>();
		Stack<Character> right = new Stack<Character>();		
		String line = input.next();
		int n = input.nextInt();
		input.nextLine();
		
		for(int i = 0; i < line.length(); i++){
			left.push(line.charAt(i));
		}
		for(int i = 0; i < n; i++){
			String cmd = input.next();
			switch(cmd){
			case "L":
				if(left.isEmpty() == false)
					right.push(left.pop());
				break;
			case "D":
				if(right.isEmpty() == false)
					left.push(right.pop());
				break;
			case "B":
				if(left.isEmpty() == false)
					left.pop();
				break;
			case "P":
				char argument = input.next().charAt(0);
				left.push(argument);
				break;
			}
		}
		
		char[] str = new char[left.size() + right.size()];
		int left_size = left.size();
		for(int i = left_size-1; i >= 0; i--){
			str[i] = left.pop();
		}
		int right_size = right.size();
		for(int i = right_size; i > 0; i--){
			str[left_size+right_size-i] = right.pop();
		}
		System.out.println(String.copyValueOf(str));
		
	}
}

