import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		while(st.countTokens() != 1) {
			int count[] = new int[100];
			//숫자 갯수 세기
			int token = Integer.parseInt(st.nextToken());
			while(st.hasMoreTokens()) {
				if(token == 0) {
					break;
				} else {
					count[token]++;
					token = Integer.parseInt(st.nextToken());
				}
			}
			int ans = 0;
			for(int i = 1; i <= 49; i++) { //반만 탐색해야함.
				if(count[i] != 0) {
					ans += count[i * 2];
				}
			}	
			System.out.println(ans);
			st = new StringTokenizer(br.readLine());
		}
		br.close();
	}
}

