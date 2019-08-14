import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

//Type of problem : Array & Sum
//Time Complexity : O(N)
public class Main {
	
	public static boolean compare(char[][] a1, char[][] a2) {
		for(int i = 0; i < a1.length; i++) {
			for(int j = 0; j < a1[0].length; j++) {
				if(a1[i][j] != a2[i][j])
					return false;
			}
		}
		return true;
	}
	
	public static char[][] rotate(char[][] arr, int degree){
		char[][] transformed = new char[arr.length][arr.length];
		if(degree == 90) {
			for(int i = 0; i < arr.length; i++) {
				for(int j = 0; j < arr.length; j++) {
					transformed[i][j]=arr[arr.length - j - 1][i];
				}
			}
		} else if(degree == 180) {
			transformed = rotate(transformed, 90);
			transformed = rotate(transformed, 90);
		} else if(degree == 270) {
			transformed = rotate(transformed, 90);
			transformed = rotate(transformed, 90);
			transformed = rotate(transformed, 90);
		} else {
			return null;
		}
		return transformed;
	}
	
	public static char[][] vReflect(char[][] arr){
		char[][] transformed = new char[arr.length][arr.length];
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr.length; j++) {
				transformed[arr.length - i - 1][j] = arr[i][j];
			}
		}
		return transformed;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String line;
		int t = 1;
		while(((line = br.readLine()) != null) || (!line.equals(""))) {
			int n = Integer.parseInt(line);
			char[][] original = new char[n][n];
			char[][] transformed = new char[n][n];
			for(int i = 0; i < n; i++) {
				line = br.readLine();
				StringTokenizer tokenizer = new StringTokenizer(line, " ");
				String line_ = tokenizer.nextToken();
				
				for(int j = 0; j < n; j++) {
					original[i][j] = line_.charAt(j);
				}
				
				line_ = tokenizer.nextToken();
				for(int j = 0; j < n; j++) {
					transformed[i][j] = line_.charAt(j);
				}
				
			}
			
			if(compare(transformed, vReflect(original))) {
				bw.write(String.format("Pattern %d was reflected vertically.\n", t++));
				bw.flush();
			} else if(compare(transformed, rotate(original, 90))) {
				bw.write(String.format("Pattern %d was rotated 90 degrees.\n", t++));
				bw.flush();					
			} else if(compare(transformed, rotate(original, 180))) {
				bw.write(String.format("Pattern %d was rotated 180 degrees.\n", t++));
				bw.flush();
			} else if(compare(transformed, rotate(original, 270))) {
				bw.write(String.format("Pattern %d was rotated 270 degrees.\n", t++));
				bw.flush();
			} else if(compare(transformed, vReflect(rotate(original, 90)))) {
				bw.write(String.format("Pattern %d was reflected vertically and rotated 90 degrees.\n", t++));
				bw.flush();
			} else if(compare(transformed, vReflect(rotate(original, 180)))) {
				bw.write(String.format("Pattern %d was reflected vertically and rotated 180 degrees.\n", t++));
				bw.flush();
			} else if(compare(transformed, vReflect(rotate(original, 270)))) {
				bw.write(String.format("Pattern %d was reflected vertically and rotated 270 degrees.\n", t++));
				bw.flush();
			} else if(compare(transformed, original)) {
				bw.write(String.format("Pattern %d was preserved.\n", t++));
				bw.flush();
			} else {
				bw.write(String.format("Pattern %d was improperly transformed.\n", t++));
				bw.flush();
			}

		}
		bw.close();
	}
}

