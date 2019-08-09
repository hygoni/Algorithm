import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

class Number implements Comparable {
   long num = 0L;
   int count = 0;
   public Number(long num, int count) {
      this.num = num;
      this.count = count;
   }
   @Override
   public int compareTo(Object o) {
      Number other = (Number) o;
      if(this.count < other.count) {
         return 1;
      } else if (this.count == other.count) {
         if(this.num < other.num)
        	 return -1;
         else if(this.num == other.num)
        	 return 0;
         else
        	 return 1;
      } else {
         return -1;
      }
   }
   
   
}


public class Main {
   
   
public static void main(String[] args) throws NumberFormatException, IOException {
         

      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
      int n = Integer.parseInt(br.readLine());
      long[] num = new long[n];
      
      for(int i = 0; i < n; i++) {
         num[i] = Long.parseLong(br.readLine());
      }
      
      Arrays.sort(num);
      
      ArrayList<Number> countList = new ArrayList<Number>();
      long number = num[0];
      int count = 1;
      
      if(n == 1) {
         countList.add(new Number(number, count));
      }
      for(int i = 1; i < n; i++) {
         if(num[i] == number) {
            count++;
            if(i == n-1) {
               countList.add(new Number(number, count));
            }
         } else if(num[i] != number) {
            if(i == n-1) {
               countList.add(new Number(number, count));
               countList.add(new Number(num[i], 1));
            } else {
               countList.add(new Number(number, count));
               number = num[i];
               count = 1;
            }

         }
      }
      
      Collections.sort(countList);
      System.out.println(countList.get(0).num);
      
       	
      br.close();
      bw.close();
      
  }

}
