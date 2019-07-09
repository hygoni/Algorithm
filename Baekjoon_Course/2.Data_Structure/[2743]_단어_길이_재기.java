import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String args[]) {
    	Scanner input = new Scanner(System.in);
    	
    	while(input.hasNextLine()) {
    		String line = input.nextLine();
    		System.out.println(line.length());
    	}
    	
    	input.close();
    }
}
