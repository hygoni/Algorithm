import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//Type of problem : Math
//Time Complexity : O(N)
public class Main {
	
	//O(1)
	public static int cycle(String n) {
		if(n.length() == 1) {
			return Integer.parseInt(n + n);
		} else {
			String originalRight = Integer.toString(n.charAt(1) - '0');
			int a = n.charAt(0) - '0';
			int b = n.charAt(1) - '0';
			String newNum = Integer.toString(a + b);
			String newRight = "";
			
			if(Integer.parseInt(newNum) < 10) {
				newRight = newNum;
			} else {
				newRight = Integer.toString(newNum.charAt(1) - '0');
			}
			return Integer.parseInt(originalRight + newRight);
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String n = br.readLine();
		int cnt = 1;
		int result = cycle(n);
		
		//O(N)
		while(Integer.parseInt(n) != result) {
			result = cycle(Integer.toString(result));
			cnt++;
		}
		bw.write(cnt + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}

