import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int cache[][];
	static final int TRUE = 1;
	static final int FALSE = 2;
	public static boolean canComplete(int x, int y, int map[][]) {
		if(x >= map.length || y >= map.length) {
			return false;
		}
		if(x == map.length - 1 && y == map.length - 1) {
			return true;
		}
		if(cache[x][y] == TRUE) {
			return true;
		} else if(cache[x][y] == FALSE) {
			return false;
		}
		
		int amount = map[y][x];
		boolean right = canComplete(x + amount, y, map);
		boolean down = canComplete(x, y + amount, map);
		if(x + amount < map.length) {
			cache[x + amount][y] = right ? TRUE : FALSE;
		}
		if(y + amount < map.length) {
			cache[x][y + amount] = down ? TRUE : FALSE;
		}
		return  right || down;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			int map[][] = new int[N][N];
			cache = new int[N][N];
			for(int y = 0; y < N; y++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int x = 0; x < N; x++) {
					map[y][x] = Integer.parseInt(st.nextToken());
				}
			}
			if(canComplete(0, 0, map)) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
		br.close();
	}
}

