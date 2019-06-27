import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int times = input.nextInt();
		for(int i = 0; i < times; i++) {
			String line = input.next();
			String[] numSplit = line.split(",");
			int[] num = new int[2];
			num[0] = Integer.parseInt(numSplit[0]);
			num[1] = Integer.parseInt(numSplit[1]);
			System.out.println(num[0] + num[1]);
		}
	}
}
