import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()) - 1;
        char s1[] = br.readLine().toCharArray();

        for(int i = 0; i < N; i++){
            char s2[] = br.readLine().toCharArray();
            for(int j = 0; j < s1.length; j++){
                if(s1[j] != s2[j]){
                    s1[j] = '?';
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s1.length; i++){
            sb.append(s1[i]);
        }
        System.out.println(sb);
        br.close();
    }
}
