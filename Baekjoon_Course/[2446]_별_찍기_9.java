import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int height = input.nextInt();
		for(int i = height; i > 0; i--) {
			for(int j = 0; j < height-i; j++)
				System.out.print(" ");
			for(int j = 0; j < 2*i-1; j++)
				System.out.print("*");
			System.out.println();
		}
		for(int i = 1; i < height; i++) {
			for(int j = height-i-1; j > 0;  j--)
				System.out.print(" ");
			for(int j = 0; j < 2*i+1; j++)
				System.out.print("*");
			System.out.println();
		}
	}
}

