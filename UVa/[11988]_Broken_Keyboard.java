import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.LinkedList;

//Type of problem : List
//Time Complexity : O(N)

public class Main {

        public static void main(String[] args) throws IOException {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
                
                String line = br.readLine();
                while(line != null) {
                	LinkedList<StringBuilder> list = new LinkedList<StringBuilder>();
                    StringBuilder write = new StringBuilder();
                    StringBuilder here = write;
                    list.add(write);
                    for(int i = 0; i < line.length(); i++) {
                           char ch = line.charAt(i);
                           if(ch == '[') {
                               write = new StringBuilder();
                               list.addFirst(write);
                               here = write;
                          } else if(ch == ']') {
                        	 write = new StringBuilder();
                                	list.add(write);
                                	here = write;
                                } else {
                                        here.append(ch);
                                }
                        }

                        Iterator<StringBuilder> iter = list.iterator();
                        
                        while(iter.hasNext()) {
                        	bw.write(iter.next() + "");
                        }
                        
                        bw.write("\n"); 
                        bw.flush();

                        line = br.readLine();
                }

                br.close();
                bw.close();
        }
}

