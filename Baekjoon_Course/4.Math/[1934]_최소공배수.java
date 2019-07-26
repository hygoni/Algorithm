import java.util.Scanner;

public class Main {
	
	//great common multiple
	public static int gcd(int a, int b) {
		
		while(b != 0) {
			int r = a % b;
			a = b;
			b = r;
		}
		
		return a;
	}
	
	//least common multiple
	public static int lcm(int a, int b) {
		int g = gcd(a, b);
		return a * b / g;
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		for(int i = 0; i < n; i++) {
			int a = input.nextInt();
			int b = input.nextInt();
			System.out.println(lcm(a, b));
		}
		
		input.close();
		
	}
}

