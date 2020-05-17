import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Dot {
    int num, dist;
    public Dot(int num, int dist) {
        this.num = num;
        this.dist = dist;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean isPrime[] = new boolean[9999 + 1];
        for(int i = 1; i < isPrime.length; i++) {
            isPrime[i] = true;
        }
        isPrime[1] = false;
        for(int i = 2; i <= 9999; i++) {
            for(int j = 2 * i; j <= 9999; j += i) {
                isPrime[j] = false;
            }
        }

        int T = Integer.parseInt(br.readLine());
        OUTER:
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            Queue<Dot> q = new LinkedList<>();
            q.add(new Dot(A, 0));
            boolean visited[] = new boolean[9999 + 1];
            while (!q.isEmpty()) {
                Dot u = q.poll();
                if (u.num == B) {
                    System.out.println(u.dist);
                    continue OUTER;
                }
                int mul = 10;
                //자릿수 : 1, 10, 100, 1000
                for(int i = 1; i <= 4; i++) {
                    //자릿수 아래 부분을 다 잘라버림 1234 -> 4 or 1230 -> 1200
                    int num = u.num -  (u.num % mul);
                    //잘린 부분을 일부 복구
                    if (i != 1)
                        num += (u.num % (mul / 10)); //1200 -> 1204
                    //나머지 비어있는 부분 (예를들어 1234 -> 1204라면 10의 자리를 0~9까지 시도)
                    for(int j = 0; j < 10; j++) {
                        int bak = num;
                        num  = (num + (j * mul / 10)) % 10000;
                        if (isPrime[num] && !visited[num] && num >= 1000) {
                            q.add(new Dot(num, u.dist + 1));
                            visited[num] = true;
                        }
                        num = bak;
                    }
                    mul *= 10;
                }
            }
            System.out.println("Impossible");
        }

    }
}
