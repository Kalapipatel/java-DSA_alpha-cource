package Sliding_Window_and_Two_pointer;

public class Max_Consecutive_Ones {
    public static int max1(int arr[], int k) {
        int ans = 0;
        int l = 0;
        int r = 0;
        int zero = 0;

        while (r < arr.length && l <= r) {
            if (arr[r] == 0) {
                zero++;
            }

            while (zero > k) {
                if (arr[l] == 0)
                    zero--;
                l++;
            }

            if (zero <= k) {
                ans = Math.max(ans, r - l + 1);
                r++;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0 };
        int arr2[] = { 1, 1, 1, 1, 0, 0 };

        System.out.println(max1(arr, 2));
        System.out.println(max1(arr2, 1));
    }
}
