import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

class Tower {
    int idx, h;
    public Tower(int idx, int h) {
        this.idx = idx;
        this.h = h;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        LinkedList<Tower> stack = new LinkedList<>();
        br.close();
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < N; i++) {
            int h = Integer.parseInt(st.nextToken());
            while (!stack.isEmpty() && stack.peek().h < h) {
                stack.pop();
            }
            String append = (stack.isEmpty()) ? "0" : (stack.peek().idx + 1) + "";
            stack.push(new Tower(i, h));
            sb.append(append);
            if (i != N - 1)
                sb.append(" ");
        }
        System.out.println(sb);
    }
}
