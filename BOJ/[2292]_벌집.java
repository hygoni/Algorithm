import java.util.Scanner;

public class Main {

	public static void main(String ... args) {
		Scanner input = new Scanner(System.in);
		int num = input.nextInt(); //room num

		int i = 1;
		int sum = 1;
		while(sum < num) {
			sum += i * 6;
			i++;
		}
		System.out.println(i);


		input.close();
	}
}
