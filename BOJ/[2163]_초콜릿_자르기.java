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
        int d[][] = new int[N + 1][M + 1];

        for(int n = 1; n <= N; n++) {
            for(int m = 1; m <= M; m++) {
                d[n][m] = Integer.MAX_VALUE;
            }
        }

        d[1][1] = 0;
        for(int n = 1; n <= N; n++) {
            for(int m = 1; m <= M; m++) {
                if (n == 1 && m == 1)
                    continue;
                for(int k = 1; k < n; k++) {
                    d[n][m] = Math.min(d[n][m], d[n - k][m] + d[k][m] + 1);
                }
                for(int k = 1; k < m; k++) {
                    d[n][m] = Math.min(d[n][m], d[n][m - k] + d[n][k] + 1);
                }
            }
        }
        System.out.println(d[N][M]);
    }
}
