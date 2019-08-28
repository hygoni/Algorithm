import java.util.Scanner;

public class Main {

	public static void main(String ... args) {
		Scanner input = new Scanner(System.in);
		String line = input.nextLine();
		int[] n_chars = new int[26];
		
		for(int i = 0; i < line.length(); i++) {
			char ch = line.charAt(i);
			if(('a' <= ch) && (ch <= 'z')) {
				n_chars[ch - 'a']++;
			} else {
				n_chars[ch - 'A']++;
			}
		}
		
		int max_idx = 0;
		for(int i = 0; i < 26; i++) {
			if(n_chars[max_idx] < n_chars[i]) {
				max_idx = i;
			}
		}
		boolean max_more_than_one = false;
		for(int i = 0; i < 26; i++) {
			if((n_chars[max_idx] == n_chars[i]) && (i != max_idx)) {
				max_more_than_one = true;
			}
		}
		
		if(max_more_than_one) {
			System.out.println("?");
		} else {
			System.out.println((char) (max_idx + 'A'));
		}

		input.close();
	}
}
