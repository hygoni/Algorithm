import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

	public static int LCS(String word1, String word2) {
		int d[][] = new int[word1.length() + 1][word2.length() + 1];
		StringBuilder sb = new StringBuilder();
		int max = 0;
		for(int i = 0; i < word1.length(); i++) {
			for(int j = 0; j < word2.length(); j++) {
				if(word1.charAt(i) == word2.charAt(j)) {
					d[i+1][j+1] = d[i][j] + 1;
					max = Math.max(d[i+1][j+1], max);
				} else {
					d[i+1][j+1] = Math.max(d[i][j+1], d[i+1][j]);
				}
			}
		}
		
		return max;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String word1 = br.readLine();
		String word2 = br.readLine();
		System.out.println(LCS(word1, word2));
	}
}

