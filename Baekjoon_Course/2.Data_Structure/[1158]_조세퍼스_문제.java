import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Queue people = new LinkedList();
		Queue dead = new LinkedList();
		
		int n = input.nextInt();
		int k = input.nextInt();
		
		for(int i = 0; i < n; i++) {
			people.add(i+1);
		}
		for(int i = 0; people.size() != 0; i++) {
			if(i % k == k-1) {
				dead.add(people.poll());
				continue;
			}
			people.add(people.poll());
		}

		int size = dead.size();
		for(int i = 0; i < size; i++) {
			if(i == 0)
				System.out.print("<");
			System.out.print(dead.poll());
			if(i == size-1)
				System.out.println(">");
			else
				System.out.print(", ");
		}
		
		input.close();
	}
}

