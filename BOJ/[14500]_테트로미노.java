import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Integer map[][] = new Integer[N][M];

        for(int y = 0; y < N; y++){
            st = new StringTokenizer(br.readLine());
            for(int x = 0; x < M; x++){
                map[y][x] = Integer.parseInt(st.nextToken());
            }
        }

        //1번
        Integer t1[][] = {{1, 1, 1, 1}};
        Integer t6[][] = {{1}, {1}, {1}, {1}};

        //2번
        Integer t2[][] = {{1, 1}, {1, 1}};

        //3번
        Integer t3[][] = {{1, 0}, {1, 0}, {1, 1}};
        Integer t8[][] = {{1, 1}, {0, 1}, {0, 1}};
        Integer t15[][] = {{1, 1}, {1, 0}, {1, 0}};
        Integer t7[][] = {{1, 1, 1}, {1, 0, 0}};
        Integer t16[][] = {{0, 1}, {0, 1}, {1, 1}};
        Integer t9[][] = {{0, 0, 1}, {1, 1, 1}};
        Integer t14[][] = {{1, 1, 1}, {0, 0, 1}};
        Integer t17[][] = {{1, 0, 0}, {1, 1, 1}};


        //4번
        Integer t4[][] = {{1, 0}, {1, 1}, {0, 1}};
        Integer t10[][] = {{0, 1, 1}, {1, 1, 0}};
        Integer t18[][] = {{0, 1}, {1, 1}, {1, 0}};
        Integer t19[][] = {{1, 1, 0}, {0, 1, 1}};

        //5번
        Integer t5[][] = {{1, 1, 1}, {0, 1, 0}};
        Integer t11[][] = {{0, 1}, {1, 1}, {0, 1}};
        Integer t12[][] = {{0, 1, 0}, {1, 1, 1}};
        Integer t13[][] = {{1, 0}, {1, 1}, {1, 0}};



        LinkedList<Integer[][]> list = new LinkedList<>();
        list.add(t1);
        list.add(t2);
        list.add(t3);
        list.add(t4);
        list.add(t5);
        list.add(t6);
        list.add(t7);
        list.add(t8);
        list.add(t9);
        list.add(t10);
        list.add(t11);
        list.add(t12);
        list.add(t13);
        list.add(t14);
        list.add(t15);
        list.add(t16);
        list.add(t17);
        list.add(t18);
        list.add(t19);

        int ans = 0;
        Iterator<Integer[][]> iter = list.iterator();
        while(iter.hasNext()) {
            Integer tetromino[][] = iter.next();
            for(int y_ = 0; y_ < map.length - tetromino.length + 1; y_++){
                for(int x_ = 0; x_ < map[y_].length - tetromino[0].length + 1; x_++) {
                    int subAns = 0;
                    for(int y = 0; y < tetromino.length; y++){
                        for(int x = 0; x < tetromino[0].length; x++){
                            if (tetromino[y][x] == 1){
                                subAns += map[y_ + y][x_ + x];
                            }
                        }
                    }
                    ans = Math.max(ans, subAns);
                }
            }
        }

        System.out.println(ans);
        br.close();
    }
}
