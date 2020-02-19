import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int ans = 0, n, seq[], target;
    public static void solve(int index, int sum) {
        if(index == n) {
            if (sum == target) {
                ans++;
            }
        }
        else {
            solve(index + 1, sum + seq[index]);
            solve(index + 1, sum);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        target = Integer.parseInt(st.nextToken());
        seq = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }
        solve(0, 0);
        System.out.println(target == 0 ? ans - 1 : ans);
        br.close();
    }
}
