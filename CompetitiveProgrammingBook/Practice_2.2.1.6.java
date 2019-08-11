import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

//Type of problem : Sort
//Time Complexity : O(NlogN)
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
		
		Arrays.sort(set);
		int median;
		median = set[(set.length - 1) / 2];
		
		bw.write(median + "\n");
		bw.flush();
		
	}

}
