import java.util.Scanner;

public class Main {

	public static void main(String ... args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt(); //nth fraction
		int start = 0;
		int end = 0;

		int i = 1;
		for(;end < n; i++) {
			end += i;
		}
		start = end - (i-1) + 1;

		if((i-1) % 2 == 0) { //짝수 : 분자가 1부터 시작
			int son = 1;
			int mom = i-1;
			for(int j = 1; j+start <= n; j++) {
				son++;
				mom--;
			}
			System.out.println(son + "/" + mom);
		} else { //홀수 : 분자가 i-1부터 시작
			int son = i-1;
			int mom = 1;
			for(int j = 1; start+j <= n; j++) {
				son--;
				mom++;
			}
			System.out.println(son + "/" + mom);
		}
		
		input.close();
	}
}
