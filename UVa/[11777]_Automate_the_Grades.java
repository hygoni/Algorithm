import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

//Type of problem : Sort
//Time Complexity : O(N)
public class Main {
	
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		
		for(int i = 0; i < n; i++) {
			
			double term1 = input.nextDouble();
			double term2 = input.nextDouble();
			double final_ = input.nextDouble();
			double attendance = input.nextDouble();
			double[] test = new double[3];
			test[0] = input.nextInt();
			test[1] = input.nextInt();
			test[2] = input.nextInt();
			Arrays.sort(test);
			
			double sum = term1 + term2 + final_ + attendance;
			sum += (test[1] + test[2]) / 2;
			
			String grade;
			if(sum >= 90)
				grade = "A";
			else if(sum >= 80)
				grade = "B";
			else if(sum >= 70)
				grade = "C";
			else if(sum >= 60)
				grade = "D";
			else
				grade = "F";
			
			System.out.println(String.format("Case %d: %s", i+1, grade));			
		}
		input.close();
	}
}

