import java.util.Arrays;
import java.util.Scanner;

class MyString implements Comparable {
	
	String string = null;
	public MyString(String string) {
		this.string = string;
	}
	@Override
	public int compareTo(Object o) {
		MyString other = (MyString) o;
		if(this.string.length() > other.string.length()) {
			return 1;
		} else if(this.string.length() == other.string.length()) {
			return this.string.compareTo(other.string);
		} else {
			return -1;
		}
		
	}
}

public class Main {
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		input.nextLine();
		MyString[] string_array  = new MyString[n];
		
		for(int i = 0; i < n; i++) {
			string_array[i] = new MyString(input.nextLine());
		}
		
		Arrays.sort(string_array);
		
		for(int i = 0; i < n; i++) {
			if(i != 0 && string_array[i].string.equals(string_array[i-1].string))
				continue;
			System.out.println(string_array[i].string);
		}
		
		input.close();
		
	}

}
