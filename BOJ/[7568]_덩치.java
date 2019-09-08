import java.util.Scanner;

class Man {
	int weight, height;
	public Man(int weight, int height) {
		this.weight = weight;
		this.height = height;
	}
	
}

public class Main {

	public static void main(String[] args) {	 
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		Man[] man = new Man[n];
		for(int i = 0; i < n; i++) {
			int weight = input.nextInt();
			int height = input.nextInt();
			man[i] = new Man(weight, height);
		}
		for(int i = 0; i < n; i++) {
			int biggerThanMe = 0;
			for(int j = 0; j < n; j++) {
				if(man[j].weight > man[i].weight && man[j].height > man[i].height) {
					biggerThanMe++;
				}
			}
			System.out.print(biggerThanMe+1 + " ");
		}
		input.close();
	}
}

