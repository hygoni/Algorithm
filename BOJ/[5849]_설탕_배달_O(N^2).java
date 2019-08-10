import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int v = input.nextInt();
		int min = -1;
		
		int three = 0;
		for(int five = 0; five * 5 <= v; five++) {
			for(three = 0; five * 5 + 3 * three <= v; three++) {
				if(5 * five + 3 * three == v) {
					if(min == -1)
						min = five + three;
					if(five + three < min)
						min = five + three;
				}
			}
		}
		
		System.out.println(min);
	}

}
