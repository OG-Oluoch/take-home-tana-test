import java.util.*;

public class Q6RepeatedWords {

    public static List<String> getFrequency(String sentence) {
        // split sentence into words
        String[] words = sentence.split("\\s+");

        // count word frequencies
        Map<String, Integer> freqMap = new HashMap<>();
        for (String word : words) {
            freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
        }

        // sort the list
        List<Map.Entry<String, Integer>> sortedEntries = new ArrayList<>(freqMap.entrySet());
        sortedEntries.sort((a, b) -> {
            int freqCompare = b.getValue().compareTo(a.getValue());
            return freqCompare != 0 ? freqCompare : a.getKey().compareTo(b.getKey());
        });

        // get top 3 words
        List<String> topThree = new ArrayList<>();
        for (int i = 0; i < Math.min(3, sortedEntries.size()); i++) {
            topThree.add(sortedEntries.get(i).getKey());
        }

        // return result sorted alphabetically
        Collections.sort(topThree);
        return topThree;
    }

    public static void main(String[] args) {
        String data = "we could be there but we were not ready since the driver was also not ready";
        List<String> answer = getFrequency(data);
        System.out.println(answer); // [not,ready,we]
    }
}
