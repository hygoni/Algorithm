import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {	 
		BufferedReader br = new  BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		long p[] = new long[10000+1];
		p[1] = 1;
		p[2] = 1;
		p[3] = 1;
		p[4] = 2;
		p[5] = 2;
		
		for(int i = 6; i <= 100; i++) {
			p[i] = p[i-1] + p[i-5];
		}
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 0; t < T; t++) {
			int n = Integer.parseInt(br.readLine());
			bw.write(p[n] + "\n");
		}
		
        bw.flush();
		br.close();
		bw.close();
	}
}

