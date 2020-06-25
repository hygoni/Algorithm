import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        br.close();
        LinkedList<Integer> q = new LinkedList<>();
        int num = 0;
        int sign = 1;
        for(int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            if (c == '+' || c == '-') {
                if (i != 0) {
                    q.add(num * sign);
                    num = 0;
                }
                sign = (c == '-') ? -1 : 1;
            } else {
                num = num * 10 + (c - '0');
            }
        }
        q.add(num * sign);

        int ans = 0;
        while (!q.isEmpty()) {
            num = q.poll();
            if (num < 0) {
                while (!q.isEmpty() && q.peek() > 0) {
                    num -= q.poll();
                }
            }
            ans += num;
        }
        System.out.println(ans);
    }
}
