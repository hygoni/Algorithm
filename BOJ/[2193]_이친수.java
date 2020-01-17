import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long d[] = new long[N+3];

        d[1] = 1;
        d[2] = 1;

        for(int i = 3; i <= N; i++){
            d[i] = d[i-1] + d[i-2];
        }

        System.out.println(d[N]);
        br.close();
    }
}
