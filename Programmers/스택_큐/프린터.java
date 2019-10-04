import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

class Solution {
	public int solution(int[] priorities, int location) {
		Deque<Integer> deq = new LinkedList<Integer>();
		for(int i = 0; i < priorities.length; i++) {
			deq.add(i);
		}
		
		int answer = 1;
		while(true) {
			int printIdx = deq.poll();
			boolean isDelayed = false;
			Iterator<Integer> iter = deq.iterator();
			
			while(iter.hasNext()) {
				int other = iter.next();
				if(priorities[other] > priorities[printIdx]) {
					isDelayed = true;
					break;
				}
			}
			
			if(isDelayed) {
				deq.add(printIdx);
				isDelayed = false;
				continue;
			}		
			
			if(printIdx == location) {
				break;
			} else {
				answer++;
			}
		}
		return answer;
	}
}
