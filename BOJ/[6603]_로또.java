import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void print(int set[], boolean visited[], int index, int count) {
        if(count == 6) {
            for(int i = 0; i < visited.length; i++) {
                if (visited[i]) {
                    System.out.print(set[i] + " ");
                }
            }
            System.out.println();
        } else {
            for(int i = index; i < visited.length; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    print(set, visited, i, count + 1);
                    visited[i] = false;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        while (k != 0) {
            int set[] = new int[k];
            boolean visited[] = new boolean[k];
            for(int i = 0; i < k; i++) {
                set[i] = Integer.parseInt(st.nextToken());
            }
            print(set, visited, 0, 0);
            st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());
            if (k != 0)
                System.out.println();
        }
        br.close();
    }
}
