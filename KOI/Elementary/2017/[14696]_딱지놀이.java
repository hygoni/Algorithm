import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Ddakji implements Comparable<Ddakji> {
	int count[];

	public Ddakji(String line) {
		StringTokenizer st = new StringTokenizer(line);
		int n = Integer.parseInt(st.nextToken());
		this.count = new int[5];
		
		for(int i = 0; i < n; i++) {
			count[4-Integer.parseInt(st.nextToken())]++;
		}
		
	}
	
	@Override
	public int compareTo(Ddakji o) {
		int idx = 0;
		int cmp = Integer.compare(this.count[idx], o.count[idx]);
		idx++;
		while(cmp == 0 && idx < count.length) {
			cmp = Integer.compare(this.count[idx], o.count[idx]);
			idx++;
		}
		return cmp;
	}
	
}

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < n; i++) {
			Ddakji A = new Ddakji(br.readLine());
			Ddakji B = new Ddakji(br.readLine());
			int cmp = A.compareTo(B);
			if(cmp < 0) {
				sb.append("B").append("\n");
			} else if(cmp > 0) {
				sb.append("A").append("\n");
			} else {
				sb.append("D").append("\n");
			}
		}
		
		System.out.print(sb);
		br.close();
	}
}
