import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String code = br.readLine();
        br.close();
        int len = code.length();
        int arr[] = new int[len + 1];
        for (int i = 1; i <= code.length(); i++) {
            arr[i] = code.charAt(i - 1) - '0';
        }

        int d[] = new int[len + 1];
        d[0] = 1;

        for(int i = 1; i <= len; i++) {
            if (1 <= arr[i] && arr [i] <= 9) {
                d[i] = ( d[i - 1] + d[i] ) % 1000000;
            }

            if (i != 1) {
                int val = arr[i - 1] * 10 + arr[i];
                if (10 <= val && val <= 26) {
                    d[i] = (d[i - 2] + d[i]) % 1000000;
                }
            }
        }

        System.out.println(d[len]);
    }
}
