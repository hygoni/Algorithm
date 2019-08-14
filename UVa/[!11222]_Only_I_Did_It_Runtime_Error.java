import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//Type of problem : Array & Sum
//Time Complexity : O(N)
public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		for(int i = 0; i < n; i++) {
			int[] n_problems = new int[3];
			int[][] problems = new int[3][10000+1];
			
			for(int j = 0; j < 3; j++) {
				StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");
				int k = Integer.parseInt(tokenizer.nextToken());
				for(int l = 0; l < k; l++) {
					int problem = Integer.parseInt(tokenizer.nextToken());
					problems[j][problem] = 1;
				}
			}
			
			for(int j = 0; j < 10000+1; j++) {
				if(problems[0][j] + problems[1][j] + problems[2][j] == 0) {
					continue;
				} else if((problems[0][j] + problems[1][j] + problems[2][j]) == 1) {
					if(problems[0][j] == 1) {
						n_problems[0]++;
					} else if(problems[1][j] == 1) {
						n_problems[1]++;
					} else {
						n_problems[2]++;
					}
				}
			}
			
			int max_count = 0;
			for(int j = 0; j < 3; j++) {
				if(max_count < n_problems[j])
					max_count = n_problems[j];
			}
			
			bw.write(String.format("Case #%d:\n", i+1));
			for(int j = 0; j < 3; j++) {
				if(n_problems[j] == max_count) {
					bw.write((j+1)+" " + max_count);
					for(int k = 0; k < 10001; k++) {
						if((problems[j][k] == 1) && (problems[0][k] + problems[1][k] + problems[2][k] == 1))
							bw.write(" " + k);
					}
					bw.write("\n");
					bw.flush();
				}
			}
			
			
		}
		
		br.close();
		bw.close();
	}
}

