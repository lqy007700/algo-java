package array;

import java.util.Deque;
import java.util.LinkedList;

public class 逆波兰表达式求值150 {
    public static void main(String[] args) {


    }

    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new LinkedList<>();
        int n = tokens.length;

        for (String t : tokens) {
            if (isNumber(t)) {
                stack.push(Integer.parseInt(t));
            } else {
                int n2 = stack.pop();
                int n1 = stack.pop();

                switch (t) {
                    case "+":
                        stack.push(n1 + n2);
                        break;
                    case "-":
                        stack.push(n1 - n2);
                        break;
                    case "*":
                        stack.push(n1 * n2);
                        break;
                    case "/":
                        stack.push(n1 / n2);
                        break;
                    default:
                }
            }
        }
        return stack.pop();
    }

    private boolean isNumber(String token) {
        return !(token.equals("*") || token.equals("/") || token.equals("+") || token.equals("-"));
    }
}
