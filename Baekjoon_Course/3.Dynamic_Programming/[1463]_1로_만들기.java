import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {

	public static int minCount(int n, int memo[]) {
		if(memo[n] != 0)
			return memo[n];
		else if(n == 1)
			return 0;
		else {
			ArrayList<Integer> array = new ArrayList<Integer>();
			if(n % 3 == 0)
				array.add(minCount(n/3, memo) + 1);
			else if(n % 2 == 0)
				array.add(minCount(n/2, memo) + 1);
			array.add(minCount(n-1, memo) + 1);
			
			Collections.sort(array);
			memo[n] = array.get(0);
			return memo[n];
		}
	}
    public static void main(String args[]) {
    	
    	Scanner input = new Scanner(System.in);
    	int n = input.nextInt();
    	int[] memo = new int[n+1];
    	
    	for(int i = 1; i <= n; i++) {
    		memo[i] = minCount(i, memo);
    	}
    	
    	System.out.println(minCount(n, memo));
    	input.close();
    }
}
