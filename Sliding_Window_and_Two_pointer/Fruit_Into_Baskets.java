package Sliding_Window_and_Two_pointer;

import java.util.HashMap;
import java.util.Map;

public class Fruit_Into_Baskets {
    public static int fruit(int arr[], int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        int l = 0, r = 0;

        while (r < arr.length) {
            if (map.containsKey(arr[r])) {
                map.put(arr[r], map.get(arr[r]) + 1);
            } else {
                map.put(arr[r], 1);
            }

            if (map.size() > k) {
                while (map.size() > k) {
                    map.put(arr[l], map.get(arr[l]) - 1);

                    if (map.get(arr[l]) == 0) {
                        map.remove(arr[l]);
                    }
                    l++;
                }
            } else {
                max = Math.max(max, r - l + 1);
            }
            r++;
        }

        return max;
    }

    public static void main(String args[]) {
        int arr[] = { 3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4 };

        System.out.println(fruit(arr, 2)); // 5
    }
}
