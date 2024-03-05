import java.lang.reflect.Array;
import java.util.*;

class rough1 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();
        ArrayList<Boolean> list3 = new ArrayList<>();

        // Top add any element in the arraylist
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        System.out.println(list);
        System.out.println(list2);
        System.out.println(list3);

        // Get operation
        int a = list.get(1);
        int b = list.get(3);
        System.out.println(a + " " + b);

        // Remove element from the index
        list.remove(2);
        System.out.println(list);

        //Set element at index
        list.set(2,10);
        System.out.println(list);

        // Contains element
        System.out.println(list.contains(1));
        System.out.println(list.contains(11));

        //also we can add element at any index by this comand
        list.add(1,10);
        System.out.println(list);

        //size of arraylist
        System.out.println(list.size());
    }
}
