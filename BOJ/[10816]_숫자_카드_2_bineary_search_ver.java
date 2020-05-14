import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static int bsearch(int arr[], int target) {
        int low = 0;
        int high = arr.length - 1;
        boolean found = false;
        
        int minIdx = 0, maxIdx = 0;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] >= target) {
                minIdx = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        low = 0;
        high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] <= target) {
                maxIdx = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        if (arr[maxIdx] != target && arr[minIdx] != target) {
            return 0;
        }
        return maxIdx - minIdx + 1;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int arr[] = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        int Q = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (Q-- > 0) {
            int target = Integer.parseInt(st.nextToken());
            sb.append(bsearch(arr, target));
            if (Q != 0)
                sb.append(" ");
        }
        br.close();
        System.out.println(sb);
    }
}
