import java.util.*;

public class Q2UniqueSum {

    //returns list of list with the combinations
    public static List<List<Integer>> uniqueSum(int[] arr, int target) {

        List<List<Integer>> result = new ArrayList<>();

        //sort the array to avoid duplicates
        Arrays.sort(arr);
        backTrack(arr, target, 0, new ArrayList<>(), result);
        return result;
    }


    //implement backtracking to get unique combinations
    private static void backTrack(int[] numbers, int target, int start,
                                  List<Integer> current, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        //travers through the array
        for (int i = start; i < numbers.length; i++) {

            // Skip duplicates
            if (i > start && numbers[i] == numbers[i - 1]) continue;

            //if number is greater than target stop
            if (numbers[i] > target) break;

            current.add(numbers[i]);
            backTrack(numbers, target - numbers[i], i + 1, current, result);
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {

        int[] arr = {5, 1, 3, 7, 9, 2}; //sample array
        int target = 14; //target

        List<List<Integer>> lists = uniqueSum(arr, target);

        System.out.println("Number of unique sets: " + lists.size());
        System.out.println("Array elements that sum to " + target + ":");
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }

}
