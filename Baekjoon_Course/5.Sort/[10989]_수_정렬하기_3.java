import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		int[] numbers = new int[10000];
		
		for(int i = 0; i < n; i++) {
			int idx = Integer.parseInt(br.readLine()) - 1;
			numbers[idx] += 1;
		}
			
		for(int i = 0; i < 10000; i++) {
			for(int j = 0; j < numbers[i]; j++) {
				bw.write((i+1) + "\n");
			}
		}
		
		bw.flush();
	}

}
