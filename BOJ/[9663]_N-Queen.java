import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	    static int ans = 0;
	        static int cols[];
		    static int N;
		        public static boolean isPossible(int row) {
				        for(int i = 0; i < row; i++) {
						            if (cols[i] == cols[row]) return false;
							                if (cols[i] - cols[row] == row - i) return false;
									            if (cols[row] - cols[i] == row - i) return false;
										            }
					        return true;
						    }
			    public static void solve(int row) {
				            if (row == N) {
						                ans++;
								            return;
									            }
					            for(int i = 0; i < N; i++) {
							                cols[row] = i;
									            if (isPossible(row))
											                    solve(row + 1);
										            }
						        }
			        public static void main(String[] args) throws IOException {
					        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
						        N = Integer.parseInt(br.readLine());
							        br.close();
								        cols = new int[N];
									        solve(0);
										        System.out.println(ans);
											    }
}
