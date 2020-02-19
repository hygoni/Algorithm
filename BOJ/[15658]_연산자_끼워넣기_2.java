import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, num[];
    static int min = Integer.MAX_VALUE;
    static int max = -Integer.MAX_VALUE;
    public static void solve(int index, int val, int plus, int minus, int mul, int div) {
        if (index == n) {
            min = Math.min(min, val);
            max = Math.max(max, val);
            return;
        } else {
            if (plus > 0) {
                solve(index + 1, val + num[index], plus - 1, minus, mul, div);
            }
            if (minus > 0) {
                solve(index + 1, val - num[index], plus, minus - 1, mul, div);
            }
            if (mul > 0) {
                solve(index + 1, val * num[index], plus, minus, mul - 1, div);
            }
            if (div > 0) {
                solve(index + 1, val / num[index], plus, minus, mul, div - 1);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        num = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int plus = Integer.parseInt(st.nextToken());
        int minus = Integer.parseInt(st.nextToken());
        int mul = Integer.parseInt(st.nextToken());
        int div = Integer.parseInt(st.nextToken());
        solve(1, num[0], plus, minus, mul, div);
        System.out.println(max);
        System.out.println(min);
        br.close();
    }
}
