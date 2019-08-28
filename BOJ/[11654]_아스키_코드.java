import java.util.Scanner;

public class Main {
	public static void main(String ... args) {
		Scanner input = new Scanner(System.in);
		System.out.println(String.format("%d", (int) input.nextLine().charAt(0)));
		input.close();
	}
}
