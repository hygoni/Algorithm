import java.util.Scanner;

public class Main {

	public static boolean isGroupWord(String line) {
		boolean isAlreadyUsed[] = new boolean[26]; 
		for(int i = 0; i < line.length(); i++) {	
			int idx = line.charAt(i) - 'a';
			if(i == 0) {
				isAlreadyUsed[idx] = true;
			} else {
				if(isAlreadyUsed[idx]) {
					if(line.charAt(i-1) == 'a' + idx) {
						continue;
					} else {
						return false;
					}
				} else {
					isAlreadyUsed[idx] = true;
				}
			}
		}
		
		return true;
	}
	
	public static void main(String ... args) {
		Scanner input = new Scanner(System.in);
		int t = input.nextInt();
		int groupWordCount = 0;
		input.nextLine();
		
		for(int i = 0; i < t; i++) {
			String line = input.nextLine();
			if(isGroupWord(line)) {
				groupWordCount++;
			}
		}
		
		System.out.println(groupWordCount);
		input.close();
	}
}
