import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
			
		ArrayList<Integer> z = new ArrayList<Integer>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int k = Integer.parseInt(br.readLine());
		
		for(int y = 0; k - 2*y >= 0; y++) {
			int x = (k - 2*y) / 3 - y;
			if(((k - 2*y) % 3 == 0) && x >= 0) {
				z.add(x+y);
			}
		}
		
		if(z.size() > 0) {
			Collections.sort(z);
			bw.write(z.get(0) + "");
		} else {
			bw.write(-1 + "");
		}

		bw.flush(); //버퍼 비우기
		
		
	}

}
