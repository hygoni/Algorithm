import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int height = input.nextInt();
		for(int i = 0; i < height; i++) {
			for(int j = 0; j < i; j++) {
				System.out.print(" ");
			}
			for(int j = 0; j < height-i; j++) {
				System.out.print("*");
			}
			System.out.println("");
		}
	}
}

