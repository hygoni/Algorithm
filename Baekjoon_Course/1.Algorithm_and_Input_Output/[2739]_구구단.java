import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int dan = input.nextInt();
		
		for(int i = 1; i <= 9; i++) {
			System.out.println(String.format("%d * %d = %d", dan, i, dan*i));
		}
		
	}
}
