import java.util.Stack;
import java.util.Scanner;

public class Main
 {
 	public static void main(String args[])
 	{ 
		
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		input.nextLine(); //\n 없앰
		
		nextString:
		for(int i = 0; i < n; i++){
			Stack stack = new Stack();
			String line = input.nextLine();
			
			for(int j = 0; j < line.length(); j++){
				if(line.charAt(j) == '(')
					stack.push(j);
				else {
					if(stack.size() == 0){
						System.out.println("NO");
						continue nextString;
					} else {
						stack.pop();
					}	
				}
			}
			
			if(stack.size() == 0)
				System.out.println("YES");
			else
				System.out.println("NO");
			
		}
 	}
 }
