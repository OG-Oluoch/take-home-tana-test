
public class Q3DeductArray {


    public static int canMakeZeroExceptFirst(int[] arr) {
        if (arr == null || arr.length <= 1) return 1;

        // Create a copy to avoid modifying the original array
        int[] temp = arr.clone();
        int n = temp.length;

        // Work backwards, simulating reverse operations
        for (int i = n - 1; i > 0; i--) {
            // Try to make temp[i] zero by adding it to temp[i-1]
            if (i > 1) {
                temp[i-1] += temp[i];
            } else {
                // At i=1, we just need temp[1] to be reducible to 0 using temp[0]
                // Check if temp[1] can be made 0 by subtracting temp[0] some number of times
                if (temp[1] % temp[0] != 0 || temp[1] < 0) {
                    return 0;
                }
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3}; // Your example
        int[] arr2 = {1, 1, 1}; // Not possible
        System.out.println(canMakeZeroExceptFirst(arr1)); // Output: 1
        System.out.println(canMakeZeroExceptFirst(arr2)); // Output: 0
    }

}
