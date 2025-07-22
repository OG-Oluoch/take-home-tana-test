import java.util.HashSet;

public class Q1GetLongestString {

    public static String longestString(String data) {

        //use slinding window approach
        int start = 0; //start pointer
        int end = 0;  //end pointer

        int dataLength = 0; //length of the string/characters
        int dataStart = 0; //start index of string


        //store the unique values in hashset
        HashSet<Character> seen = new HashSet<>();

        //traverse elements using sliding approach
        while (end < data.length()) {
            char currentChar = data.charAt(end);

            // If character not in data, add it and move end pointer
            if (!seen.contains(currentChar)) {
                seen.add(currentChar);
                end++;

                // Update the dataLength
                if (end - start > dataLength) {
                    dataLength = end - start;
                    dataStart = start;
                }
            } else {
                // If duplicate found, remove from start
                seen.remove(data.charAt(start));
                start++;
            }
        }

        return data.substring(dataStart, dataStart + dataLength);
    }


    public static void main(String[] args) {
        String randomString = "ghijkkihiigh";
        System.out.println(randomString);
        String answer = longestString(randomString);
        System.out.println("Longest substring without repetition - "+ answer );
    }

}
