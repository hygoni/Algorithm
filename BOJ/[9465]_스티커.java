import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        final int NONE = 2, UP = 0, DOWN = 1;

        for(int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            int stickers[][] = new int[2][N];
            int d[][] = new int[3][N];

            for(int i = 0; i < 2; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++) {
                    stickers[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            d[UP][0] = stickers[0][0];
            d[DOWN][0] = stickers[1][0];
            for(int i = 1; i < N; i++) {
                d[UP][i] = Math.max(d[DOWN][i - 1], d[NONE][i - 1]) + stickers[UP][i];
                d[DOWN][i] = Math.max(d[UP][i - 1], d[NONE][i - 1]) + stickers[DOWN][i];
                d[NONE][i] = Math.max(Math.max(d[DOWN][i - 1], d[NONE][i - 1]), d[UP][i - 1]);
            }
            System.out.println(Math.max(d[UP][N - 1], Math.max(d[DOWN][N - 1], d[NONE][N - 1])));
        }
        br.close();
    }
}
