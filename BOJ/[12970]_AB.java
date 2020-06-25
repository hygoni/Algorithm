import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        br.close();

        int ans[] = new int[1];
        int used = 0;
        boolean isPossible = false;
        for(int a = 0; a <= N; a++) {
            int b = N - a;
            if (a * b < K) {
                continue;
            } else {
                isPossible = true;
                ans = new int[b + 1];
                int total = 0;
                while (a > 0) {
                    int add = Math.min(K - total, Math.min(K, b));
                    total += add;
                    ans[add]++;
                    a--;
                }
                break;
            }
        }
        if (isPossible) {
            StringBuilder sb = new StringBuilder();
            for(int i = ans.length - 1; i >= 0; i--) {
                for(int j = 0; j < ans[i]; j++) {
                    sb.append('A');
                }
                if (i != 0) {
                    sb.append('B');
                }
            }
            System.out.println(sb);
        } else {
            System.out.println(-1);
        }
    }
}
