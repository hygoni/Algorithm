import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//Type of problem : Ad Hok

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		for(int i = 0; i < n; i++) {
			String line = br.readLine();
			StringTokenizer tokenizer = new StringTokenizer(line, " ");
			int k = Integer.parseInt(tokenizer.nextToken());
			int max = 0;
			for(int j = 0; j < k; j++) {
				int l = Integer.parseInt(tokenizer.nextToken());
				if(max < l)
					max = l;
			}
			bw.write(String.format("Case %d: %d\n", i+1, max));
			bw.flush();
		}
	}

}
