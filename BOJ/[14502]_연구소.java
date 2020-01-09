import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class DirectedGraph<T> {
    private Map<T, Map<T, Integer>> graph;
    private Map<T, T> prev;
    public DirectedGraph() {
        this.graph = new HashMap<>();
    }

    /* basic functions of graph */

    public void addVertex(T v) {
        graph.put(v, new HashMap<>());
    }

    public void addEdge(T from, T to, int weight) {
        graph.get(from).put(to, weight);
    }

    public void addFlow(T from, T to, int amount) {
        int flow = graph.get(from).get(to);
        graph.get(from).put(to, flow + amount);
    }

    public int getWeight(T u, T v) {
        return graph.get(u).get(v);
    }

    public Iterator<T> getVertexIterator(){
        return graph.keySet().iterator();
    }

    public Iterator<T> getNeighborsIterator(T v){
        return graph.get(v).keySet().iterator();
    }

}


public class Main {

    public static DirectedGraph<Integer> makeGraph(int map[], int N, int M) {
        DirectedGraph<Integer> graph = new DirectedGraph<>();

        for(int y = 0;  y < N; y++){
            for(int x = 0; x < M; x++){
                graph.addVertex(y*M+x);
            }
        }

        for(int y = 0; y < N; y++){
            for(int x = 0; x < M; x++){
                int dx[] = {1, 0, 0, -1};
                int dy[] = {0, 1, -1, 0};
                for(int i = 0; i < 4; i++){
                    int X = x + dx[i];
                    int Y = y + dy[i];
                    if(0 <= X && X < M && 0 <= Y && Y < N){
                        if(map[Y*M+X] == 0) {
                            graph.addEdge(y * M + x, Y * M + X, 1);
                        }
                    }
                }
            }
        }

        return graph;
    }

    public static int bfs(DirectedGraph<Integer> graph, LinkedList<Integer> q){
        Map<Integer, Boolean> visited = new HashMap<>();
        Iterator<Integer> iter = q.iterator();
        int ans = 0;
        while(iter.hasNext()){
            visited.put(iter.next(), true);
            ans++;
        }

        while(!q.isEmpty()){
            int u = q.poll();
            iter = graph.getNeighborsIterator(u);
            while(iter.hasNext()){
                int v = iter.next();
                if(visited.get(v) == null){
                    ans++;
                    visited.put(v, true);
                    q.add(v);
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int map[] = new int[N*M];
        int walls = 0;
        LinkedList<Integer> q = new LinkedList<>();

        for(int y = 0; y < N; y++){
            st = new StringTokenizer(br.readLine());
            for(int x = 0; x < M; x++){
                map[y*M+x] = Integer.parseInt(st.nextToken());
                if(map[y*M+x] == 2){
                    q.add(y*M+x);
                } else if(map[y*M+x] == 1){
                    walls++;
                }
            }
        }

        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < N*M; i++){
            if(map[i] != 0) continue;
            for(int j = i; j < N*M; j++){
                if(map[j] != 0) continue;
                for(int k = j; k < N*M; k++){
                    if(map[k] != 0) continue;
                    if(i == j || j == k || i == k){
                        continue;
                    }

                    int copiedMap[] = Arrays.copyOf(map, N*M);
                    LinkedList<Integer> copiedQueue = new LinkedList<>(q);
                    copiedMap[i] = 1;
                    copiedMap[j] = 1;
                    copiedMap[k] = 1;
                    DirectedGraph<Integer> graph = makeGraph(copiedMap, N, M);
                    ans = Math.min(ans, bfs(graph, copiedQueue));
                }
            }
        }

        System.out.println(N * M - ans - walls - 3);
        br.close();
    }
}
