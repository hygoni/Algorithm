import java.util.Scanner;

public class Main {
	
	public static int count(String line, String word) {
		int cnt = 0;
		int idx = line.indexOf(word);
		while(idx >= 0) {
			idx = line.indexOf(word, idx+1);
			cnt++;
		}
		return cnt;
	}
	

	public static void main(String ... args) {
		Scanner input = new Scanner(System.in);
		String line = input.nextLine();
		int ans = 0;
		int add = line.length();
		
		int tmp = count(line, "c=");
		ans += tmp;
		add -= tmp * 2;
		tmp = count(line, "c-");
		ans += tmp;
		add -= tmp * 2;
		tmp = count(line, "dz=");
		line = line.replace("dz=", "");
		ans += tmp;
		add -= tmp * 3;
		tmp = count(line, "d-");
		ans += tmp;
		add -= tmp * 2;
		tmp = count(line, "lj");
		ans += tmp;
		add -= tmp * 2;
		tmp = count(line, "nj");
		ans += tmp;
		add -= tmp * 2;
		tmp = count(line, "s=");
		ans += tmp;
		add -= tmp * 2;
		tmp = count(line, "z=");
		ans += tmp;
		add -= tmp * 2;
		
		System.out.println(ans + add);
		input.close();
	}
}
