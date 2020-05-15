import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Dot {
    int x, y, time;
    public Dot(int x, int y, int time) {
        this.x = x;
        this.y = y;
        this.time = time;
    }
}

public class Main {
    static char map[][];
    static int time[][];
    static boolean visited[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        visited = new boolean[N][M];
        time = new int[N][M];
        Queue<Dot> q = new LinkedList<>();
        Dot start = new Dot(0, 0, 0);
        Dot end = new Dot(0, 0, 0);
        for(int y = 0; y < N; y++) {
            String line = br.readLine();
            for(int x = 0; x < M; x++) {
                map[y][x] = line.charAt(x);
                if (map[y][x] == 'S') {
                    start.x = x;
                    start.y = y;
                    map[y][x] = '.';
                } else if (map[y][x] == 'D') {
                    end.x = x;
                    end.y = y;
                } else if (map[y][x] == '*') {
                    q.add(new Dot(x, y, 0));
                }
            }
        }
        br.close();
        
        int dx[] = {1, -1, 0,  0};
        int dy[] = {0, 0, 1, -1};
        //물이 없는 경우를 생각해 시간을 INF로 초기화
        for(int y = 0; y < N; y++) {
            for(int x = 0; x < M; x++) {
                time[y][x] = Integer.MAX_VALUE;
            }
        }
        //물 퍼지는 시간 파악
        while (!q.isEmpty()) {
            Dot u = q.poll();
            for(int i = 0; i < dx.length; i++) {
                int X = u.x + dx[i];
                int Y = u.y + dy[i];
                if (0 <= X && X < M && 0 <= Y && Y < N) {
                    if (map[Y][X] == '.' && !visited[Y][X]) {
                        time[Y][X] = u.time + 1;
                        q.add(new Dot(X, Y, u.time + 1));
                        visited[Y][X] = true;
                    }
                }
            }
        }

        dx = new int[]{1, -1, 0, 0, 0};
        dy = new int[]{0, 0, 1, -1, 0};
        visited = new boolean[N][M];
        q.add(start);
        visited[start.y][start.x] = true;
        while (!q.isEmpty()) {
            Dot u = q.poll();
            if (u.x == end.x && u.y == end.y) {
                System.out.println(u.time);
                return;
            }
            for(int i = 0; i < dx.length; i++) {
                int X = u.x + dx[i];
                int Y = u.y + dy[i];
                if (0 <= X && X < M && 0 <= Y && Y < N) {
                    if (((map[Y][X] == '.' && u.time + 1 < time[Y][X]) || map[Y][X] == 'D') && !visited[Y][X]) {
                        q.add(new Dot(X, Y, u.time + 1));
                        visited[Y][X] = true;
                    }
                }
            }
        }
        System.out.println("KAKTUS");
    }
}
