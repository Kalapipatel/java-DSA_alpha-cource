package Stacks;

import java.util.Stack;

public class Q8_infix_prefix {
    // A utility function to return
    // precedence of a given operator
    // Higher returned value means
    // higher precedence
    static int Prec(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;

            case '*':
            case '/':
                return 2;

            case '^':
                return 3;
        }
        return -1;
    }

    public static String reverse(String s) {
        Stack<Character> st = new Stack<>();
        String ans = new String();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            st.push(c);
        }

        while (!st.isEmpty()) {
            ans += st.pop();
        }

        return ans;
    }

    static String infixToPostfix(String str) {
        System.out.println("string is = " + str);
        String result = new String("");
        String exp = reverse(str);
        System.out.println("reverse of str is = " + exp);

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < exp.length(); ++i) {
            char c = exp.charAt(i);

            if (Character.isLetterOrDigit(c)) {
                result += c;
            } else if (c == ')') {
                stack.push(c);
            } else if (c == '(') {
                while (!stack.isEmpty() && stack.peek() != ')') {
                    result += stack.pop();
                }

                stack.pop();
            } else {
                while (!stack.isEmpty() && Prec(c) <= Prec(stack.peek())) {
                    result += stack.pop();
                }

                stack.push(c);
            }

        }
        while (!stack.isEmpty()) {
            if (stack.peek() == ')') {
                return "Invalid Expression";
            }

            result += stack.pop();
        }
        System.out.println("result = " + result);
        String ans = reverse(result);
        System.out.println("ans = " + ans);

        return ans;
    }

    // Driver method
    public static void main(String[] args) {
        String exp = "(a-b/c)*(a/k-l)";
        System.out.println("Infix expression: " + exp);
        System.out.println("Prefix expression: " + infixToPostfix(exp));
        // System.out.println(reverse(exp));
    }
}
