import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int F = Integer.parseInt(st.nextToken()); //highest floor
        int S = Integer.parseInt(st.nextToken()); //start
        int G = Integer.parseInt(st.nextToken()); //goal
        int U = Integer.parseInt(st.nextToken()); //upward
        int D = Integer.parseInt(st.nextToken()); //downward
        br.close();

        Queue<Integer> q = new LinkedList<>();
        q.add(S);
        boolean visited[] = new boolean[F + 1];
        int count[] = new int[F + 1];
        while (!q.isEmpty()) {
            int u = q.poll();
            int upward = u + U;
            int downward = u - D;
            if (u == G) {
                break;
            }
            if (u != upward && upward <= F && !visited[upward]) {
                q.add(upward);
                count[upward] = count[u] + 1;
                visited[upward] = true;
            }
            if (u != downward && downward >= 1 && !visited[downward]) {
                q.add(downward);
                count[downward] = count[u] + 1;
                visited[downward] = true;
            }
        }
        if (count[G] == 0) {
            if (S == G) {
                System.out.println(0);
            } else {
                System.out.println("use the stairs");
            }
        } else {
            System.out.println(count[G]);
        }
    }
}
