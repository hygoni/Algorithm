import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Vertex {
    int x, y, nBroken, dist;
    public Vertex(int x, int y, int nBroken, int dist) {
        this.x = x;
        this.y = y;
        this.nBroken = nBroken;
        this.dist = dist;
    }
}

public class Main {
    static int K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        char map[][] = new char[N][M];
        for(int y = 0; y < N; y++) {
            String line = br.readLine();
            for(int x = 0; x < M; x++) {
                map[y][x] = line.charAt(x);
            }
        }
        br.close();

        boolean visited[][][][] = new boolean[N][M][K + 1][2];
        Queue<Vertex> q = new LinkedList<>();
        q.add(new Vertex(0, 0, 0, 1));
        visited[0][0][0][1] = true;

        int dx[] = {1, -1, 0, 0};
        int dy[] = {0, 0, 1, -1};
        while (!q.isEmpty()) {
            Vertex u = q.poll();
            if (u.x == M - 1 && u.y == N - 1) {
                System.out.println(u.dist);
                return;
            }
            for(int i = 0; i < dx.length; i++) {
                int X = u.x + dx[i];
                int Y = u.y + dy[i];
                int dayTime = (u.dist % 2 == 1) ? 1 : 0;
                int next = (dayTime + 1) % 2;
                //안 부수고 그대로 있는 경우
                if (!visited[u.y][u.x][u.nBroken][next]) {
                    visited[u.y][u.x][u.nBroken][next] = true;
                    q.add(new Vertex(u.x, u.y, u.nBroken, u.dist + 1));
                }
                if (0 <= X && X < M && 0 <= Y && Y < N) {
                    //벽은 낮에만 부술 수 있음
                    if (map[Y][X] == '1' && dayTime == 1) {
                        if (u.nBroken < K && !visited[Y][X][u.nBroken + 1][next]) {
                            visited[Y][X][u.nBroken + 1][next] = true;
                            q.add(new Vertex(X, Y, u.nBroken + 1, u.dist + 1));
                        }
                    } else if (!visited[Y][X][u.nBroken][next] && map[Y][X] == '0') {
                        visited[Y][X][u.nBroken][next] = true;
                        q.add(new Vertex(X, Y, u.nBroken, u.dist + 1));
                    }
                }
            }
        }
        System.out.println(-1);
    }
}
