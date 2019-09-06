import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

class Solution {

	public int containsIgnoreCase(LinkedList<String> q, String target) {
		int idx = 0;
		Iterator<String> iter = q.iterator();
		while(iter.hasNext()) {
			if(iter.next().equalsIgnoreCase(target)) {
				return idx;
			}
			idx++;
		}
		return -1;
	}

	public int solution(int cacheSize, String[] cities) {
		LinkedList<String> q = new LinkedList<String>();
		int answer = 0;
		for(int i = 0; i < cities.length; i++) {
			int idx = containsIgnoreCase(q, cities[i]);
			if(idx >= 0) { //cache hit
				answer += 1;
				q.addLast(q.remove(idx)); //끝으로 옮김
			} else { //cache miss
				answer += 5;
				if(cacheSize == 0) {
					continue;
				} else if(q.size() == cacheSize) {
					q.poll();
				}
				q.addLast(cities[i]);
			}
		}
		return answer;
	}
}
