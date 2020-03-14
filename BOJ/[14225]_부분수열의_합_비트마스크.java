import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static boolean possible[] = new boolean[20 * 100_000 + 10];
    public static int bitSum(int arr[], int bits) {
        int sum = 0;
        for(int i = 0; i < arr.length; i++) {
            if ((bits & 1) != 0)
                sum += arr[i];
            bits /= 2;
        }
        return sum;
    }

    public static void solve(int arr[]) {
        for(int bits = 0; bits < (1 << arr.length); bits++) {
            int sum = bitSum(arr, bits);
            possible[sum] = true;
        }
        for(int i = 0; i < possible.length; i++) {
            if (!possible[i]) {
                System.out.println(i);
                break;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int arr[] = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
       solve(arr);
    }
}