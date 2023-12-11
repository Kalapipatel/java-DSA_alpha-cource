package Stacks;

import java.util.*;

public class Q7_Duplicate_parentheses {
    public static boolean duplicate(String str) {
        Stack<Character> s = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            int c = 0;

            if (ch != ')') {
                System.out.println("ch to be pushed : " + ch);
                s.push(ch);
            } else {
                while (s.peek() != '(') {
                    System.out.println("ch to be poped : " + s.peek());
                    s.pop();
                    c++;
                }
                System.out.println("count : " + c);
                if (c > 0) {
                    System.out.println("ch to be poped : " + ch);
                    s.pop();
                } else {
                    return false;
                }
            }

        }
        if (s.isEmpty()) {
            return true;
        } else {
            return false;
        }

    }

    public static void main(String args[]) {
        String str = "((a+b)+(c+d)+e)";
        String str2 = "((a+b)+((c+d))+e)";
        System.out.println(duplicate(str));
        System.out.println(duplicate(str2));
    }
}
