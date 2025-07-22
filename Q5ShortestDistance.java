public class Q5ShortestDistance {

    public static int minDistance(int[] a) {

        // find minimum value
        int min = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] < min) {
                min = a[i];
            }
        }

        // find minimum distance
        int minDist = a.length;
        int prevIndex = -a.length;


        //find all occurences of minimum value
        for (int i = 0; i < a.length; i++) {
            if (a[i] == min) {
                if (prevIndex >= 0) {
                    int currentDistance = i - prevIndex;
                    minDist = Math.min(minDist, currentDistance);
                }
                prevIndex = i;
            }
        }

        return minDist;
    }

    public static void main(String[] args) {

        // sample array
        int[] array = {4, 2, 1, 3, 1, 5, 1};
        System.out.println("Distance between closest minimums: " + minDistance(array));
    }
}
