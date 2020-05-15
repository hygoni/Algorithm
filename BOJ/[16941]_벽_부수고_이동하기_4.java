import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Vertex {
    int x, y;
    public Vertex(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static boolean visited[][];
    static int color[][]; //그룹별 color
    static int count[];  //group별 노드 수
    static char map[][];
    static int N, M;
    public static void bfs(Vertex start, int col) {
        int dx[] = {1, -1, 0, 0};
        int dy[] = {0, 0, 1, -1};

        color[start.y][start.x] = col;
        count[col]++;
        Queue<Vertex> q = new LinkedList<>();
        visited[start.y][start.x] = true;
        q.add(start);
        while (!q.isEmpty()) {
            Vertex u = q.poll();
            for(int i = 0; i < dx.length; i++) {
                int X = dx[i] + u.x;
                int Y = dy[i] + u.y;
                if (0 <= X && X < M && 0 <= Y && Y < N) {
                    if (map[Y][X] == '0' && !visited[Y][X]) {
                        visited[Y][X] = true;
                        q.add(new Vertex(X, Y));
                        color[Y][X] = col;
                        count[col]++;
                    }
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        color = new int[N][M];
        count = new int[N * M + 1];

        map = new char[N][M];
        for(int y = 0; y < N; y++) {
            String line = br.readLine();
            for(int x = 0; x < M; x++) {
                map[y][x] = line.charAt(x);
            }
        }
        br.close();

        visited = new boolean[N][M];
        int col = 1;
        for(int y = 0; y < N; y++) {
            for(int x = 0; x < M; x++) {
                if (map[y][x] == '0' && !visited[y][x]) {
                    bfs(new Vertex(x, y), col);
                    col++;
                }
            }
        }
        int dx[] = {1, -1, 0, 0};
        int dy[] = {0, 0, 1, -1};
        StringBuilder sb = new StringBuilder();
        for(int y = 0; y < N; y++) {
            for(int x = 0; x < M; x++) {
                if (map[y][x] == '0') {
                    sb.append('0');
                    continue;
                }
                Set<Integer> set = new HashSet<>();
                for(int i = 0; i < dx.length; i++) {
                    int X = x + dx[i];
                    int Y = y + dy[i];
                    if (0 <= X && X < M && 0 <= Y && Y < N) {
                        if (map[Y][X] == '0') {
                            set.add(color[Y][X]);
                        }
                    }
                }
                int ans = 1;
                Iterator<Integer> iter = set.iterator();
                while (iter.hasNext()) {
                    ans += count[iter.next()];
                }
                sb.append((char)(ans % 10 + '0'));
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }
}
