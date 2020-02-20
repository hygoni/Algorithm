import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Location {
    int x, y;
    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class Main {
    static int n, m;
    static char map[][];
    static int ans = -1;
    public static Location move(Location loc, int x, int y) {
        if (loc.x + x >= 0 && loc.x + x < m && loc.y + y >= 0 && loc.y + y < n) {
            if (map[loc.y + y][loc.x + x] == '#') {
                return new Location(loc.x, loc.y);
            }
        }
        if (x == 1) {
            if (loc.x == m - 1) {
                return null;
            } else {
                return new Location(loc.x + x, loc.y);
            }
        } else if (x == -1) {
            if (loc.x == 0) {
                return null;
            } else {
                return new Location(loc.x + x, loc.y);
            }
        } else if (y == 1) {
            if (loc.y == n - 1) {
                return null;
            } else {
                return new Location(loc.x, loc.y + y);
            }
        } else if (y == -1) {
            if (loc.y == 0) {
                return null;
            } else {
                return new Location(loc.x, loc.y + y);
            }
        }
        return null;
    }
    public static void solve(Location one, Location two, int depth) {
        if (depth == 10 + 1) {
            return;
        } else {
            if (one == null || two == null) {
                if(!(one == null && two == null)) {
                    ans = (ans == -1) ? depth : Math.min(ans, depth);
                }
                return;
            }
            solve(move(one, -1, 0), move(two, -1, 0),depth + 1);
            solve(move(one, +1, 0), move(two, +1, 0),depth + 1);
            solve(move(one, 0, -1), move(two, 0, -1),depth + 1);
            solve(move(one, 0, +1), move(two, 0, +1),depth + 1);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[n][m];
        Location one = null, two = null;
        for(int y = 0;  y < n; y++) {
            String line = br.readLine();
            for(int x = 0; x < m; x++) {
                if (line.charAt(x) == 'o') {
                    if (one == null) {
                        one = new Location(x, y);
                    } else {
                        two = new Location(x, y);
                    }
                } else {
                    map[y][x] = line.charAt(x);
                }
            }
        }
        solve(one, two, 0);
        System.out.println(ans);
        br.close();
    }
}
