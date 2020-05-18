import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        long arr[] = new long[N];

        for(int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }
        br.close();
        Arrays.sort(arr);

        int start = 0;
        int end = 0;
        long ans = Integer.MAX_VALUE;
        while (start < N && end < N) {
            while (end < N && arr[end] - arr[start] < M) {
                end++;
            }
            if (end != N) {
                ans = Math.min(ans, arr[end] - arr[start]);
            }
            start++;
        }
        System.out.println(ans);
    }
}
