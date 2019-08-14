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
		int set = 1;
		while(n != 0) {
			
			StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");
			int[] arr = new int[n];
			int mean = 0;
			for(int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(tokenizer.nextToken());
				mean += arr[i];
			}
			mean /= n;
			int sum = 0;
			for(int i = 0; i < n; i++) {
				sum += Math.abs(mean-arr[i]);
			}
			sum /= 2;
			bw.write(String.format("Set #%d\n", set++));
			bw.write(String.format("The minimum number of moves is %d.\n\n", sum));
			bw.flush();
			
			n = Integer.parseInt(br.readLine());
		}
	}
}

