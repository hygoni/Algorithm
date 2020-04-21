import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int map[][] = new int[N][N];
        for (int y = 0; y < N; y++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int x = 0; x < N; x++) {
                map[y][x] = Integer.parseInt(st.nextToken());
            }
        }
        br.close();

        long d[][] = new long[N][N];
        d[0][0] = 1;
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < N; x++) {
                if (d[y][x] == 0 || (y == N - 1 && x == N - 1))
                    continue;
                int dist = map[y][x];
                if (y + dist < N) {
                    d[y + dist][x] += d[y][x];
                }
                if (x + dist < N) {
                    d[y][x + dist] += d[y][x];
                }
            }
        }
        System.out.println(d[N - 1][N - 1]);
    }
}
