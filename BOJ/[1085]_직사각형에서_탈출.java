import java.util.Scanner;

//Time Complexity : O(1)

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int x = input.nextInt();
		int y = input.nextInt();
		int w = input.nextInt();
		int h = input.nextInt();
		
		int min = x;
		
		if(min > w - x) {
			min = w - x;
		}
		if(min > y) {
			min = y;
		}
		if(min > h - y) {
			min = h - y;
		}
		
		System.out.println(min);
		input.close();
	}
}

