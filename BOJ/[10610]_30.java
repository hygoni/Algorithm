import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String n = br.readLine();
		StringBuilder sb = new StringBuilder();
		int count[] = new int[10];
		
		int sum = 0;
		for(int i = 0; i < n.length(); i++) {
			int num = n.charAt(i) - '0';
			count[num]++;
			sum += num;
		}
		
		if(sum % 3 != 0 || count[0] == 0) {
			System.out.println(-1);
			return;
		}
				
		for(int i = count.length - 1; i >= 0; i--) {
			for(int j = 0; j < count[i]; j++) {
				sb.append(i);
			}
		}
		
		System.out.println(sb);		
		br.close();
	}
}
