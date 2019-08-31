import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int nChairs = Integer.parseInt(br.readLine());
		int scores[] = new int[nChairs];
		int d[] = new int[nChairs]; //i번째 계단으로 가는 가장 많은 점수
		
		for(int i = 0; i < nChairs; i++) {
			scores[i] = Integer.parseInt(br.readLine());
		}
		
		d[0] = scores[0];
		d[1] = d[0] + scores[1];
		d[2] = Math.max(d[0] + scores[2],  scores[1] + scores[2]);
		
		for(int i = 3; i < nChairs; i++) {
			d[i] = Math.max(d[i-2] + scores[i], d[i-3] + scores[i-1] + scores[i]);
		}
		
		System.out.println(d[nChairs-1]);
		
		
		
		br.close();
	}
}

