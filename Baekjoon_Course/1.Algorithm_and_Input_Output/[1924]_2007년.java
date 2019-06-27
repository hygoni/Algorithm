import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int month = input.nextInt();
		int day = input.nextInt();
		int days_total = 0;
		
		for(int i = 1; i < month; i++) {
			switch(i) {
			case 4: case 6: case 9: case 11:
				days_total += 30;
				break;
			case 2:
				days_total += 28;
				break;
			default:
				days_total += 31;
				break;
			}
		}

		days_total += day;
		days_total -= 1;
		int rest = days_total % 7;
		
		switch(rest) {
		case 0:
			System.out.println("MON");
			break;
		case 1:
			System.out.println("TUE");
			break;
		case 2:
			System.out.println("WED");
			break;
		case 3:
			System.out.println("THU");
			break;
		case 4:
			System.out.println("FRI");
			break;
		case 5:
			System.out.println("SAT");
			break;
		case 6:
			System.out.println("SUN");
			break;
		}
	}
}
