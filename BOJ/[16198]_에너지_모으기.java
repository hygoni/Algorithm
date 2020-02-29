import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	    static int ans = 0;
	        public static void solve(ArrayList<Integer> beads, int energy) {
			        if (beads.size() == 2) {
					            ans = Math.max(ans, energy);
						            } else {
								                for(int i = 1; i < beads.size() - 1; i++) {
											                int add = beads.get(i - 1) * beads.get(i + 1);
													                int bead = beads.remove(i);
															                solve(beads, energy + add);
																	                beads.add(i, bead);
																			            }
										        }
				    }
		    public static void main(String[] args) throws IOException {
			            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				            int N = Integer.parseInt(br.readLine());
					            ArrayList<Integer> beads = new ArrayList<Integer>();
						            StringTokenizer st = new StringTokenizer(br.readLine());
							            for(int i = 0; i < N; i++) {
									                beads.add(Integer.parseInt(st.nextToken()));
											        }
								            solve(beads, 0);
									            System.out.println(ans);
										            br.close();
											        }
}
