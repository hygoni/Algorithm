import java.util.Scanner;

public class Main {

	public static void main(String[] args) {	 
		Scanner input = new Scanner(System.in);
		int T = input.nextInt();
		for(int t = 0; t < T; t++) {
			int x1 = input.nextInt();
			int y1 = input.nextInt();
			int r1 = input.nextInt();
			int x2 = input.nextInt();
			int y2 = input.nextInt();
			int r2 = input.nextInt();
			
			int d = (x1-x2) * (x1-x2) + (y1-y2) * (y1-y2);
			int rMinus = (r1-r2) * (r1-r2);
			int rPlus = (r1+r2) * (r1+r2);
			
			//두 원이 일치
			boolean sameCircle = (x1 == x2) && (y1 == y2) && (r1 == r2); 
			//원이 포함되면서 안 만남
			boolean subCircle = (d < rMinus);
			//내접
			boolean inscribed = (rPlus == d);
			//외접
			boolean circumscribed = (rMinus == d);
			//원이 외부에 있음
			boolean outside = (rPlus < d);
			//원이 두 점에서 만남
			boolean twoDots = (rMinus < d) && (d < rPlus);
			
			if(sameCircle) {
				System.out.println(-1);
			} else if(twoDots) {
				System.out.println(2);
			} else if(inscribed || circumscribed) {
				System.out.println(1);
			} else if(outside || subCircle) {
				System.out.println(0);
			}
		}
		input.close();
	}
}

