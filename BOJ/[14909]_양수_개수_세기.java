import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		int nPositiveIntegers = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		while(st.hasMoreTokens()) {
			int k = Integer.parseInt(st.nextToken());
			if(k > 0) {
				nPositiveIntegers++;
			}
		}
		
		System.out.println(nPositiveIntegers);
		br.close();
	}
}

