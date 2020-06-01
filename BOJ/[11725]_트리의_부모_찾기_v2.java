import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Pair {
    int x, y;
    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int V = Integer.parseInt(br.readLine());

        Map<Integer, Set<Integer>> graph = new HashMap<>();
        int tree[] = new int[V + 1];

        for(int i = 1; i <= V; i++) {
            graph.put(i, new HashSet<>());
        }

        for(int i = 0; i < V - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            graph.get(s).add(e);
            graph.get(e).add(s);
        }
        br.close();

        Queue<Integer> q = new LinkedList<>();
        tree[1] = 1;
        q.add(1);
        while (!q.isEmpty()) {
            int u = q.poll();
            Iterator<Integer> iter = graph.get(u).iterator();
            while (iter.hasNext()) {
                int v = iter.next();
                if (tree[u] != v) {
                    tree[v] = u;
                    q.add(v);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 2; i <= V; i++) {
            sb.append(tree[i]).append("\n");
        }
        System.out.print(sb);
    }
}
