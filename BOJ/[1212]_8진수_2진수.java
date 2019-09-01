import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static String eightToTwo(String n) {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < n.length(); i++) {
			int k = n.charAt(i) - '0';
			int one = (0b100 & k);
			int two = (0b010 & k);
			int three = (0b001 & k);
			if(one > 0) {
				sb.append("1");
			} else {
				sb.append("0");
			}
			if(two > 0) {
				sb.append("1");
			} else {
				sb.append("0");
			}
			if(three > 0) {
				sb.append("1");
			} else {
				sb.append("0");
			}
		}
		
		while((sb.charAt(0) == '0') && sb.length() != 1) {
			sb.deleteCharAt(0);
		}
		
		return sb.toString();
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		String eight = br.readLine();
		System.out.println(eightToTwo(eight));
		br.close();
	}
}

