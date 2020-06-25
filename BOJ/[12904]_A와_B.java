import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        String T = br.readLine();
        br.close();

        LinkedList<Character> slist = new LinkedList<>();
        LinkedList<Character> tlist = new LinkedList<>();

        for(int i = 0; i < S.length(); i++) {
            slist.add(S.charAt(i));
        }

        for(int i = 0; i < T.length(); i++) {
            tlist.add(T.charAt(i));
        }

        while (tlist.size() > slist.size()) {
            if (tlist.peekLast() == 'B') {
                tlist.pollLast();
                Collections.reverse(tlist);
            } else {
                tlist.pollLast();
            }
        }

        System.out.println((slist.equals(tlist)) ? 1 : 0);
    }
}
