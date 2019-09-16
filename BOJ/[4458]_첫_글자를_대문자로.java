import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    input.nextLine();
    for(int i = 0; i < n; i++){
      String line = input.nextLine();
      for(int j = 0; j < line.length(); j++){
        char ch = line.charAt(j);
        if(j == 0){
          if('a' <= ch && ch <= 'z'){
            ch += 'A'-'a';
          }
        }
        System.out.print(ch);
      }
      System.out.println();
    }
    input.close();
  }
}
