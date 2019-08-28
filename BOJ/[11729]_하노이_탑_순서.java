import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Main {
	static StringBuilder sb;
	static int cnt = 0;
	
	public static void hanoi(int from, int to, int amount) throws IOException {
		if(amount == 1) {
			sb.append(from + " " + to + "\n");
			cnt++;
			return;
		}
		int another = 6 - from - to;
		hanoi(from, another, amount-1);
		hanoi(from, to, 1);
		hanoi(another, to, amount-1);
		
	}
	
	public static void main(String ... args) throws IOException {
		Scanner input = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();
		
		int n = input.nextInt();
		hanoi(1, 3, n);
		bw.write(cnt + "\n");
		bw.write(sb.toString());
		
		bw.flush();
		bw.close();
		input.close();
	}
}
