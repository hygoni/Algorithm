import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int end[];
    public static int bin(int max, int target) {
        int low = 1, high = max;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (target == end[mid])
                return mid;
            else if (target > end[mid])
                low = mid + 1;
            else
                high = mid - 1;
        }
        return low;
    }
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int arr[] = new int[N + 1];
        int min = Integer.MAX_VALUE;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            min = Math.min(min, arr[i]);
        }
        br.close();
        end = new int[N + 1];
        int ans = 1;
        end[ans] = arr[1];

        for(int i = 1; i <= N; i++) {
            if (end[ans] < arr[i]) {
                ans++;
                end[ans] = arr[i];
            } else {
                end[bin(ans, arr[i])] = arr[i];
            }
        }

        System.out.println(ans);
    }
}
