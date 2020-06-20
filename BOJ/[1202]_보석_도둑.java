import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.TreeMap;

class Jewel implements Comparable<Jewel> {
    int weight, value;
    public Jewel(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }

    @Override
    public int compareTo(Jewel o) {
        return -Integer.compare(this.value, o.value);
    }
}

public class Main {
       public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        TreeMap<Integer, Integer> bags = new TreeMap<>();
        Jewel jewels[] = new Jewel[N];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            jewels[i] = new Jewel(weight, value);
        }
        Arrays.sort(jewels);

        for(int i = 0; i < K; i++) {
            int weight = Integer.parseInt(br.readLine());
            bags.put(weight, bags.getOrDefault(weight, 0) + 1);
        }
        br.close();

        long ans = 0;
        for(int i = 0; i < N; i++) {
            Integer bag = bags.ceilingKey(jewels[i].weight);
            if (bag != null) {
                if (bags.get(bag) == 1) {
                    bags.remove(bag);
                } else {
                    bags.put(bag, bags.get(bag) - 1);
                }
                ans += jewels[i].value;
            }
        }
        System.out.println(ans);
    }
}
