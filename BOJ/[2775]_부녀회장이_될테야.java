import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

//Type of problem : Array
//Time Complexity : O(N)

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int t = Integer.parseInt(br.readLine());
		for(int i = 0; i < t; i++) {
			int k = Integer.parseInt(br.readLine()) + 1;
			int n = Integer.parseInt(br.readLine());
			int[][] arr = new int[k][n];
			
			for(int j = 0; j < n; j++) {
				arr[0][j] = j+1;
			}
			
			for(int j = 1; j < k; j++) {
				for(int l = 0; l < n; l++) {
					for(int m = 0; m <= l; m++) {
						arr[j][l] += arr[j-1][m];
					}
				}
			}
			
			bw.write(arr[k-1][n-1] + "\n");
			bw.flush();
		}
		
		br.close();
		bw.close();
	}
}

