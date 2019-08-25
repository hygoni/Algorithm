import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int a = input.nextInt();
		int b = input.nextInt();
		
		String op = (a-b) > 0 ? ">" : (a==b) ? "==" : "<";
		System.out.println(op);
		
		input.close();
	}
}

