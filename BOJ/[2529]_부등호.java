import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static boolean next_permutation(int arr[]) {
        int len = arr.length;
        int i, j;
        int tmp;

        i = len - 1;
        while (i - 1 >= 0 && arr[i - 1] > arr[i])
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

    public static void print(int arr[]) {
        for(int i = 0; i < arr.length; i++)
        {
            System.out.print(arr[i]);
        }
        System.out.println();
    }

    public static boolean check(int arr[], char inequality[]){
        for(int i = 0; i < inequality.length; i++) {
            if (inequality[i] == '<' && arr[i] > arr[i + 1]) {
                return false;
            } else if (inequality[i] == '>' && arr[i] < arr[i + 1]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char inequality[] = new char[N];
        int min[] = new int[N + 1];
        int max[] = new int[N + 1];

        for(int i = 0; i < N + 1; i++){
            min[i] = i;
            max[i] = 9 - i;
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            inequality[i] = st.nextToken().charAt(0);
        }
        do {
            if (check(min, inequality))
                break;
        } while (next_permutation(min));

        do {
            if (check(max, inequality))
                break;
        } while (prev_permutation(max));

        print(max);
        print(min);
        br.close();
    }
}
