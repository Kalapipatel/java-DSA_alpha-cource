package Heaps;

import java.util.*;

public class Insert {
    static class Heap {
        ArrayList<Integer> arr = new ArrayList<>();

        public void add(int data) {
            // add at last index
            arr.add(data);

            int x = arr.size() - 1; // x is child idx
            int par = (x - 1) / 2; // par idx

            while (arr.get(x) < arr.get(par)) {
                int temp = arr.get(x);
                arr.set(x, arr.get(par));
                arr.set(par, temp);

                x = par;
                par = (x - 1) / 2;

            }
        }

        public int peek() {
            return arr.get(0);
        }
    }

    public static void main(String args[]) {
        Heap h = new Heap();
        h.add(2);
        h.add(3);
        h.add(4);
        h.add(5);
        h.add(10);
        h.add(1);

        System.out.println("---");
        System.out.println(h.peek());
        System.out.println("---");

        for (int i = 0; i <= h.arr.size() - 1; i++) {
            System.out.println(h.arr.get(i));
        }
    }
}
