import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

class Solution {
    public int solution(String[][] clothes) {
    	final int CATEGORY = 1;
    	Map<String, Integer> map = new HashMap<String, Integer>();
    	
    	for(int i = 0; i < clothes.length; i++) {
    		String category = clothes[i][CATEGORY];
    		if(!map.containsKey(category)) {
    			map.put(category, 1);
    		} else {
    			map.put(category, map.get(category)+1);
    		}
    	}
    	
    	Iterator<String> iter = map.keySet().iterator();
    	int answer = 1;
    	while(iter.hasNext()) {
    		int count = map.get(iter.next());
    		answer *= (count + 1); //안 입는 경우까지 + 1
    	}
    	answer -= 1; //아무것도 안 입는 경우는 제외
    	return answer;
    }

}
