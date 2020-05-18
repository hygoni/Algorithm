import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        OUTER:
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            LinkedList<String> list = new LinkedList<>();
            while (N-- > 0) {
                list.add(br.readLine());
            }
            Collections.sort(list);
            while (list.size() > 1) {
                String pivot = list.remove();
                String cmp = list.peek();
                if (cmp.startsWith(pivot)) {
                    System.out.println("NO");
                    continue OUTER;
                } else {
                    continue;
                }
            }
            System.out.println("YES");
        }
        br.close();

    }
}
