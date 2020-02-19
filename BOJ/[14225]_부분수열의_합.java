import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, seq[];
    static boolean possible[] = new boolean[100000 * 20 + 1];
    public static void solve(int index, int sum) {
        if (index == n) {
                possible[sum] = true;
        } else {
            solve(index + 1, sum + seq[index]);
            solve(index + 1, sum);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        seq = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }
        solve(0, 0);
        for(int i = 0; i < possible.length; i++) {
            if (possible[i] == false) {
                System.out.println(i);
                break;
            }
        }
        br.close();
    }
}
