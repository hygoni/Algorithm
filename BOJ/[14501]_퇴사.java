import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int cost[] = new int[N];
        int value[] = new int[N];
        int d[] = new int[N + 1];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            cost[i] = t;
            value[i] = m;
        }
        br.close();

        for(int i = 0; i < N; i++) {
            int left = N - i;
            if (left >= cost[i]) {
                for(int k = 0; left + k <= N; k++)
                    d[left - cost[i]] = Math.max(d[left + k] + value[i], d[left - cost[i]]);
            }
        }

        int ans = 0;
        for(int i = 0; i <= N; i++) {
            ans = Math.max(d[i], ans);
        }
        System.out.println(ans);
    }
}
