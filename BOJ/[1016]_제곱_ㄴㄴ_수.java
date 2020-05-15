import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long min = Long.parseLong(st.nextToken());
        long max = Long.parseLong(st.nextToken());

        boolean isPrime[] = new boolean[1_000_000 + 1];
        for(int i = 1; i < isPrime.length; i++) {
            isPrime[i] = true;
        }
        isPrime[1] = false;
        for(long i = 2; i <= 1_000_000; i++) {
            for(long j = 2 * i; j <= i; j += i) {
                isPrime[(int)j] = false;
            }
        }
        LinkedList<Long> squareList = new LinkedList<>();
        for(long i = 1; i < isPrime.length; i++) {
            if (isPrime[(int)i])
                squareList.add(i * i);
        }
        br.close();

        Set<Long> set = new HashSet<>();
        Iterator<Long> iter = squareList.iterator();
        while (iter.hasNext()) {
            long square = iter.next();
            for(long i = square * (min / square); i <= max; i += square) {
                if (min <= i)
                    set.add(i);
            }
        }

        long ans = max - min + 1 - set.size();
        System.out.println(ans);
    }
}
