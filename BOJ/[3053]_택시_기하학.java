import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {	 
		Scanner input = new Scanner(System.in);
		double r = input.nextDouble();
		System.out.println(Math.PI * r * r);
		System.out.println((2*r) * (2*r) * 0.5);
		input.close();
	}
}

