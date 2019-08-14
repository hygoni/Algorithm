import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//Type of problem : Array
//Time Complexity : O(N)

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		while(n != 0) {
			int[] blank_arr = new int[n];
			char[][] arr = new char[25][n];
			int blank_sum = 0;
			int blank_min = 26;
			
			for(int i = 0; i < n; i++) {
				String line = br.readLine();
				for(int j = 0; j < 25; j++) {
					char ch = line.charAt(j);
					arr[j][i] = ch;
					if(ch == ' ') {
						blank_arr[i]++;
						blank_sum++;
					}
					if(j == 24) {
						if(blank_min > blank_arr[i])
							blank_min = blank_arr[i];
					}
				}
			}
			int blank = blank_sum - blank_min * n;
			bw.write(blank + "\n");
			bw.flush();
			n = Integer.parseInt(br.readLine());
		}
		
		br.close();
		bw.close();
	}
}

