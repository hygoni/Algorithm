import java.util.Arrays;
import java.util.Scanner;


public class Main {
	
	public static void main(String[] args) {
			
		
		Scanner input = new Scanner(System.in);
		String line = input.nextLine();
		int[] digit_array = new int[line.length()];
		
		for(int i = 0; i < line.length(); i++) {
			digit_array[i] = line.charAt(i) - '0';
		}
		
		Arrays.sort(digit_array);
		
		for(int i = digit_array.length - 1; i >= 0; i--) {
			System.out.print(digit_array[i]);
		}
		System.out.println();
		
		input.close();
		
	}

}
