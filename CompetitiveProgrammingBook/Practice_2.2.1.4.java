import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

//Type of problem : Sort
//Time Complexity : O(N log N)
public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		String line = br.readLine();
		StringTokenizer tokenizer = new StringTokenizer(line, " ");
		int[] set = new int[n];
		
		for(int i = 0; i < n; i++) {
			set[i] = Integer.parseInt(tokenizer.nextToken());
		}
		
		int from = Integer.parseInt(br.readLine());
		int to = Integer.parseInt(br.readLine());
		
		int[] subSet = new int[to - from + 1];
		for(int i = from; i <= to; i++) {
			subSet[i-from] = set[i-1];
		}
		
		Arrays.sort(subSet);
		for(int i = 0; i < subSet.length; i++) {
			System.out.println(subSet[i]);			
		}
		
		
		
	}

}
