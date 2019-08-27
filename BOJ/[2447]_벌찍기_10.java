import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Main {
	
	public static StringBuilder repeat(String str, int n) {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < n; i++) {
			sb.append(str);
		}
		return sb;
	}
	
	
	public static StringBuilder[] makeStar(int n) {
		int cnt = 1;
		while(n / 3 != 1) {
			cnt++;
			n /= 3;
		}
		n = cnt;
		
		StringBuilder[] prev = new StringBuilder[3];
		for(int i = 0 ; i < prev.length; i++) {
			prev[i] = new StringBuilder();
		}
		StringBuilder[] new_ = null;
		prev[0].append("***");
		prev[1].append("* *");
		prev[2].append("***");
		
		
		for(int i = 1; i < n; i++) {
			new_ = null;
			new_ = new StringBuilder[prev.length * 3];
			for(int j = 0; j < new_.length; j++) {
				new_[j] = new StringBuilder();
			}
			
			for(int j = 0; j < prev.length; j++) {
				new_[j].append(prev[j]);
				new_[j].append(prev[j]);
				new_[j].append(prev[j]);
			}
			for(int j = prev.length; j < 2 * prev.length; j++) {
				new_[j].append(prev[j-prev.length]);
				new_[j].append(repeat(" ", prev.length));
				new_[j].append(prev[j-prev.length]);
			}
			for(int j = 2*prev.length; j < 3 * prev.length; j++) {
				new_[j].append(prev[j-2*prev.length]);
				new_[j].append(prev[j-2*prev.length]);
				new_[j].append(prev[j-2*prev.length]);
			}
			prev = null;
			prev = new_;
		}
		if(n == 1)
			return prev;
		else
			return new_;
	}
	
	public static void main(String[] args) throws IOException {
		Scanner input = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = input.nextInt();
		StringBuilder[] stars = makeStar(n);
		for(int i = 0; i < stars.length; i++) {
			bw.write(stars[i] + "\n");
		}
		bw.close();
		input.close();
	}
}

