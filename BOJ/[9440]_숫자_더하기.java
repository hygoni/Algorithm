import java.util.*;


public class Main {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		while(true) {
			String num1 = "", num2 = "";
			int n = input.nextInt();
			if(n == 0)
				break;
			
			int zero = 0;
			LinkedList<Integer> arr = new LinkedList<>();
			for(int p = 0; p < n; p++) {
				int num = input.nextInt();
				arr.add(num);
				if(num == 0) {
					zero++;
				}
			}
			Collections.sort(arr);
			
			for(int i = 0; i < zero; i++) {
				arr.add(zero+2, arr.peek());
				arr.poll();
			}

			for(int j = 0; j < arr.size(); j++) {
				if(j % 2 == 0)  {
					num1 += arr.get(j);
				}
				if(j % 2 == 1) {
					num2 += arr.get(j);
				}
			}
			
			System.out.println(Integer.parseInt(num1) + Integer.parseInt(num2));
		}

	}

}
