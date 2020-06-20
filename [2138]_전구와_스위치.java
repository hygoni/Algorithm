import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void press(char bulb[], int x) {
        for(int i = 0; i < 3; i++) {
            int X = x + i;
            if (0 <= X && X < bulb.length) {
                bulb[X] = (bulb[X] == '0') ? '1' : '0';
            }
        }
    }

    public static boolean equals(char A[], char B[]) {
        for(int i = 0; i < A.length; i++) {
            if (A[i] != B[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char A[] = new char[N];
        char A_[] = new char[N];
        char B[] = new char[N];

        String line = br.readLine();
        for(int i = 0; i < N; i++) {
            A[i] = line.charAt(i);
            A_[i] = A[i];
        }

        line = br.readLine();
        for(int i = 0; i < N; i++) {
            B[i] = line.charAt(i);
        }

        //안 눌렀을 때
        int ans1 = 0;
        for(int i = 1; i < N; i++) {
            if(A[i - 1] != B[i - 1]) {
                press(A, i - 1);
                ans1++;
            }
        }
        if (!equals(A, B)) {
            ans1 = Integer.MAX_VALUE;
        }

        A_[0] = (A_[0] == '0') ? '1' : '0';
        A_[1] = (A_[1] == '0') ? '1' : '0';
        int ans2 = 1;
        for(int i = 1; i < N; i++) {
            if(A_[i - 1] != B[i - 1]) {
                press(A_, i - 1);
                ans2++;
            }
        }
        if (!equals(A_, B)) {
            ans2 = Integer.MAX_VALUE;
        }
        int ans = Math.min(ans1, ans2);
        ans = (ans == Integer.MAX_VALUE) ? -1 : ans;
        System.out.println(ans);
        br.close();
    }
}
