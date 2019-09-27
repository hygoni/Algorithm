import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	static boolean d[][];
	public static void LPS(int arr[]) {	
		
		//len = 1
		for(int i = 0; i < arr.length; i++) {
			d[i][i] = true;
		}

		//len = 2
		for(int i = 0; i < arr.length - 1; i++) {
			int j = i + 1;
			int len = j-i+1;
			d[i][j] = arr[i] == arr[j];
		}

		//len >= 3
		for(int k = 3; k <= arr.length; k++) {
			for(int i = 0; i < arr.length - k + 1; i++) {
				int j = i + k - 1;
				d[i][j] = d[i+1][j-1] && arr[i] == arr[j];
				int len = j-i+1;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		d = new boolean[n][n];
		int arr[] = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());

		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
	
		LPS(arr);
		int m = Integer.parseInt(br.readLine());
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int j = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			bw.write((d[j-1][k-1] ? 1 : 0)+ "\n");
		}
		
		bw.flush();
		br.close();
		bw.close();

	}
}

