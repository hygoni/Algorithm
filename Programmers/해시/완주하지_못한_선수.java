import java.util.HashMap;

class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> part = new HashMap<String, Integer>();
        String answer = "";
        for(int i = 0; i < participant.length; i++){
            String key = participant[i];
            if(!part.containsKey(key)){
                part.put(key, 1);
            } else {
                part.replace(key, part.get(key)+1);
            }
        }
        
        
        HashMap<String, Integer> comp = new HashMap<String, Integer>();
        for(int i = 0; i < completion.length; i++){
            String key = completion[i];
            part.put(key, part.get(key)-1);
        }
        
        for(int i = 0; i < participant.length; i++) {
        	String key = participant[i];
        	if(part.get(key) > 0) {
        		answer = key;
                break;
        	}
        }
        
        return answer;
    }
}
