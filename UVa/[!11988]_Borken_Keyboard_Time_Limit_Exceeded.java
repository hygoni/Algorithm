import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.LinkedList;

//Type of problem : List
//Time Complexity : O(N)

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String line = br.readLine();
		while(line != null) {
			LinkedList<Character> left = new LinkedList<Character>();
			LinkedList<Character> right = new LinkedList<Character>();
			LinkedList<Character> writeHere = left;
			
			for(int i = 0; i < line.length(); i++) {
				char ch = line.charAt(i);
				if(ch == '[') {
					right.addAll(left);
					left = new LinkedList<Character>();
					writeHere = left;
				} else if(ch == ']') {
					left.addAll(right);
					right = new LinkedList<Character>();
					writeHere = right;
				} else {
					writeHere.add(ch);
				}
			}
			
			left.addAll(right);
			Iterator<Character> iter = left.iterator();
			while(iter.hasNext()) {
				bw.write(iter.next());
			} bw.write("\n"); bw.flush();
			
			line = br.readLine();
		}

		br.close();
		bw.close();
	}
}

