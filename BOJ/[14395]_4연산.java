import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Dot {
    long num, dist;
    public Dot(long num, long dist) {
        this.num = num;
        this.dist = dist;
    }
}

public class Main {
    public static long calc(char op, long num) {
        switch (op) {
            case '+':
                return num + num;
            case '-':
                return num - num;
            case '*':
                return num * num;
            case '/':
                return num / num;
            default:
                return 1;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Integer.parseInt(st.nextToken());
        long B = Integer.parseInt(st.nextToken());
        br.close();
        if (A == B) {
            System.out.println(0);
            return;
        }

        Queue<Dot> q = new LinkedList<>();
        Map<Long, Character> how = new HashMap<>();
        Map<Long, Long> prev = new HashMap<>();
        Map<Long, Boolean> visited = new HashMap<>();
        q.add(new Dot(A, 0));
        visited.put(A, true);

        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            Dot u = q.poll();
            if (u.num == B) {
                LinkedList<Character> stack = new LinkedList<>();
                long num = u.num;
                while (num != A) {
                    stack.push(how.get(num));
                    num = prev.get(num);
                }
                while (!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
                System.out.println(sb);
                return;
            }
            char chars[] = {'*', '+', '-', '/'};
            for(int i = 0; i < chars.length; i++) {
                if (chars[i] == '/' && u.num == 0) {
                    continue;
                } else {
                    long v = calc(chars[i], u.num);
                    if (!visited.getOrDefault(v, false)) {
                        q.add(new Dot(v, u.dist + 1));
                        visited.put(v, true);
                        prev.put(v, u.num);
                        how.put(v, chars[i]);
                    }
                }
            }
        }
        System.out.println(-1);
    }
}
