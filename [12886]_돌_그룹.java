import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Group {
    int arr[];
    int dist;
    public Group(int x, int y, int z, int dist) {
        arr = new int[3];
        arr[0] = x;
        arr[1] = y;
        arr[2] = z;
        this.dist = dist;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int sum = A + B + C;
        br.close();
        if (sum % 3 != 0) {
            System.out.println(0);
            return;
        }
        
        boolean visited[][] = new boolean[1500 + 1][1500 + 1];
        visited[A][B] = true;
        Queue<Group> q = new LinkedList<>();
        q.add(new Group(A, B, C, 0));

        while(!q.isEmpty()) {
            Group u = q.poll();
            for(int i = 0; i < u.arr.length; i++) {
                for(int j = 0; j < u.arr.length; j++) {
                    if (u.arr[i] < u.arr[j]) {
                        u.arr[j] -= u.arr[i];
                        u.arr[i] += u.arr[i];
                        if (!visited[u.arr[0]][u.arr[1]]) {
                            q.add(new Group(u.arr[0], u.arr[1], u.arr[2], u.dist + 1));
                            visited[u.arr[0]][u.arr[1]] = true;
                        }
                    }
                }
            }
        }
        System.out.println(visited[sum / 3][sum / 3] ? 1 : 0);
    }
}
