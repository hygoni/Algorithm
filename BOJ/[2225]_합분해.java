import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int Q = 1_000_000_000;
        br.close();
        int d[][] = new int[N + 1][200 + 1];

        for(int n = 0; n <= N; n++) {
            d[n][1] = 1;
        }
        for(int n = 0; n <= N; n++) {
            for(int k = 1; k <= 200; k++) {
                for(int i = 0; i <= n; i++) {
                    d[n][k] += (d[n - i][k - 1] % Q);
                    d[n][k] = d[n][k] % Q;
                }
            }
        }
        System.out.println(d[N][K]);

    }
}
