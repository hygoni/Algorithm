import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int height = input.nextInt();
		for(int i = 0; i < height; i++){
			for(int j = height-1-i; j > 0; j--)
				System.out.print(" ");
			for(int j = 0; j < i+1; j++)
				System.out.print("*");
			System.out.println();
		}
		for(int i = height-1; i > 0; i--) {
			for(int j = 0; j < height-i; j++)
				System.out.print(" ");
			for(int j = 0; j < i; j++)
				System.out.print("*");
			System.out.println();
		}
	}
}

