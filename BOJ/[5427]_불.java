import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void spread(char map[][], int spread[][]) {
        Queue<Integer> qx = new LinkedList<>();
        Queue<Integer> qy = new LinkedList<>();
        boolean visited[][] = new boolean[map.length][map[0].length];
        for(int y = 0; y < map.length; y++) {
            for(int x = 0; x < map[y].length; x++) {
                spread[y][x] = Integer.MAX_VALUE;
                if (map[y][x] == '*') {
                    qx.add(x);
                    qy.add(y);
                    visited[y][x] = true;
                    spread[y][x] = 0;
                }
            }
        }

        while (!qx.isEmpty()) {
            int ux = qx.poll();
            int uy = qy.poll();
            int dx[] = {-1, 1, 0, 0};
            int dy[] = {0, 0, -1, 1};
            for(int i = 0; i < 4; i++) {
                int X = ux + dx[i];
                int Y = uy + dy[i];
                if (0 <= Y && Y < map.length && 0 <= X && X < map[Y].length) {
                    if (!visited[Y][X] && map[Y][X] != '#') {
                        visited[Y][X] = true;
                        spread[Y][X] = spread[uy][ux] + 1;
                        qx.add(X);
                        qy.add(Y);
                    }
                }
            }
        }
    }

    public static int bfs(int x, int y, char map[][], int spread[][]) {
        Queue<Integer> qx = new LinkedList<>();
        Queue<Integer> qy = new LinkedList<>();
        boolean visited[][] = new boolean[map.length][map[0].length];
        visited[y][x] = true;
        qx.add(x);
        qy.add(y);
        int time[][] = new int[map.length][map[0].length];
        while (!qx.isEmpty()) {
            int ux = qx.poll();
            int uy = qy.poll();
            int dx[] = {-1, 1, 0, 0};
            int dy[] = {0, 0, -1, 1};
            for(int i = 0; i < 4; i++) {
                int X = ux + dx[i];
                int Y = uy + dy[i];
                if (0 <= Y && Y < map.length && 0 <= X && X < map[Y].length) {
                    if (!visited[Y][X] && map[Y][X] != '#'&& map[Y][X] != '*' && spread[Y][X] > time[uy][ux] + 1) {
                            visited[Y][X] = true;
                        time[Y][X] = time[uy][ux] + 1;
                        qx.add(X);
                        qy.add(Y);
                    }
                }
            }
        }
        boolean found = false;
        int ans = Integer.MAX_VALUE;
        for(y = 0; y < map.length; y++) {
            for(x = 0; x < map[y].length; x++) {
                if ((0 != y && y != map.length - 1) && (0 != x && x != map[y].length - 1))
                    continue;
                if ((map[y][x] != '#' || map[y][x] == '@') && visited[y][x]) {
                    found = true;
                    ans = Math.min(ans, time[y][x]);
                }
            }
        }
        if (found) {
            return ans + 1;
        } else {
            return -1;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            char map[][] = new char[N][M];
            int spread[][] = new int[N][M];
            int X = 0, Y = 0;
            for(int y = 0; y < N; y++) {
                String line = br.readLine();
                for(int x = 0; x < M; x++) {
                    map[y][x] = line.charAt(x);
                    if (map[y][x] == '@') {
                        Y = y;
                        X = x;
                    }
                }
            }
            spread(map, spread);
            int ans = bfs(X, Y, map, spread);
            if (ans == -1) {
                System.out.println("IMPOSSIBLE");
            } else {
                System.out.println(ans);
            }
        }
        br.close();
    }
}
