import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	
	public static int max(int[] arr, int fromIdx, int toIdx) {
		int max = 0;
		for(int i = fromIdx; i < toIdx; i++) {
			if(max < arr[i]) {
				max = arr[i];
			}
		}
		return max;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int arr[] = new int[n];
		int LIS[] = new int[n]; //i번째로 끝나는 LIS (Longest Increasing Subsequence)
		int LDS[] = new int[n]; //i번째로 시작하는 LDS (Longest Decreasing Subsequence)
		int LBS[] = new int[n]; //i번째를 중심으로 하는 Longest Bitonic Subsequence
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i < n; i++) {
			if(LIS[i] == 0) {
				LIS[i] = 1;
			}
			for(int j = 0; j < i; j++) {
				if(arr[i] > arr[j] && LIS[i] < LIS[j] + 1) {
					LIS[i] = LIS[j] + 1;
				}
					
			}
		}
		
		for(int i = n-1; i >= 0; i--) {
			if(LDS[i] == 0) {
				LDS[i] = 1;
			}
			for(int j = n-1;  j >= 0; j--) {
				if(arr[i] > arr[j] && LDS[i] < LDS[j] + 1) {
					LDS[i] = LDS[j] + 1;
				}
			}
		}
		
		for(int i = 0; i < n; i++) {
			if(i == 0) {
				LBS[i] = max(LDS, 0, n);
			} else if(i == n-1) {
				LBS[i] = max(LIS, 0, n);
			} else {
				LBS[i] = max(LIS, 0, i+1) + max(LDS, i, n) - 1;
			}
		}
		int max = max(LBS, 0, n);
		
		bw.write(max + "\n");
		bw.flush();
		br.close();
		bw.close();
	}
}

