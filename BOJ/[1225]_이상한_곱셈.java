import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static long strangeMultiply(String a, String b) {
		long sum = 0;
		for(int i = 0; i < a.length(); i++) {
			int n_a = a.charAt(i) - '0';
			for(int j = 0; j < b.length(); j++) {
				int n_b = b.charAt(j) - '0';
				sum += (n_b * n_a);
			}
		}
		return sum;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String a = st.nextToken();
		String b = st.nextToken();
		System.out.println(strangeMultiply(a, b));
		br.close();
	}

}

