import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Dot {
    int x, y;
    public Dot(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        Dot o = (Dot) obj;
        return (o.x == x && o.y == y);
    }
}

public class Main {
    static int N, M;
    public static int bfs(Dot dot, boolean map[][], boolean visited[][]) {
        Queue<Dot> q = new LinkedList<>();
        q.add(dot);
        visited[dot.y][dot.x] = true;

        int size = 1;
        int dx[] = {-1, 1, 0, 0};
        int dy[] = {0, 0, -1, 1};
        while (!q.isEmpty()) {
            Dot u = q.poll();
            for(int i = 0; i < 4; i++) {
                int X = u.x + dx[i];
                int Y = u.y + dy[i];
                if (0 <= X && X < M && 0 <= Y && Y < N && map[Y][X] && !visited[Y][X]) {
                    visited[Y][X] = true;
                    size++;
                    q.add(new Dot(X, Y));
                }
            }
        }
        return size;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        boolean map[][] = new boolean[N][M];
        boolean visited[][] = new boolean[N][M];

        while (K-- > 0) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken()) - 1;
            int x = Integer.parseInt(st.nextToken()) - 1;
            map[y][x] = true;
        }
        br.close();

        int ans = 0;
        for(int y = 0; y < N; y++) {
            for(int x = 0; x < M; x++) {
                if (!visited[y][x] && map[y][x]) {
                    ans = Math.max(ans, bfs(new Dot(x, y), map, visited));
                }
            }
        }
        System.out.println(ans);
    }
}
