import java.io.*;
import java.util.*;

public class Main {

    static int priority(char op) {
        if (op == '+' || op == '-') return 1;
        if (op == '*' || op == '/') return 2;
        return 0; // '('
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);

            // 피연산자
            if (ch >= 'A' && ch <= 'Z') {
                sb.append(ch);
            }
            // 여는 괄호
            else if (ch == '(') {
                stack.push(ch);
            }
            // 닫는 괄호
            else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    sb.append(stack.pop());
                }
                stack.pop(); // '(' 제거
            }
            // 연산자
            else {
                while (!stack.isEmpty() && priority(stack.peek()) >= priority(ch)) {
                    sb.append(stack.pop());
                }
                stack.push(ch);
            }
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        System.out.println(sb);
    }
}