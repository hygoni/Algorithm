import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
			
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int rest = 1000 - Integer.parseInt(br.readLine());
		int count = 0;
		
		while(rest != 0) {
			//System.out.println(rest + " : " + count);
			if(rest >= 500) {
				count += (int) rest / 500;
				rest = rest % 500;
			} else if(rest >= 100) {
				count += (int) rest / 100;
				rest = rest % 100;
			} else if(rest >= 50) {
				count += (int) rest / 50;
				rest = rest % 50;
			} else if(rest >= 10) {
				count += (int) rest / 10;
				rest = rest % 10;
			} else if(rest >= 5){
				count += (int) rest / 5;
				rest = rest % 5;				
			} else {
				count += (int) rest / 1;
				rest = rest % 1;
			}
		}
		
		bw.write(count + "");
		bw.flush(); //버퍼 비우기
		
		
	}

}
