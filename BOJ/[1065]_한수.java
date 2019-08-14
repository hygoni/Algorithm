import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//Type of problem : Ad Hoc
//Time Complexity : O(N^2)
public class Main {
	
	public static boolean isHansu(String num) {
				
		int[] nums = new int[num.length()];
		for(int i = 0; i < num.length(); i++) {
			nums[i] = num.charAt(i);
		}
		
		int[] diff = new int[nums.length - 1];
		for(int i = 1; i < nums.length; i++) {
			diff[i-1] = (nums[i-1] - nums[i]);
		}
		
		for(int i = 1; i < diff.length; i++) {
			if(diff[i-1] != diff[i]) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		int count = 0;
		for(int i = 1; i <= n; i++) {
			if(isHansu(Integer.toString(i))) {
				count++;
			}
		}
		bw.write(count + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}

