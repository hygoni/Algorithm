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
		
		boolean is_set = true;
		for(int i = 1; i < n; i++) {
			if(set[i-1] == set[i]) {
				is_set = false;
				break;
			}
		}
		
		if(is_set) {
			System.out.println("This is set!");
		} else {
			System.out.println("Tihs is not set!");
		}
	}

}
