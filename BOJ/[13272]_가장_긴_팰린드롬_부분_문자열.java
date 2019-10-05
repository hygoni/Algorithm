import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static String preprocess(String word) {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < word.length(); i++) {
			sb.append("#");
			sb.append(word.charAt(i));
		}
		sb.append("#");
		return sb.toString();
	}
	public static int LPS(String word) {
		int maxLen = 0;
		word = preprocess(word); //전처리
		int A[] = new int[word.length()]; //i번째 문자열을 가운데로 하는 회문의 길이
		int center = 0; //가장 긴 회문의 중앙 인덱스
		int right = 0; //가장 긴 회문의 경계		
		for(int i = 1; i < word.length(); i++) {
			if(i <= right) { //i가 가장 긴 회문의 경계에 포함되는경우
				int mirror = 2 * center - i; //미러 : 회문의 대칭이 되는 부분의 인덱스
				A[i] = Math.min(right-i, A[mirror]);
			} else {
				A[i] = 0;
			}
			while((i-A[i]-1 >= 0 && i + A[i] + 1 < word.length()) 
					&& (word.charAt(i-A[i]-1) == word.charAt(i+A[i]+1))) {
				A[i]++;
			}
			//회문이 확장되었으면 경계와 가운데 인덱스를 업데이트
			if(right < i+A[i]) {
				right = i+A[i];
				center = i;
			}
		}
		for(int i = 0; i < A.length; i++) {
			if(maxLen < A[i]) {
				maxLen = A[i];
			}
		}
		return maxLen;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String line = br.readLine();
		bw.write(LPS(line) + "\n");
		br.close();
		bw.close();
	}
}

