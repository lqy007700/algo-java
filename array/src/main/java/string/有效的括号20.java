package string;

import java.util.Stack;

public class 有效的括号20 {
    public static void main(String[] args) {
        有效的括号20 a = new 有效的括号20();
        System.out.println(a.isValid("(){}[]"));
        ;
    }

    /**
     * '('，')'，'{'，'}'，'['，']'
     *
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        char[] charArray = s.toCharArray();

        for (char c : charArray) {
            switch (c) {
                case '(':
                case '{':
                case '[':
                    stack.push(c);
                    break;
                case ')':
                    if (stack.isEmpty() || stack.pop() != '(') {
                        return false;
                    }
                    break;
                case '}':
                    if (stack.isEmpty() || stack.pop() != '{') {
                        return false;
                    }
                    break;
                case ']':
                    if (stack.isEmpty() || stack.pop() != '[') {
                        return false;
                    }
                    break;
            }
        }

        return stack.isEmpty();
    }
}
