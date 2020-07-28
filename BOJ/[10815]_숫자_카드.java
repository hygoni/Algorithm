import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;



public class NumberCard {
    public static boolean find(Integer arr[], int target) {
        int lower_bound = 0;
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] >= target) {
                right = mid - 1;
                lower_bound = arr[mid];
            }
            else {
                left = mid + 1;
            }
        }
        return (lower_bound == target);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Integer arr[] = new Integer[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int Q = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < Q; i++) {
            int target = Integer.parseInt(st.nextToken());
            if (find(arr, target)) {
                sb.append("1 ");
            } else {
                sb.append("0 ");
            }
        }
        br.close();
        System.out.println(sb);

    }
}
