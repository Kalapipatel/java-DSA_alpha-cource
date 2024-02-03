package Heaps;

import java.util.*;

public class Q4_Sliding_Window {
    static class Info implements Comparable<Info> {
        int val;
        int idx;

        public Info(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }

        @Override
        public int compareTo(Info i2) {
            // descending
            return i2.val - this.val;
        }
    }

    public static void main(String args[]) {
        int arr[] = { 1, 3, -1, -3, 5, 3, 6, 7 };
        int k = 3;

        int res[] = new int[arr.length - k + 1]; // n-k+1
        PriorityQueue<Info> pq = new PriorityQueue<>();

        for (int i = 0; i < k; i++) {
            pq.add(new Info(arr[i], i));
        }
        res[0] = pq.peek().val;

        for (int i = k; i < arr.length; i++) {
            while (pq.peek().idx <= (i - k) && pq.size() > 0) {
                pq.remove();
            }
            pq.add(new Info(arr[i], i));
            res[i - k + 1] = pq.peek().val;
        }

        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }

    }
}
