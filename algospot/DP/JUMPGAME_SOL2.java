import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {	
	static final int TRUE = 1;
	static final int FALSE = 2;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			int map[][] = new int[N][N];
			int d[][] = new int[N][N];
			for(int y = 0; y < N; y++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int x = 0; x < N; x++) {
					map[y][x] = Integer.parseInt(st.nextToken());
				}
			}
			
			d[0][0] = TRUE;
			for(int y = 0; y < N; y++) {
				for(int x = 0; x < N; x++) {
					if(d[y][x] == TRUE){
						int amount = map[y][x];
						if(x + amount < N) {
							d[y][x + amount] = TRUE;
						}
						if(y + amount < N) {
							d[y + amount][x] = TRUE;
						}
					}
					
				}
			}
			
			if(d[N-1][N-1] == TRUE) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
		br.close();
	}
}

