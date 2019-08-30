import java.util.Scanner;

public class Main {

	public static void main(String ... args) {
		Scanner input = new Scanner(System.in);
		int a = input.nextInt();
		int b = input.nextInt();
		int c = input.nextInt();
		
		if(b >= c) {
			System.out.println(-1);
		} else {
			double breakPoint = a / (c - b);
			if(breakPoint == Math.floor(breakPoint)) {
				breakPoint++;
			} else {
				breakPoint = Math.ceil(breakPoint);
			}
			System.out.println((int) Math.ceil(breakPoint));
		}

		input.close();
	}
}
