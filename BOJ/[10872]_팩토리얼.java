import java.util.Scanner;

public class Main {
	
	public static int factorial(int n) {
		int ret = 1;
		for(int i = 2; i <= n; i++) {
			ret *= i;
		}
		return ret;
	}
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		System.out.println(factorial(n));
		input.close();
	}
}

