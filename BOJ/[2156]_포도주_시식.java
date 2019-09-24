mport java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int wines[] = new int[n+1];
		int d[] = new int[n+1];
		
		for(int i = 1; i <= n; i++) {
			wines[i] = Integer.parseInt(br.readLine());
		}
		
		if(n >= 1) {
			d[1] = wines[1];
		} 
		
		if(n >= 2) {
			d[2] = wines[1] + wines[2];
		}
		
		if(n >= 3) {
			d[3] = Math.max(d[2], d[1] + wines[3]);
			d[3] = Math.max(d[3], wines[2] + wines[3]);
		}

		for(int i = 4; i <= n; i++) {
			d[i] = Math.max(d[i-1], d[i-2] + wines[i]); //1칸 넘어온 경우 or 지금 안 먹는경우
			d[i] = Math.max(d[i], d[i-3] + wines[i-1] + wines[i]); //2칸 넘어온 경우
		}
		
		bw.write(d[n] + "\n");
		bw.flush();
		br.close();
		bw.close();
	}
}

