import java.util.Scanner;


public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int a = input.nextInt();
		int b = input.nextInt();
		int c = input.nextInt();
		
		while(a + b + c != 0) {
			
			if(a * a + b * b == c * c) {
				System.out.println("right");
			} else if(b * b + c * c == a * a) {
				System.out.println("right");
			} else if(a * a + c * c == b * b) {
				System.out.println("right");
			} else {
				System.out.println("wrong");
			}
			
			a = input.nextInt();
			b = input.nextInt();
			c = input.nextInt();
		}
		input.close();
	}
}

