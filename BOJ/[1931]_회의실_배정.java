import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

class Time implements Comparable<Time> {
    int start, end;
    public Time(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Time o) {
        if (this.end == o.end) {
            return Integer.compare(this.start, o.start);
        } else {
            return Integer.compare(this.end, o.end);
        }
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        LinkedList<Time> list = new LinkedList<>();
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            Time time = new Time(start, end);
            list.add(time);
        }
        br.close();
        Collections.sort(list);

        int end = 0;
        int ans = 0;
        while (!list.isEmpty()) {
            Time time = list.remove();
            if (end <= time.start) {
                end = time.end;
                ans++;
            }
        }
        System.out.println(ans);
    }
}
