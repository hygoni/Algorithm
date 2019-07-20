import java.util.Scanner;

public class Main {
	
	public static int getNearMaxAndTear(int[][] stickers, int x, int y) {
		
		/* 주변 최댓값 구하기 */
		
		int max_x = x;
		int max_y = y;
		int max = stickers[y][x];

		if(y == 1) {
			if(max < stickers[0][x]) {
				max = stickers[0][x];
				//max_x = x;
				max_y = 0;
			}
		} else {
			if(max < stickers[1][x]) {
				max = stickers[1][x];
				//max_x = x;
				max_y = 1;
			}
		}
		
		if( (x-1) > 0 ) {
			if(max < stickers[y][x-1]) {
				max = stickers[y][x-1];
				max_x = x-1;
				//max_y = y;
			}
		}
			
		if(x < stickers[y].length - 1) {
			max = stickers[y][x+1];
			max_x = x+1;
			//max_y = y;
		}

		/* 주변 스티커들 찢기 */
		
		if(y == 1) {
			stickers[0][max_x] = -1;
		} else {
			stickers[1][max_x] = -1;
		}
		
		if( (x-1) > 0 ) {
			stickers[max_y][max_x-1] = -1;
		}
			
		if(x < stickers[max_y].length - 1) {
			stickers[max_y][x+1] = -1;
		}
		
		return max;
		
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		
		int stickers[][] = new int[2][n];
		for(int i = 0; i < n; i++) {
			stickers[0][i] = input.nextInt();
		}
		for(int i = 0; i < n; i++) {
			stickers[1][i] = input.nextInt();
		}
		
		int sum = 0;

		for(int i = 0; i < n; i++) {
			int max = getNearMaxAndTear(stickers, i, 0);
			if(max >= 0)
				sum += max;
		}
		for(int i = 0; i < n; i++) {
			int max = getNearMaxAndTear(stickers, i, 1);
			if(max >= 0)
				sum += max;
		}

		
/*		//배열확인
		for(int i = 0; i < n; i++) {
			System.out.print(stickers[0][i] + " ");
		}
		System.out.println();
		for(int i = 0; i < n; i++) {
			System.out.print(stickers[1][i] + " ");
		}
*/
		System.out.println(sum);
		input.close();

	}


}
