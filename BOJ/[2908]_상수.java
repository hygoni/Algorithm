import java.util.Scanner;

public class Main {
	
	public static int reverse(int n) {
		String before = Integer.toString(n);
		char[] after = new char[before.length()];
		for(int i = 0; i < before.length(); i++) {
			after[i] = before.charAt(before.length() - i - 1);
		}
		return Integer.parseInt(String.copyValueOf(after));
	}
	public static void main(String ... args) {
		Scanner input = new Scanner(System.in);
		int a = reverse(input.nextInt());
		int b = reverse(input.nextInt());
		if(a < b) {
			System.out.println(b);
		} else {
			System.out.println(a);
		}
		input.close();
	}
}
