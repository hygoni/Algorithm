import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main { 
	public static boolean isPalindrome(String word, int s, int e) {	
		if(s == e) return true;
		else if(e - s == 1) return word.charAt(s) == word.charAt(e);
		return word.charAt(s) == word.charAt(e) && isPalindrome(word, s+1, e-1);
	}
	public static boolean isPseudoPalindrome(String word, int s, int e, int depth) {
		if(s == e) {
			return true;
		} else if(e - s == 1) {
			return word.charAt(s) == word.charAt(e);
		} else if(word.charAt(s) == word.charAt(e)) {
			return isPseudoPalindrome(word, s+1, e-1, depth);
		} else if(depth == 0) {
			return isPseudoPalindrome(word, s+1, e, depth+1) || isPseudoPalindrome(word, s, e-1, depth+1);
		} else {
			return false;
		}
	}
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < N; i++) {
			String line = br.readLine();
			int ans = 2;
			if(isPalindrome(line, 0, line.length()-1)) {
				ans = 0;
			} else if(isPseudoPalindrome(line, 0, line.length()-1, 0)) {
				ans = 1;
			}
			System.out.println(ans);
		}
		br.close();
	}
}
