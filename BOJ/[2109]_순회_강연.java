import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.TreeMap;

class Class implements Comparable<Class> {
    int day, reward;
    public Class(int day, int reward) {
        this.day = day;
        this.reward = reward;
    }

    @Override
    public int compareTo(Class o) {
        if (this.reward == o.reward) {
            return Integer.compare(this.day, o.day);
        } else {
            return -Integer.compare(this.reward, o.reward);
        }
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Class> pq = new PriorityQueue<>();
        TreeMap<Integer, Integer> bag = new TreeMap<>();

        for(int i = 1; i <= 10_000; i++) {
            bag.put(i, 1);
        }
        while (N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            pq.add(new Class(d, p));
        }
        br.close();

        int ans = 0;
        while (!pq.isEmpty()) {
            Class c = pq.poll();
            Integer find = bag.floorKey(c.day);
            if (find != null) {
                bag.remove(find);
                ans += c.reward;
            }
        }
        System.out.println(ans);
    }
}
