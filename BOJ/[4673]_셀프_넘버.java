import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	static StringBuilder sb;
	static int cnt = 0;

	public static int d(int n) {
		String num = Integer.toString(n);
		for(int i = 0; i < num.length(); i++) {
			n += (num.charAt(i) - '0');
		}
		return n;
	}

	public static void main(String ... args) throws IOException {
		boolean[] isSelfNum = new boolean[10001];
		
		Scanner input = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for(int i = 1; i <= 10000; i++) {
			int k = d(i);
			if(k > 10000) {
				continue;
			} else {
				isSelfNum[k] = true;
			}
		}

		for(int i = 1; i <= 10000; i++) {
			if(isSelfNum[i] == false) {
				bw.write(i + "\n");
			}
		}


		bw.flush();
		bw.close();
		input.close();
	}
}
