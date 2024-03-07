import java.util.*;

class rough1 {
    public static boolean monotonic(ArrayList<Integer> A) {
        boolean inc = true;
        boolean dec = true;
        for (int i = 0; i < A.size() - 1; i++) {
            if (A.get(i) > A.get(i + 1))
                inc = false;
            // System.out.println("loop1 : " + inc);
            if (A.get(i) < A.get(i + 1))
                dec = false;
            // System.out.println("loop2 : " + dec);
            // System.out.println("------");
        }

        // System.out.println();
        return inc || dec;

        // ----------------------------my code ---------------------
        // int n = list.size();

        // int a = n, d = n;
        // for (int i = 0; i < n - 1; i++) {
        // if (list.get(i) > list.get(i + 1)) {
        // a--;
        // }

        // if (list.get(i) < list.get(i + 1)) {
        // d--;
        // }
        // }

        // System.out.println(a);
        // System.out.println(d);
        // if (a == 1 || d == 1) {
        // return true;
        // } else {
        // return false;
        // }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(3);
        list.add(6);
        list.add(8);
        list.add(9);
        list.add(10);

        System.out.println(monotonic(list));

    }
}
