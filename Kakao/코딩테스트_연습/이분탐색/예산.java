import java.util.Arrays;

class Solution {
	
	public long getSum(int[] budgets, int M, int upperBound) {
		long ans = 0;
		for(int i = 0; i < budgets.length; i++) {
			int requestedMoney = budgets[i];
			if(requestedMoney > upperBound) {
				ans += upperBound;
			} else {
				ans += requestedMoney;
			}
		}
		if(ans > M) {
			return -1;
		} else {
			return ans;
		}
	}
	
    public int solution(int[] budgets, int M) {
    	Arrays.sort(budgets);
    	int start = 0;
    	int end = budgets[budgets.length - 1];
    	int max = 0;
    	while(start <= end) {
    		int mid = (start + end) / 2;
    		long money = getSum(budgets, M, mid);
    		//impossible
    		if(money == -1) {
    			end = mid - 1;
    		} else {
    			if(max < mid) {
    				max = mid;
    			}
    			start = mid + 1;
    		}
    	}
        int answer = max;
        return answer;
    }
}
