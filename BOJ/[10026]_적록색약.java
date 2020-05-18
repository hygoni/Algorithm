import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

class Dot {
    int x, y;
    public Dot(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static char[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        for(int y = 0; y < N; y++) {
            String line = br.readLine();
            for(int x = 0; x < N; x++) {
                map[y][x] = line.charAt(x);
            }
        }
        br.close();

        boolean visited[][] = new boolean[N][N];
        Queue<Dot> q = new LinkedList<>();

        int col = 0;
        for(int y = 0; y < N; y++) {
            for(int x = 0; x < N; x++) {
                if (!visited[y][x]) {
                    q.add(new Dot(x, y));
                    visited[y][x] = true;
                    while (!q.isEmpty()) {
                        Dot u = q.poll();
                        int dx[] = {-1, 1, 0, 0};
                        int dy[] = {0, 0 ,-1, 1};
                        for(int i = 0; i < dx.length; i++) {
                            int X = dx[i] + u.x;
                            int Y = dy[i] + u.y;
                            if (0 <= X && X < N && 0 <= Y && Y < N) {
                                if (visited[Y][X])
                                    continue;
                                if (map[Y][X] == map[u.y][u.x]) {
                                    visited[Y][X] = true;
                                    q.add(new Dot(X, Y));
                                }
                            }
                        }
                    }
                    col++;
                }
            }
        }
        System.out.print(col + " ");

        visited = new boolean[N][N];
        col = 0;
        for(int y = 0; y < N; y++) {
            for(int x = 0; x < N; x++) {
                if (!visited[y][x]) {
                    q.add(new Dot(x, y));
                    visited[y][x] = true;
                    while (!q.isEmpty()) {
                        Dot u = q.poll();
                        int dx[] = {-1, 1, 0, 0};
                        int dy[] = {0, 0 ,-1, 1};
                        for(int i = 0; i < dx.length; i++) {
                            int X = dx[i] + u.x;
                            int Y = dy[i] + u.y;
                            if (0 <= X && X < N && 0 <= Y && Y < N) {
                                if (visited[Y][X])
                                    continue;
                                if (map[u.y][u.x] == 'R' || map[u.y][u.x] == 'G') {
                                    if (map[Y][X] == 'R' || map[Y][X] == 'G') {
                                        visited[Y][X] = true;
                                        q.add(new Dot(X, Y));
                                    }
                                } else {
                                    if (map[Y][X] == map[u.y][u.x]) {
                                        visited[Y][X] = true;
                                        q.add(new Dot(X, Y));
                                    }
                                }
                            }
                        }
                    }
                    col++;
                }
            }
        }
        System.out.println(col);
    }
}
