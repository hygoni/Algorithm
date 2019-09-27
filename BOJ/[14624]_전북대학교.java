import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		
		if(n % 2 == 0) {
			bw.write("I LOVE CBNU\n");
		} else {
			for(int i = 0; i < n; i++) {
				bw.write("*");
			}
			bw.write("\n");
			int center = (n-1)/2;
			for(int i = 0; i <= center; i++) {
				for(int j = 0; j < n; j++) {
					if(Math.abs(center - j) == i) {
						bw.write("*");
						if(center - j < 0 || i == 0) {
							break;
						}
					} else {
						bw.write(" ");
					}
				}
				if(i != center)
					bw.write("\n");
			}
		}
		
		bw.flush();
		br.close();
		bw.close();

	}
}

