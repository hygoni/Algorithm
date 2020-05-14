import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Dot {
    int x, y, dist;
    public Dot(int x, int y, int dist) {
        this.x = x;
        this.y = y;
        this.dist = dist;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r1 = Integer.parseInt(st.nextToken());
        int c1 = Integer.parseInt(st.nextToken());
        int r2 = Integer.parseInt(st.nextToken());
        int c2 = Integer.parseInt(st.nextToken());
        br.close();

        Queue<Dot> q = new LinkedList<>();
        q.add(new Dot(r1, c1, 0));

        int dx[] = {-2, -2, 0, 0, 2, 2};
        int dy[] = {-1, 1, -2, 2, -1, 1};
        boolean visited[][] = new boolean[N][N];
        visited[r1][c1] = true;
        while (!q.isEmpty()) {
            Dot dot = q.poll();
            if (dot.x == r2 && dot.y == c2) {
                System.out.println(dot.dist);
                break;
            }
            for(int i = 0; i < dx.length; i++) {
                int X = dot.x + dx[i];
                int Y = dot.y + dy[i];

                if (0 <= X && X < N && 0 <= Y && Y < N) {
                    if (visited[X][Y]) {
                        continue;
                    }
                    q.add(new Dot(X, Y, dot.dist + 1));
                    visited[X][Y] = true;
                }
            }
        }
        if (!visited[r2][c2]) {
            System.out.println(-1);
        }
    }
}
