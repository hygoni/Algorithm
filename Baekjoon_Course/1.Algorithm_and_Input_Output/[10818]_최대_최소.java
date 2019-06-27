import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int min = 0, max = 0;
		
		for(int i = 0; i < n; i++) {
			int num = input.nextInt();
			if(i == 0) {
				min = num;
				max = num;
			}
			if(min > num)
				min = num;
			if(max < num)
				max = num;
		}
		System.out.println(String.format("%d %d", min, max));
			
		
	}
}
