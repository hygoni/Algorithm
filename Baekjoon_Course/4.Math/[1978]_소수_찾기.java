import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	
	public static boolean isPrime(int n) {
		
		if(n == 1)
			return false;
		
		for(int i = 2; i*i <= n; i++) {
			if(n % i == 0)
				return false;
		}
		
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		int n_prime = 0;
		
		String line = br.readLine();
		String[] input_str = line.split(" ");
		int[] input = new int[input_str.length];	
		
		for(int i = 0; i < input_str.length; i++) {
			input[i] = Integer.parseInt(input_str[i]);
		}
		
		for(int i = 0; i < n; i++) {
			
			if(isPrime(input[i]))
				n_prime++;
		}
		
		bw.write(n_prime + "");
		bw.flush();
	}

}
