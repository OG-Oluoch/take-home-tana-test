import java.util.LinkedHashMap;
import java.util.Map;

public class Q4UniqueElement {

    public static String uniqueWord(String[] arrays) {

        // store string frequencies, maintains insertion order
        Map<String, Integer> wordCount = new LinkedHashMap<>();

        // count the occurrences of each string in the array
        for (String arr : arrays) {
            wordCount.put(arr, wordCount.getOrDefault(arr, 0) + 1);
        }

        //Traverse to find string with count 1
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }

        // return null if there is no unique string
        return null;
    }


    public static void main(String[] args) {
        String[] array = {"car", "job", "key", "job", "car"};
        String result = uniqueWord(array);
        System.out.println("The first unique word is: " + result);
    }
}
