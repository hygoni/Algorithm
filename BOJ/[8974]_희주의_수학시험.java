import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		for(int i = 1; i <= B; i++) {
			for(int j = 0; j < i; j++) {
				list.add(i);
			}
		}
		
		int sum = 0;
		for(int i = A; i <= B; i++) {
			sum += list.get(i-1);
		}
		
		bw.write(sum + "\n");		
		bw.flush();
		br.close();
		bw.close();
	}
}

