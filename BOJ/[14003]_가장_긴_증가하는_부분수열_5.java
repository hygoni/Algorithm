import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

class Pair {
    int x, y;
    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

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
        int seq[] = new int[N];
        Pair pairs[] = new Pair[N];
        LinkedList<Integer> stack = new LinkedList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int size = 1;
        seq[0] = arr[0];
        pairs[0] = new Pair(0, arr[0]);
        for(int i = 1; i < N; i++) {
            if (arr[i] > seq[size - 1]) {
                seq[size] = arr[i];
                pairs[i] = new Pair(size, arr[i]);
                size++;
            } else {
                int lower_bound = lower_bound(size - 1, arr[i], seq);
                seq[lower_bound] = arr[i];
                pairs[i] = new Pair(lower_bound, arr[i]);
            }
        }

        int num = size - 1;
        for(int i = N - 1; i >= 0; i--) {
            if (pairs[i].x == num) {
                stack.push(pairs[i].y);
                num--;
            }
        }

        System.out.println(size);
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }
        System.out.println(sb);
    }
}
