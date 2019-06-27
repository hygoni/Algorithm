import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int times = input.nextInt();
		for(int i = 0; i < times; i++) {
			int a = input.nextInt();
			int b = input.nextInt();
			System.out.println(String.format("Case #%d: %d + %d = %d", i+1, a, b, a+b));
		}
	}
}
