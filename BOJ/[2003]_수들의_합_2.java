import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int arr[] = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        br.close();

        int sum = 0;
        int ans = 0;
        int e = 0;
        for(int s = 0; s < N; s++) {
            while (sum < M && e < N) {
                sum += arr[e];
                if (sum == M) {
                    ans++;
                }
                e++;
            }
            sum -= arr[s];
            if (sum == M) {
                ans++;
            }
        }
        System.out.println(ans);
    }
}
