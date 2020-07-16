import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        String T = br.readLine();
        LinkedList<Character> slist = new LinkedList<>();
        LinkedList<Character> tlist = new LinkedList<>();
        LinkedList<LinkedList<Character>> list = new LinkedList<>();
        list.add(tlist);
        br.close();
        
        for(char c : S.toCharArray()) {
            slist.add(c);
        }
        for(char c : T.toCharArray()) {
            tlist.add(c);
        }
        
        list.add(tlist);
        while (!list.isEmpty()) {
            tlist = list.poll();
            if (tlist.size() == slist.size()) {
                if (tlist.equals(slist)) {
                    System.out.println(1);
                    return;
                }
            } else if (tlist.peekLast() == 'A' && tlist.peekFirst() == 'B') {
                LinkedList<Character> copy = new LinkedList<>(tlist);
                copy.pollLast();
                list.add(copy);
                tlist.pollFirst();
                Collections.reverse(tlist);
                list.add(tlist);                
            } else if (tlist.peekLast() == 'A') {
                tlist.pollLast();
                list.add(tlist);
            } else if (tlist.peekFirst() == 'B') {
                tlist.pollFirst();
                Collections.reverse(tlist);
                list.add(tlist);  
            }
        }
        System.out.println(0);
    }
}
