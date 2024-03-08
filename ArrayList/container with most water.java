import java.util.*;

class rough1 {

    public static void brutForce(ArrayList<Integer> list) {
        // Tc = O(n^2)
        int max = 0;
        int w, h;
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                w = j - i;
                h = Math.min(list.get(i), list.get(j));

                max = Math.max(w * h, max);
            }
        }
        System.out.println(max);
    }

    public static int optmized(ArrayList<Integer> list) {
        // Tc = O(n)
        int max = 0;
        int lp = 0;
        int rp = list.size() - 1;

        while (lp < rp) {
            int h = Math.min(list.get(lp), list.get(rp));
            int w = rp - lp;
            max = Math.max(max, w * h);

            // upgrade ptr
            if (list.get(lp) < list.get(rp)) {
                lp++;
            } else { // list.get(rp) <= list.get(lp)
                rp--;
            }
        }
        return max;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.print("enter the number you want to enter : ");
        ArrayList<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(8);
        list.add(6);
        list.add(2);
        list.add(5);
        list.add(4);
        list.add(8);
        list.add(3);
        list.add(7);
        // int n = sc.nextInt();
        // for (int i = 0; i < n; i++) {
        // int temp = sc.nextInt();
        // list.add(temp);
        // }

        brutForce(list);
        System.out.println(optmized(list));

    }
}
