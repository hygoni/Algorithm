import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner input = new Scanner(System.in);
		int a = input.nextInt();
		int b = input.nextInt();
		int v = input.nextInt();
		
		int days = (int) Math.ceil((v - a) / (double) (a - b)) + 1;
		System.out.println(days);
		input.close();
	}
}

