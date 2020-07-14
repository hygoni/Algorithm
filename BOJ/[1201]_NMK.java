import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void reverse(ArrayList<Integer> list, int start, int end) {
        LinkedList<Integer> stack = new LinkedList<>();
        for(int i = start; i <= end; i++) {
            stack.push(list.get(i));
        }
        for(int i = start; i <= end; i++) {
            list.set(i, stack.pop());
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        br.close();
        if (N < M + K - 1 || N > M * K) {
            System.out.println(-1);
        } else {
            ArrayList<Integer> list = new ArrayList<>();
            for(int i = 0; i < N; i++) {
                list.add(i + 1);
            }
            N -= K;
            M -= 1;

            int groupSize = (M == 0) ? 0 : (N / M);
            int rest = (M == 0) ? 0 : (N % M);
            int start = 0;
            int end = K - 1;
            reverse(list, start, end);
            while (M-- > 0) {
                int add = groupSize;
                if (rest > 0) {
                    add++;
                    rest--;
                }
                start = end + 1;
                end += add;
                reverse(list, start, end);
            }
            StringBuilder sb = new StringBuilder();
            int i = 0;
            while (i < list.size()) {
                sb.append(list.get(i));
                if (i != list.size() - 1) {
                    sb.append(" ");
                }
                i++;
            }
            System.out.println(sb);
        }
    }
}
