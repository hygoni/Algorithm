import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Status {
    int fullness;
    int drinked;
    public Status(int fullness, int drinked) {
        this.fullness = fullness;
        this.drinked = drinked;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        Status A = new Status(Integer.parseInt(st.nextToken()), 0);
        Status B = new Status(Integer.parseInt(st.nextToken()), 0);
        br.close();
        int ans = 0;
        Queue<Status> q = new LinkedList<>();
        boolean visited[][] = new boolean[T + 1][2];
        visited[A.fullness][A.drinked] = true;
        visited[B.fullness][B.drinked] = true;
        q.add(A);
        q.add(B);

        while (!q.isEmpty()) {
            Status u = q.poll();
            ans = Math.max(ans, u.fullness);
            if (u.fullness + A.fullness <= T && !visited[u.fullness + A.fullness][u.drinked]) {
                q.add(new Status(u.fullness + A.fullness, u.drinked));
                visited[u.fullness + A.fullness][u.drinked] = true;
            }
            if (u.fullness + B.fullness <= T && !visited[u.fullness + B.fullness][u.drinked]) {
                q.add(new Status(u.fullness + B.fullness, u.drinked));
                visited[u.fullness + B.fullness][u.drinked] = true;
            }
            if (u.drinked == 0) {
                if (!visited[u.fullness / 2][u.drinked + 1]) {
                    q.add(new Status(u.fullness / 2, u.drinked + 1));
                    visited[u.fullness / 2][u.drinked + 1] = true;
                }
            }

        }
        System.out.println(ans);
    }
}
