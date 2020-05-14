import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static int calc(char op, int num) {
        switch (op) {
            case 'D':
                return (num * 2 > 9999) ? num * 2 % 10000 : num * 2;
            case 'S':
                return (num == 0) ? 9999 : num - 1;
            case 'L':
                return (num % 1000) * 10 + (num / 1000);
            case 'R':
                return (num % 10) * 1000 + (num / 10);
            default:
                return -1;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        char DSLR[] = {'D', 'S', 'L', 'R'};
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            boolean visited[] = new boolean[10000 + 1];
            int prev[] = new int[10000 + 1];
            char cmd[] = new char[10000 + 1];
            visited[A] = true;
            Queue<Integer> q = new LinkedList<>();
            q.add(A);
            while (!q.isEmpty()) {
                int u = q.poll();
                if (u == B) {
                    LinkedList<Character> stack = new LinkedList<>();
                    while (u != A) {
                        stack.push(cmd[u]);
                        u = prev[u];
                    }
                    StringBuilder sb = new StringBuilder();
                    while (!stack.isEmpty()) {
                        sb.append(stack.pop());
                    }
                    System.out.println(sb);
                    break;
                }
                for(int i = 0; i < DSLR.length; i++) {
                    int v = calc(DSLR[i], u);
                    if (!visited[v]) {
                        cmd[v] = DSLR[i];
                        visited[v] = true;
                        prev[v] = u;
                        q.add(v);
                    }
                }
            }
        }
        br.close();
    }
}
