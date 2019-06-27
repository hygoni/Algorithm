import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int length = input.nextInt();
		String str = input.next();
		int sum = 0;
		for(int i = 0; i < length; i++) {
			sum += Integer.parseInt(str.substring(i, i+1));
		}
		System.out.println(sum);
	}
}
