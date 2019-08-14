import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//Type of problem : Array
//Time Complexity : O(N)
public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		int set = 1;
		while(n >= 0) {
			int[] created = new int[12];
			int[] required = new int[12];
			int n_available = n;
			
			StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");
			for(int i = 0; i < 12; i++) {
				created[i] = Integer.parseInt(tokenizer.nextToken());
			}
			
			tokenizer = new StringTokenizer(br.readLine(), " ");
			for(int i = 0; i < 12; i++) {
				required[i] = Integer.parseInt(tokenizer.nextToken());
			}
			
			bw.write(String.format("Case %d:\n", set++));
			for(int i = 0; i < 12; i++) {
				if(n_available >= required[i]) {
					bw.write("No problem! :D\n");
					n_available -= required[i];
				} else {
					bw.write("No problem. :(\n");
					
				}
				bw.flush();
				n_available += created[i];
			}
			
			
			n = Integer.parseInt(br.readLine());
		}
		
		br.close();
		bw.close();
	}
}

