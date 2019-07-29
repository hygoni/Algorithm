import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(tokenizer.nextToken());
		int k = Integer.parseInt(tokenizer.nextToken());
		Integer[] arr = new Integer[n];
		tokenizer = new StringTokenizer(br.readLine(), " ");
		
		for(int i = 0; tokenizer.hasMoreTokens(); i++) {
			arr[i] = Integer.parseInt(tokenizer.nextToken());
		}
		
		Arrays.sort(arr);
		bw.write(arr[k-1] + "\n");
		bw.flush();
	}

}
