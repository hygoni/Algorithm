import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {	 
		BufferedReader br = new  BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int cost[][] = new int[n+1][n];
		int costSum[][] = new int[n+1][n];

		for(int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < i; j++) {
				cost[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 1; i <= n; i++) {
			for(int j = 0; j < i; j++) {
				if(j == 0) {
					costSum[i][j] = costSum[i-1][j] + cost[i][j];
				} else if(j == i-1) {
					costSum[i][j] = costSum[i-1][j-1] + cost[i][j];
				} else {
					costSum[i][j] = Math.max(costSum[i-1][j-1], costSum[i-1][j]) + cost[i][j];
				}
			}
		}
		
		int max = 0;
		for(int i = 1; i < n; i++) {
			if(max < costSum[n][i]) {
				max = costSum[n][i];
			}
		}
		bw.write(max + "\n");
		bw.flush();
		br.close();
		bw.close();
	}
}

