import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
			
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");
		int[] array = new int[n];
		
		for(int i = 0; i < n; i++) {
			array[i] = Integer.parseInt(tokenizer.nextToken());
		}
		
		int max = array[0];
		for(int a = 0; a < n; a++) {
			int sum = 0;
			for(int b = a; b < n; b++) {
				sum += array[b];
				if(sum > max)
					max = sum;
			}
			
		}
		
		bw.write(max + "\n");
		bw.flush(); //버퍼 비우기
		
		
	}

}
