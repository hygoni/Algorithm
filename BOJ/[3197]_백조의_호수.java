import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    public static void spread(char map[][], int time[][]) {
        boolean visited[][] = new boolean[N][M];
        Queue<Integer> qx = new LinkedList<>();
        Queue<Integer> qy = new LinkedList<>();

        for(int y = 0; y < N; y++) {
            for(int x = 0; x < M; x++) {
                if (map[y][x] == '.' || map[y][x] == 'L') {
                    visited[y][x] = true;
                    qx.add(x);
                    qy.add(y);
                }

            }
        }
        int dx[] = {-1, 1, 0, 0};
        int dy[] = {0, 0, -1, 1};
        while (!qy.isEmpty() && !qx.isEmpty()) {
            int ux = qx.poll();
            int uy = qy.poll();
            for(int i = 0; i < 4; i++) {
                int X = ux + dx[i];
                int Y = uy + dy[i];
                if (0 <= X && X < M && 0 <= Y && Y < N && (map[Y][X] != 'L') && !visited[Y][X]) {
                    visited[Y][X] = true;
                    qx.add(X);
                    qy.add(Y);
                    time[Y][X] = time[uy][ux] + 1;
                }
            }
        }
    }

    public static int bfs(char map[][], int time[][]) {
        int dx[] = {-1, 1, 0, 0};
        int dy[] = {0, 0, -1, 1};
        int ans = 0;
        int day = 1;
        int sx = -1, sy = -1;
        int ex = -1, ey = -1;
        Queue<Integer> qx = new LinkedList<>();
        Queue<Integer> qy = new LinkedList<>();
        Queue<Integer> nqx = new LinkedList<>();
        Queue<Integer> nqy = new LinkedList<>();
        boolean visited[][] = new boolean[N][M];
        for(int y = 0; y < N; y++) {
            for(int x = 0; x < M; x++) {
                if (map[y][x] == 'L') {
                    if (sx == -1 && sy == -1) {
                        sx = x;
                        sy = y;
                        nqx.add(x);
                        nqy.add(y);
                        visited[y][x] = true;
                    } else {
                        ex = x;
                        ey = y;
                    }
                }

            }
        }
        while (true) {
            qx = nqx;
            qy = nqy;
            nqx = new LinkedList<>();
            nqy = new LinkedList<>();
            while (!qy.isEmpty() && !qx.isEmpty()) {
                int ux = qx.poll();
                int uy = qy.poll();
                if (ux == ex && uy == ey) {
                    return day;
                }
                for(int i = 0; i < 4; i++) {
                    int X = ux + dx[i];
                    int Y = uy + dy[i];
                    if (0 <= X && X < M && 0 <= Y && Y < N) {
                        if ((map[Y][X] == 'L' || map[Y][X] == '.' || (map[Y][X] == 'X' && time[Y][X] <= day)) && !visited[Y][X]) {
                            visited[Y][X] = true;
                            qx.add(X);
                            qy.add(Y);
                        } else if (map[Y][X] == 'X' && time[Y][X] > day && !visited[Y][X]) {
                            visited[Y][X] = true;
                            nqx.add(X);
                            nqy.add(Y);
                        }
                    }
                }
            }
            day++;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        char map[][] = new char[N][M];
        for(int y = 0; y < N; y++) {
            String line = br.readLine();
            for(int x = 0; x < M; x++) {
                map[y][x] = line.charAt(x);
            }
        }
        int time[][] = new int[N][M];
        spread(map, time);
        System.out.println(bfs(map, time));
        br.close();
    }
}
