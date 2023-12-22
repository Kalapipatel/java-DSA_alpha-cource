package Heaps;

import java.util.*;

public class PQ_in_JCF {
    public static void main(String args[]) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.add(3);
        pq.add(4);
        pq.add(1);
        pq.add(7);

        while (!pq.isEmpty()) {
            System.out.println(pq.peek());
            pq.remove();
        }

        System.out.println("print in reverse order");
        PriorityQueue<Integer> pq2 = new PriorityQueue<>(Comparator.reverseOrder());

        pq2.add(3);
        pq2.add(4);
        pq2.add(1);
        pq2.add(7);

        while (!pq2.isEmpty()) {
            System.out.println(pq2.peek());
            pq2.remove();
        }
    }
}
