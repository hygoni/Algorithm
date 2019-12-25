mport java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int arr[] = new int[N+1];
		
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		int min = 0;
		int ans = 0;
		for(int i = N-1; i >= 0; i--) {
			if(arr[i] > min) {
				ans++;
				min = Math.max(min, arr[i]);
			}
		}
		
		System.out.println(ans);
		br.close();
	}
}
