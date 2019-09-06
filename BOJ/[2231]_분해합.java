import java.util.Scanner;

public class Main {
	
	public static int dsum(int n) {
		int sum = 0;
		String str = Integer.toString(n);
		for(int i = 0; i < str.length(); i++) {
			sum += str.charAt(i) - '0';
		}
		return sum + n;
	}
	
	public static void main(String[] args) {	 
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int generator = -1;
		for(int i = 0; i <= n; i++) {
			if(dsum(i) == n) {
				generator = i;
				break;
			}
		}
		
		if(generator < 0) {
			System.out.println(0);
		} else {
			System.out.println(generator);
		}
		input.close();
	}
}

