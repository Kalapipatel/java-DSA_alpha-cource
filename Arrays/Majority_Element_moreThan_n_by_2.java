package Arrays;

public class Majority_Element_moreThan_n_by_2 {
    public static int majorityElement(int arr[]) {
        int cnt = 0;
        int el = -1;

        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (cnt == 0) {
                cnt = 1;
                el = arr[i];
            } else if (el == arr[i])
                cnt++;
            else
                cnt--;
        }

        int c = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == el)
                c++;
        }

        if (c > (n / 2)) {
            return el;
        } else
            return -1;
    }

    public static void main(String agrs[]) {
        int arr[] = { 2, 2, 1, 1, 1, 2, 2 };
        System.out.println(majorityElement(arr));
    }
}
