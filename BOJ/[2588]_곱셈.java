import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int a = input.nextInt();
		input.nextLine();
		String b = input.nextLine();

		int d1 = Integer.parseInt(b.substring(0, 1));
		int d2 = Integer.parseInt(b.substring(1, 2));
		int d3 = Integer.parseInt(b.substring(2, 3));

		System.out.println(d3 * a);
		System.out.println(d2 * a);
		System.out.println(d1 * a);
		System.out.println(Integer.parseInt(b) * a);
		
		input.close();
	}
}

