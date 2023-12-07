package Stacks;

import java.util.*;

public class Q1_push_at_bottom {
    public static void at_bottom(Stack<Integer> s, int data) {
        if (s.isEmpty()) {
            s.push(data);
            return;
        }

        int top = s.pop();
        at_bottom(s, data);
        s.push(top);
    }

    public static void main(String args[]) {
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        at_bottom(s, 4);

        while (!s.isEmpty()) {
            System.out.println(s.pop());
        }
    }
}