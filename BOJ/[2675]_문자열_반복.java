import java.util.Scanner;

public class Main {

	public static void main(String ... args) {
		Scanner input = new Scanner(System.in);
		int t = input.nextInt();
		
		for(int i = 0; i < t; i++) {
			int k = input.nextInt();
			String line = input.next();
			input.nextLine();
			
			for(int j = 0; j < line.length(); j++) {
				for(int l = 0; l < k; l++) {
					System.out.print(line.charAt(j));
				} 
			} System.out.println();
		}

		input.close();
	}
}
