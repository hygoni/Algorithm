import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        long d[] = new long[1_000_000 + 1];
        long sum[] = new long[1_000_000 + 1];

        for(int i = 2; i <= 1_000_000; i++) {
            if (i % 2 == 0) {
                d[i] = d[i / 2] + 1;
            }
            else {
                d[i] = d[(i + 1) / 2] + 2;
            }
            sum[i] = sum[i - 1] + d[i];
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N1 = Integer.parseInt(st.nextToken());
            int N2 = Integer.parseInt(st.nextToken());
            sb.append(String.format("Case #%d", i + 1)).append("\n");
            sb.append(sum[N2] - sum[N1 - 1]).append("\n");
        }
        System.out.print(sb);
        br.close();
    }
}
