import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static String twoToEight(String n) {
		StringBuilder sb = new StringBuilder();
		
		int r = n.length() % 3;
		while(r != 0) {
			n = "0" + n;
			r = n.length() % 3;
		}
		for(int i = 0; i < n.length(); i += 3) {
			int one = n.charAt(i) - '0';
			int two = n.charAt(i+1) - '0';
			int three = n.charAt(i+2) - '0';
			int result = (int) (one * Math.pow(2, 2) + two * Math.pow(2,  1) + three * Math.pow(2, 0));
			sb.append(result + "");
		}
		return sb.toString();
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		String two = br.readLine();
		System.out.println(twoToEight(two));
		br.close();
	}
}

