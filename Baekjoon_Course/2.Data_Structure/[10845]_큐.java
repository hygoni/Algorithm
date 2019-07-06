import java.util.*;
import java.util.Scanner;
import java.math.*;
class Queue {
	
	int array[];
	int front = 0;
	int back = 0;
	
	public Queue(int size){
		this.array = new int[size];
	}
	public int pop(){
		int retValue = array[front];
		front += 1;
		return retValue;
	}
	public void push(int x){
		array[back] = x;
		back += 1;
	}
	public int front(){return array[front];}
	public int back(){return array[back-1];}
	public int size(){return Math.abs(front-back);}
	public boolean isEmpty(){return Math.abs(front-back) == 0;}
	
}

public class Main {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		input.nextLine();
		Queue q = new Queue(n);
		
		for(int i = 0; i < n; i++){
			String cmd = input.next();
			switch(cmd){
			case "push":
				int x = input.nextInt();
				input.nextLine();
				q.push(x);
				break;
			case "pop":
				if(q.isEmpty())
					System.out.println(-1);
				else
					System.out.println(q.pop());
				break;
			case "size":
				System.out.println(q.size());
				break;
			case "empty":
				System.out.println(q.isEmpty() ? 1 : 0);
				break;
			case "front":
				if(q.isEmpty())
					System.out.println(-1);
				else
					System.out.println(q.front());
				break;
			case "back":
				if(q.isEmpty())
					System.out.println(-1);
				else
					System.out.println(q.back());
				break;
			}
		}
		
		
	}
}

