import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] coins = new int[n]; //코인의 가격을 저장하는 배열
		int maxIdx = 0; //k를 만드는 데에 사용 가능한 가장 비싼 동전
		int cnt = 0; //동전 사용하는 최소 횟수
		
		for(int i = 0; i < n; i++) {
			int coinValue = Integer.parseInt(br.readLine());
			if((coinValue <= k) && (coins[maxIdx] < coinValue)) {
				maxIdx = i;
			}
			coins[i] = coinValue;
		}
		
		for(int i = maxIdx; (i >= 0) && (k > 0); i--) { //비싼것부터 싼 것 순서대로
			int amount = (k / coins[i]); //동전의 사용 횟수
			cnt += amount;
			k -= coins[i] * amount; 
		}
		
		System.out.println(cnt);
		br.close();
	}
}

