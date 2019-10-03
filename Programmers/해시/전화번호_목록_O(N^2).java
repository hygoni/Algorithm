class Solution {
    public boolean solution(String[] phone_book) {
    	int n = phone_book.length;
    	for(int i = 0; i < n; i++) {
    		for(int j = 0; j < n; j++) {
    			if(0 == phone_book[j].indexOf(phone_book[i]) && !phone_book[j].equals(phone_book[i])){
    				return false;
    			}
    		}
    	}
        boolean answer = true;
        return answer;
    }
}
