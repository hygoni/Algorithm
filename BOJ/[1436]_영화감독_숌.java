import java.util.Scanner;

public class Main {

	public static boolean isEndNum(int n) {
		String num = Integer.toString(n);
		int continuous = 0;
		int max = 0;
		for(int i = 0; i < num.length(); i++) {
			if(num.charAt(i) == '6') {
				continuous++;
				if(max < continuous) {
					max = continuous;
				}
			} else {
				continuous = 0;
			}
		}
		return max >= 3;
	}
	public static void main(String[] args) {	 
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int cnt = 0;
		for(int i = 666;; i++) {
			if(isEndNum(i)) {
				cnt++;
				if(n == cnt) {
					System.out.println(i);
					break;
				}
			}
		}

		input.close();
	}
}

