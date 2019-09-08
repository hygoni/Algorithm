import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	public static int getWhiteCost(boolean[][] map, int nStart, int mStart) {
		int cost = 0;
		for(int i = nStart; i < nStart+8; i++) {
			for(int j = mStart; j < mStart+8; j++) {
				if(i % 2 == 0) {
					if(j % 2 == 0) {
						if(map[i][j] == false) {
							cost++;
						}
					} else {
						if(map[i][j] == true) {
							cost++;
						}
					}
				} else {
					if(j % 2 == 0) {
						if(map[i][j] == true) {
							cost++;
						}
					} else {
						if(map[i][j] == false) {
							cost++;
						}
					}
				}
			}
		}
		return cost;
	}
	
	public static int getBlackCost(boolean[][] map, int nStart, int mStart) {
		int cost = 0;
		for(int i = nStart; i < nStart+8; i++) {
			for(int j = mStart; j < mStart+8; j++) {
				if(i % 2 == 0) {
					if(j % 2 == 0) {
						if(map[i][j] == true) {
							cost++;
						}
					} else {
						if(map[i][j] == false) {
							cost++;
						}
					}
				} else {
					if(j % 2 == 0) {
						if(map[i][j] == false) {
							cost++;
						}
					} else {
						if(map[i][j] == true) {
							cost++;
						}
					}
				}
			}
		}
		return cost;
	}
	public static void main(String[] args) {	 
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int m = input.nextInt();
		input.nextLine();
		boolean[][] map = new boolean[n][m];
		int ans = 10000000;
		
		for(int i = 0; i < n; i++) {
			String line = input.nextLine();
			for(int j = 0; j < m; j++) {
				char ch = line.charAt(j);
				if(ch == 'W') {
					map[i][j] = true;
				}
			}
		}

		for(int i = 0; i < map.length - 7; i++) {
			for(int j = 0; j < map[0].length - 7; j++) {
				ans = Math.min(ans, getWhiteCost(map, i, j));
				ans = Math.min(ans, getBlackCost(map, i, j));
			}
		}

		System.out.println(ans);
		input.close();
	}
}

