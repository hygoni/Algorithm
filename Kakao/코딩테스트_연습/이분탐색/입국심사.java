import java.math.BigInteger;
import java.util.Arrays;

class Solution {
	public long solution(int n, int[] times) {
		Arrays.sort(times);
		BigInteger start = BigInteger.ZERO;
		BigInteger end = new BigInteger(times[times.length-1] + "").multiply(new BigInteger(n + ""));
		BigInteger min = new BigInteger(Long.MAX_VALUE + "");
		while(start.compareTo(end) <= 0) {
			BigInteger mid = (start.add(end)).divide(new BigInteger("2"));
			BigInteger people = BigInteger.ZERO;
			for(int time : times) {
				people = people.add(mid.divide(new BigInteger(time + "")));
			}
			
			if(people.compareTo(new BigInteger(n + "")) >= 0) {
				if(min.compareTo(mid) > 0) {
					min = mid;
				}
				end = mid.subtract(BigInteger.ONE);
			} else {
				start = mid.add(BigInteger.ONE);
			}
		}
		long answer = min.longValue();
		return answer;
	}
}
