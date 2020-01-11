import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		LinkedList<Integer> list = new LinkedList<>();
		
		while(N != 1) {
			for(int i = 2; i <= N; i++) {
				if(N % i == 0) {
					N /= i;
					list.add(i);
					break;
				}
			}
		}
		
		Collections.sort(list);
		Iterator<Integer> iter = list.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		br.close();
	}
}
