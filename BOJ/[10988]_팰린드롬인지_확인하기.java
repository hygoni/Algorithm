import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static boolean isPalindrome(String word, int s, int e){
        if(s == e){
            return true;
        } else if(s + 1 == e){
            return word.charAt(s) == word.charAt(e);
        } else {
            return word.charAt(s) == word.charAt(e) && isPalindrome(word, s+1, e-1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        System.out.println(isPalindrome(word, 0, word.length()-1) ? 1 : 0);
        br.close();
    }
}


