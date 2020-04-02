import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String expr = br.readLine();
        br.close();
        Map<Character, Integer> priority = new HashMap<>();
        priority.put('(', 0);
        priority.put(')', 0);
        priority.put('*', 1);
        priority.put('/', 1);
        priority.put('+', 2);
        priority.put('-', 2);

        Deque<Character> stack = new LinkedList<>();
        for(int i = 0; i < expr.length(); i++) {
            char c = expr.charAt(i);
            if(Character.isAlphabetic(c)) {
                System.out.print(c);
            } else {
                if(stack.isEmpty()) {
                    stack.push(c);
                } else {
                    switch(c) {
                        case '(':
                            stack.push(c);
                            break;
                        case ')':
                            while (stack.peek() != '(') {
                                System.out.print(stack.pop());
                            }
                            stack.pop();
                            break;
                        default:
                            if(priority.get(c) >= priority.get(stack.peek())) {
                                while (!stack.isEmpty() && priority.get(stack.peek()) <= priority.get(c) && stack.peek() != '(') {
                                    System.out.print(stack.pop());
                                }
                                stack.push(c);
                            } else {
                                stack.push(c);
                            }
                            break;
                    }
                }
            }
        }
        while(!stack.isEmpty()) {
            System.out.print(stack.pop());
        }
    }
}
