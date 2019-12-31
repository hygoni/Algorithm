import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int arr[] = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());

		for(int i = 0; i < N; i++) {	
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		int ans;
		if(arr.length == 1) {
			ans = arr[0] * arr[0];
		} else {
			ans = arr[0] * arr[N-1];
		}
		
		System.out.println(ans);
		br.close();
	}
}
