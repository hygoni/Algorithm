import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    long d[] = new long[116+1];
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    d[1] = d[2] = d[3] = 1;
    for(int i = 4; i <= n; i++){
      d[i] = d[i-1] + d[i-3];
    }
    System.out.println(d[n]);
  }
}
