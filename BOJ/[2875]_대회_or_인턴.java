import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int girls = Integer.parseInt(st.nextToken());
		int boys = Integer.parseInt(st.nextToken());
		int interns = Integer.parseInt(st.nextToken());
		
		while(interns > 0) {
			if(girls / 2 > boys) {
				girls--;
			} else if(girls / 2 < boys) {
				boys--;
			} else {
				girls--;
			}
			interns--;
		}
		System.out.println(Math.min(girls / 2, boys));
		br.close();
	}
}

