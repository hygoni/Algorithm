//Type of problem : Ad Hok

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System. in );
		while (true) {
			int n = input.nextInt();
			if (n == 0) break;
			int x = input.nextInt();
			int y = input.nextInt();
			for (int j = 0; j < n; j++) {
				int a = input.nextInt();
				int b = input.nextInt();
				String NS = ""; //North or South
				String EO = ""; // East or West
				String whole = "";

				if (a > x) {
					EO = "E";
				} else if (a < x) {
					EO = "O";
				}

				if (b > y) {
					NS = "N";
				} else if (b < y) {
					NS = "S";
				}

				if ((a == x) || (b == y)) {
					whole = "divisa";
				} else {
					whole = NS + EO;
				}

				System.out.print(whole);
			}
		}
		input.close();
	}

}
