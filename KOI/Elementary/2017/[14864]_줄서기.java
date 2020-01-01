import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

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
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		List<Integer> list = new LinkedList<>();
		List<Pair> verify = new LinkedList<>();
		int after[] = new int[N+1];
		
		for(int i = 1; i <= N; i++) {
			list.add(i);
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int bigger = Integer.parseInt(st.nextToken());
			int smaller = Integer.parseInt(st.nextToken());				
			verify.add(new Pair(bigger, smaller));
			after[bigger]++;
		}
		br.close();
		
		int answer[] = new int[N+1];
		for(int i = 1; i <= N; i++) {
			int cardNum = list.remove(after[i]);
			answer[i] = cardNum;
		}
		
		
		//정답 검증
		int ans = 0;
		Iterator<Pair> iterPair = verify.iterator();
		while(iterPair.hasNext()) {
			Pair p = iterPair.next();
			int bigger = p.x;
			int smaller = p.y;
			if(answer[bigger] < answer[smaller]) {
				ans = -1;
			}
			
		}
		
		if(ans == -1) {
			System.out.println(ans);
		} else {
			StringBuilder sb = new StringBuilder();
			for(int i = 1; i <= N; i++) {
				sb.append(answer[i]).append(" ");
			}
			System.out.println(sb);		
		}
		
		
	}
}
