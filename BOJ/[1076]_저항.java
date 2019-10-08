import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long resist[][] = new long[10][2];
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("black", 0);
		map.put("brown", 1);
		map.put("red", 2);
		map.put("orange", 3);
		map.put("yellow", 4);
		map.put("green", 5);
		map.put("blue", 6);
		map.put("violet", 7);
		map.put("grey", 8);
		map.put("white", 9);
		for(int i = 0; i < 10; i++) {
			resist[i][0] = i;
			resist[i][1] = (int) Math.pow(10, i);
		}
		
		long ans = 0;
		ans  += 10 * resist[map.get(br.readLine())][0];
		ans  += resist[map.get(br.readLine())][0];
		ans *= resist[map.get(br.readLine())][1];
		System.out.println(ans);
		br.close();
	}

}

