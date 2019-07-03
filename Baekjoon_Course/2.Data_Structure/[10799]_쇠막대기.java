import java.util.Stack;
import java.util.Scanner;

public class Main
 {
 	public static void main(String args[])
 	{ 
		
		Scanner input = new Scanner(System.in);
		String line = input.nextLine();
		Stack stack = new Stack();
		int numberOfSticks = 0;
		
		for(int i = 0; i < line.length(); i++){
		    if(line.charAt(i) == '(')
		        stack.push(i);
		    else {
		        if((int) stack.peek() == i-1){
		            stack.pop();
		            numberOfSticks += stack.size();
                } else {
		            numberOfSticks += 1;
		            stack.pop();         
                }          
            }
        }
        System.out.println(numberOfSticks);
        input.close();		
 	}
 }
