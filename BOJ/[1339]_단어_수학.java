import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static boolean contains(int arr[], int toFind) {
        for(int i = 0; i < arr.length; i++) {
            if (arr[i] == toFind)
                return true;
        }
        return false;
    }

    public static boolean prev_permutation(int arr[]) {
        int len = arr.length;
        int i, j, tmp;

        i = len - 1;
        while (i - 1 >= 0 && arr[i - 1] < arr[i])
            i--;
        if (i <= 0)
            return false;
        j = len - 1;
        while (arr[i - 1] <= arr[j])
            j--;

        tmp = arr[i - 1];
        arr[i - 1] = arr[j];
        arr[j] = tmp;
        j = len - 1;
        while (i < j)
        {
            tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
            i++;
            j--;
        }
        return true;
    }

   public static int calc(int[] perm, int[] index, LinkedList<String> list) {
        int ans = 0;
        Iterator<String> iter = list.iterator();
        while (iter.hasNext()) {
            int num = 0;
            String line = iter.next();
            for(int i = 0; i < line.length(); i++) {
                num = num * 10 + perm[index[line.charAt(i) - 'A']];
            }
            ans += num;
        }
        return ans;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        LinkedList<String> list = new LinkedList<>();
        int N = Integer.parseInt(br.readLine());
        int num[] = new int['Z' - 'A' + 1];
        int index[] = new int['Z' - 'A' + 1];
        Arrays.fill(num, -1);
        Arrays.fill(index, -1);
        int len = 0;

        for(int i = 0; i < N; i++) {
            String line = br.readLine();
            for(int j = 0; j < line.length(); j++) {
                int idx = line.charAt(j) - 'A';
                if (!contains(num, idx)) {
                    num[len] = idx;
                    index[idx] = len;
                    len++;
                }
            }
            list.add(line);
        }

        int perm[] = new int[len];
        for(int i = 0; i < len; i++) {
            perm[i] = 9 - i;
        }

        int ans = 0;
        do {
            ans = Math.max(ans, calc(perm, index, list));
        } while (prev_permutation(perm));
        System.out.println(ans);
        br.close();
    }
}
