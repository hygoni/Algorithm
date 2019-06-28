import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int height = input.nextInt();
		for(int i = 1; i <= height; i++) {
			for(int j = height-i; j > 0; j--)
				System.out.print(" ");
			for(int j = 1; j < 2*i; j++) {
				if(j % 2 == 0)
					System.out.print(" ");
				else
					System.out.print("*");
			}
			System.out.println();
		}
	}
}

