import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		int a, b, c;
		Scanner input = new Scanner(System.in);
		a = input.nextInt();
		b = input.nextInt();
		c = input.nextInt();

		System.out.println( (a + b) % c );
		System.out.println( (a % c +  b % c) % c ) ;
		System.out.println( (a * b) % c );
		System.out.println( (a % c) * (b % c ) % c );
		
		input.close();
		
	}
}

