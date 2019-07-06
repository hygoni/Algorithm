import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String args[]) {
    	Scanner input = new Scanner(System.in);
    	String line = input.next();
    	int[] alpha = new int[26];
    	for(int i = 0; i < line.length(); i++) {
    		if((line.charAt(i) >= 'a') && (line.charAt(i) <= 'z')) {
    			alpha[line.charAt(i) - 'a'] += 1;
    		}
    	}
    	for(int i = 0; i < alpha.length; i++) {
    		System.out.print(alpha[i]+" ");
    	}
    }
}
