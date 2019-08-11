import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

//Type of problem : Sequence
//Time Complexity : O(N)
public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		String line = br.readLine();
		StringTokenizer tokenizer = new StringTokenizer(line, " ");
		int[] set = new int[n];
		int longest = 1;
		
		for(int i = 0; i < n; i++) {
			set[i] = Integer.parseInt(tokenizer.nextToken());
		}
		
		int asc_cnt = 1;
		for(int i = 1; i < n; i++) {
			if(set[i-1] < set[i]) {
				asc_cnt++;
				if(longest < asc_cnt){
					longest = asc_cnt;
				}
			} else {
				asc_cnt = 1;
			}
			
		}
		
		bw.write(longest + "\n");
		bw.flush();
		
		
		
	}

}
