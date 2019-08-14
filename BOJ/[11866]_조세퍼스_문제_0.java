import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

//Type of problem : Queue
//Time Complexity : O(N)
public class Main {
	
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		Deque<Integer> survived = new LinkedList<Integer>();
		Deque<Integer> dead = new LinkedList<Integer>();
		int n = input.nextInt();
		int k = input.nextInt();
		
		for(int i = 0; i < n; i++) {
			survived.addLast(i+1);
		}
		
		int l = 1;
		while(survived.size() != 0) {
			if(l % k == 0) {
				dead.addLast(survived.pollFirst());
			} else {
				survived.addLast(survived.pollFirst());
			}
			l++;
		}
		
		int size = dead.size();
		for(int i = 0; i < size; i++) {
			if(i == 0)
				System.out.print("<");
			System.out.print(dead.pollFirst());
			if(i == size-1)
				System.out.println(">");
			else
				System.out.print(", ");
		}
		
		input.close();
	}
}

