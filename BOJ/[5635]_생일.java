mport java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
import java.util.StringTokenizer;

class Person implements Comparable<Person> {

    String name;
    Date date;

    public Person(String name, Date date){
        this.name = name;
        this.date = date;
    }

    @Override
    public int compareTo(Person o) {
        return date.compareTo(o.date);
    }
}

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        LinkedList<Person> list = new LinkedList<>();
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int day = Integer.parseInt(st.nextToken());
            int month  = Integer.parseInt(st.nextToken());
            int year = Integer.parseInt(st.nextToken());
            Date date = new Date(year, month, day);
            list.add(new Person(name, date));
        }

        Collections.sort(list);
        Person first = list.pollLast();
        Person last = list.pollFirst();
        System.out.println(first.name);
        System.out.println(last.name);
        br.close();
    }
}
