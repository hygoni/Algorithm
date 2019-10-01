import java.util.Arrays;

class Solution {
	public static int getResult(int[] d, int budget) {
		int ans = 0;
		for(int i = 0; i < d.length; i++) {
			int requestedMoney = d[i];
			if(budget - requestedMoney >= 0) {
				ans++;
				budget -= requestedMoney;
			}
		}
		return ans;
	}
	public int solution(int[] d, int budget) {
		Arrays.sort(d);
		return getResult(d, budget);
	}
}
