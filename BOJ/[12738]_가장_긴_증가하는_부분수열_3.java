import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int lower_bound(int high, int target, int arr[]) {
        int low = 0;
        int ans = 0;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] >= target) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int arr[] = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        br.close();

        int seq[] = new int[N];
        int size = 1;

        seq[0] = arr[0];
        for(int i = 1; i < N; i++) {
            if (arr[i] > seq[size - 1]) {
                seq[size] = arr[i];
                size++;
            } else {
                seq[lower_bound(size - 1, arr[i], seq)] = arr[i];
            }
        }
        System.out.println(size);
    }
}
