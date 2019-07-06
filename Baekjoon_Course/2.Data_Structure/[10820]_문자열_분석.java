import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String args[]) {
    	Scanner input = new Scanner(System.in);
    	
    	while(input.hasNextLine()) {
        	int lower = 0, upper = 0, num = 0, space = 0;
    		String line = input.nextLine();
    		for(int i = 0; i < line.length(); i++) {
    			char ch = line.charAt(i);
    			
    			if(ch >= 'a' && ch <= 'z')
    				lower += 1;
    			else if(ch >= 'A' && ch <= 'Z')
    				upper += 1;
    			else if(ch >= '0' && ch <= '9')
    				num += 1;
    			else if(ch == ' ')
    				space += 1;
    		}
    		System.out.println(String.format("%d %d %d %d", lower, upper, num, space));
    	}
    }
}
