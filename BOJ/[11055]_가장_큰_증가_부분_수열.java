import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int arr[] = new int[N + 1];
        int d[] = new int[N + 1];
        int sum[] = new int[N + 1];
        int min = Integer.MAX_VALUE;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            d[i] = arr[i];
        }

        int max = 0;
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= i; j++) {
                if (arr[j] < arr[i]) {
                    d[i] = Math.max(d[i], d[j] + arr[i]);
                }
            }
            max = Math.max(max, d[i]);
        }
        System.out.println(max);

    }
}
