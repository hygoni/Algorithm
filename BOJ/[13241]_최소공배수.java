import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static long gcd(long a, long b){
        if(a < b){
            long tmp = b;
            b = a;
            a = tmp;
        }
        while(b != 0){
            long r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

    public static long lcm(long a, long b){
        return a * b / gcd(a, b);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

         long a = Integer.parseInt(st.nextToken());
         long b = Integer.parseInt(st.nextToken());

        System.out.println(lcm(a, b));
        br.close();
    }
}
