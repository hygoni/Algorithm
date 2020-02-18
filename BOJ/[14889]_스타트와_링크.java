import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static final int START = 1;
    static final int LINK = 2;
    public static boolean next_permutation(int arr[]) {
        int len = arr.length;
        int i, j;
        int tmp;

        i = len - 1;
        while (i - 1 >= 0 && arr[i - 1] >= arr[i])
            i--;
        if (i <= 0)
            return false;
        j = len - 1;
        while (arr[i - 1] >= arr[j])
            j--;

        tmp = arr[i - 1];
        arr[i - 1] = arr[j];
        arr[j] = tmp;
        j = len - 1;
        while (i < j) {
            tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
            i++;
            j--;
        }
        return true;
    }

    public static int calc(int perm[], int score[][]) {
        int start = 0, link = 0;
        for(int i = 0; i < perm.length; i++) {
            if (perm[i] == START) {
                for(int j = 0; j < perm.length; j++) {
                    if(perm[j] == START) {
                        start += score[i][j];
                    }
                }
            } else {
                for(int j = 0; j < perm.length; j++) {
                    if(perm[j] == LINK) {
                        link += score[i][j];
                    }
                }
            }
        }
        return Math.abs(start - link);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int score[][] = new int[N][N];
        int perm[] = new int[N];
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                score[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        br.close();

        for(int i = 0; i < N; i++) {
            perm[i] = (i < N / 2) ? START : LINK;
        }
        int ans = Integer.MAX_VALUE;
        do {
            ans = Math.min(ans, calc(perm, score));
        } while (next_permutation(perm));
        System.out.println(ans);
    }
}
