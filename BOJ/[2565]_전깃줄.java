import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int wires[] = new int[500+1];
		int arr[] = new int[n+1];
		int idx = 1;

		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			wires[a] = b;
		}

		for(int i = 1; i <= 500; i++) {
			if(wires[i] != 0) {
				arr[idx++] = wires[i];
			}
		}

		int LIS[] = new int[n+1];
		for(int i = 1; i <= n; i++) {
			LIS[i] = Math.max(LIS[i], 1);
			for(int j = 1; j < i; j++) {
				if(arr[i] > arr[j] && LIS[i] < LIS[j] + 1) {
					LIS[i] = LIS[j] + 1;
				}
			}
		}

		int maxLIS = 0;
		for(int i = 0; i <= n; i++) {
			maxLIS = Math.max(maxLIS, LIS[i]);
		}

		System.out.println(n - maxLIS);
		br.close();
	}
}

