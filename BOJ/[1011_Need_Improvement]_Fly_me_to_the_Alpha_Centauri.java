import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

//100ms 이내로 푼 사람도 많은 걸 보니 이상하게 푼 편으로 보임.
//더 짧게 풀어보자.

public class Main {
	
	public static boolean isUp(int speed, int distance) { //속도를 올려도 될까?
		speed++; //next
		BigInteger spd = new BigInteger(Integer.toString(speed));
		BigInteger dist = new BigInteger(Integer.toString(distance));
		BigInteger sum = spd.multiply(spd.add(BigInteger.ONE)).divide(BigInteger.ONE.add(BigInteger.ONE));
		return sum.compareTo(dist) <= 0;
	}
	
	public static boolean isKeep(int speed, int distance) { //속도를 유지해도 될까?
		BigInteger spd = new BigInteger(Integer.toString(speed));
		BigInteger dist = new BigInteger(Integer.toString(distance));
		BigInteger sum = spd.multiply(spd.add(BigInteger.ONE)).divide(BigInteger.ONE.add(BigInteger.ONE));
		return sum.compareTo(dist) <= 0;
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < t; i++) {
			StringTokenizer to = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(to.nextToken());
			int y = Integer.parseInt(to.nextToken());
			int cnt = 0;
			int speed = 1; // x < y이므로 적어도 1칸은 이동해야함
			
			while(x != y) { //도착할 때까지
				if(x < 0) {
					break;
				}
				x += speed;
				if(isUp(speed, y-x)) {
					speed++;
				} else if(isKeep(speed, y-x)) {
					//nothing
				} else {
					speed--;
				}
				cnt++;
			}
			
			System.out.println(cnt);
		}
	}
}

