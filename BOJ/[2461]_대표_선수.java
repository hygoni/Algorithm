import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Player implements Comparable<Player> {
    int team;
    int score;
    public Player (int team, int score) {
        this.team = team;
        this.score = score;
    }

    @Override
    public int compareTo(Player o) {
        return Integer.compare(this.score, o.score);
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Player represent[] = new Player[N];

        LinkedList<LinkedList<Player>> players = new LinkedList<>();
        for(int i = 0; i < N; i++) {
            players.add(new LinkedList<>());
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                int score = Integer.parseInt(st.nextToken());
                Player p = new Player(i, score);
                players.get(p.team).add(p);
            }
        }
        br.close();
        for(int i = 0; i < N; i++) {
            Collections.sort(players.get(i));
        }

        int max = 0;
        int cnt = 0;
        PriorityQueue<Player> pq = new PriorityQueue<>();
        for(int i = 0; i < N; i++) {
            Player p = players.get(i).remove();
            max = Math.max(max, p.score);
            pq.add(p);
            cnt++;
        }

        int ans = Integer.MAX_VALUE;
        ans = Math.min(ans, max - pq.peek().score);
        OUTER:
        while (players.get(pq.peek().team).size() > 0) {
            Player p = players.get(pq.peek().team).remove();
            max = Math.max(max, p.score);
            pq.poll();
            pq.add(p);
            ans = Math.min(ans, max - pq.peek().score);
            cnt++;
        }
        System.out.println(ans);
    }
}
