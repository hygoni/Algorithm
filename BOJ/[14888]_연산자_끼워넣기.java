import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static boolean next_permutation(char arr[]) {
        int len = arr.length;
        int i, j;
        char tmp;

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

    public static int calc(int num[], char op[]) {
        int n = num[0];
        for(int i = 1; i < num.length; i++) {
            switch(op[i - 1]) {
                case '+':
                    n += num[i];
                    break;
                case '-':
                    n -= num[i];
                    break;
                case '*':
                    n *= num[i];
                    break;
                case '/':
                    n /= num[i];
                    break;
            }
        }
        return n;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int num[] = new int[N];
        char op[] = new char[N - 1];
        StringTokenizer st = new StringTokenizer(br.readLine());

        int i = 0;
        while(st.hasMoreTokens()) {
            num[i] = Integer.parseInt(st.nextToken());
            i++;
        }

        i = 0;
        st = new StringTokenizer(br.readLine());
        int add = Integer.parseInt(st.nextToken());
        for(int j = 0; j < add; j++) {
            op[i] = '+';
            i++;
        }
        int sub = Integer.parseInt(st.nextToken());
        for(int j = 0; j < sub; j++) {
            op[i] = '-';
            i++;
        }
        int mul = Integer.parseInt(st.nextToken());
        for(int j = 0; j < mul; j++) {
            op[i] = '*';
            i++;
        }
        int div = Integer.parseInt(st.nextToken());
        for(int j = 0; j < div; j++) {
            op[i] = '/';
            i++;
        }
        br.close();
        Arrays.sort(op);
        int min = Integer.MAX_VALUE;
        int max = -Integer.MAX_VALUE;
        do {
            min = Math.min(calc(num, op), min);
            max = Math.max(calc(num, op), max);
        } while (next_permutation(op));
        System.out.println(max);
        System.out.println(min);
    }
}
