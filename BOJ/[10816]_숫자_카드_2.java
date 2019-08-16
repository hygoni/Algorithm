import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//Type of problem : Sort
//Time Complexity : O(N)

public class Main {

	//5 1 11
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");
		int wall = 10_000_000;
		int[] arr = new int[wall + 10_000_001];
		
		for(int i = 0; i < n; i++) {
			arr[Integer.parseInt(tokenizer.nextToken()) + wall]++;
		}
		
		int m = Integer.parseInt(br.readLine());
		tokenizer = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < m; i++) {
			
			int target = Integer.parseInt(tokenizer.nextToken());
						
			bw.write(arr[target + wall] + " ");
		}
		
		bw.flush();
		br.close();
		bw.close();
	}



}

