import java.util.Arrays;

class Solution {

	public int[] copy(int[] arr, int start, int end) {
		int[] copied = new int[end-start+1];
		for(int i = start-1; i < end; i++) {
			copied[i-start+1] = arr[i];
		}
		return copied;
	}
	
	public int[] solution(int[] array, int[][] commands) {
    	int idx = 0;
    	int[] answer = new int[commands.length];
		for(int i = 0; i < commands.length; i++) {
    		int start = commands[i][0];
    		int end = commands[i][1];
    		int[] copied = copy(array, start, end);
    		Arrays.sort(copied);
    		int k = commands[i][2];
    		answer[idx++] = copied[k-1];
    	}
        return answer;
    }
	
	public static void main(String[] args) {
		int[] array = {1, 5, 2, 6, 3, 7, 4};
		int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
		new Solution().solution(array, commands);
	}
}
