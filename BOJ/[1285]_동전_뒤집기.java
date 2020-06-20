import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char coin[][] = new char[N][N];

        for(int y = 0; y < N; y++) {
            String line = br.readLine();
            for(int x = 0; x < N; x++) {
                coin[y][x] = line.charAt(x);
            }
        }
        br.close();

        int ans = N * N;
        for(int state = 0; state < (1 << N); state++) {
            int sum = 0;
            for(int x = 0; x < N; x++) {
                int cnt = 0;
                for(int y = 0; y < N; y++) {
                    char cur = coin[y][x];
                    if ((state & (1 << y)) > 0) {
                        cur = (cur == 'T') ? 'H' : 'T';
                    }
                    if (cur == 'T') {
                        cnt++;
                    }
                }
                sum += Math.min(cnt, N - cnt);
            }
            ans = Math.min(ans, sum);
        }
        System.out.println(ans);
    }
}
