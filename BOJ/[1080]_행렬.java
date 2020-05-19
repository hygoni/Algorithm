import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static char[][] A;
    static char[][] B;
    public static void flip(char mat[][], int x, int y) {
        for(int Y = y; Y < y + 3; Y++) {
            for(int X = x; X < x + 3; X++) {
                mat[Y][X] = (mat[Y][X] == '1') ? '0' : '1';
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        A = new char[N][M];
        B = new char[N][M];

        for(int y = 0; y < N; y++) {
            String line = br.readLine();
            for(int x = 0; x < M; x++) {
                A[y][x] = line.charAt(x);
            }
        }

        for(int y = 0; y < N; y++) {
            String line = br.readLine();
            for (int x = 0; x < M; x++) {
                B[y][x] = line.charAt(x);
            }
        }

        //인풋이 3x3보다 작을 때
        if (!(N >= 3 && M >= 3)) {
            for(int y = 0; y < N; y++) {
                for (int x = 0; x < M; x++) {
                    if (A[y][x] != B[y][x]) {
                        System.out.println(-1);
                        return;
                    }
                }
            }
            System.out.println(0);
            return;
        }

        int ans = 0;
        for(int y = 0; y < N - 2; y++) {
            for (int x = 0; x < M - 2; x++) {
                if (A[y][x] != B[y][x]) {
                    flip(A, x, y);
                    ans++;
                }
            }
        }

        for(int y = 0; y < N; y++) {
            for (int x = 0; x < M; x++) {
                if (A[y][x] != B[y][x]) {
                    System.out.println(-1);
                    return;
                }
            }
        }
        System.out.println(ans);
    }
}
