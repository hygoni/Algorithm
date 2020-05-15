import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Vertex {
    int x, y, time;
    public Vertex(int x, int y, int time) {
        this.x = x;
        this.y = y;
        this.time = time;
    }
}

public class Main {
    static char map[][][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = 8;
        map = new char[N][N][N * N * N + 1]; //8 : 시간 (0 ~ 7)
        for(int y = 0; y < N; y++) {
            String line = br.readLine();
            for(int x = 0; x < N; x++) {
                map[y][x][0] = line.charAt(x);
            }
        }
        br.close();

        //시간별 맵 생성
        for(int i = 1; i < N; i++) {
            for(int y = 0; y < i; y++) {
                for(int x = 0; x < N; x++) {
                    map[y][x][i] = '.';
                }
            }
            for(int y = i; y < N; y++) {
                for(int x = 0; x < N; x++) {
                    map[y][x][i] = map[y - 1][x][i - 1];
                }
            }
        }

        boolean visited[][][] = new boolean[N][N][N * N * N + 1];
        Queue<Vertex> q = new LinkedList<>();
        q.add(new Vertex(0, N - 1, 0));
        visited[N - 1][0][0] = true;

        //상하좌우 대각선 정지
        int dx[] = {1, -1, 0, 0, 1, 1, -1, -1, 0};
        int dy[] = {0, 0, 1, -1, 1, -1, 1, -1, 0};
        while (!q.isEmpty()) {
            Vertex u = q.poll();
            if (map[u.y][u.x][u.time] == '#') {
                continue; //건물과 충돌한 경우
            } else if (u.x == N - 1 && u.y == 0) {
                System.out.println(1);
                return;
            }

            for(int i = 0; i < dx.length; i++) {
                int X = u.x + dx[i];
                int Y = u.y + dy[i];
                if (0 <= X && X < N && 0 <= Y && Y < N) {
                    if (map[Y][X][u.time] != '#' && !visited[Y][X][u.time + 1]) {
                        visited[Y][X][u.time + 1] = true;
                        q.add(new Vertex(X, Y, u.time + 1));
                    }
                }
            }
        }
        System.out.println(0);
    }
}
