import java.util.Arrays;

public class Driver {
    /**
     * Finds the highest occurrence number in an array.
     * Size of array can be from 1 to 100.
     * Contents can be from 1 to 100.
     * @param arr Array of numbers
     * @return Min number of deletions to keep highest occurrence in array
     */
    static int equalizeArray(int[] arr) {
        int minDeletions = 0;

        Arrays.sort(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("");

        // Creates an array of length of the highest number.
        // Use to help determine most occurring number.
        int[] trackOccurrences = new int[arr[arr.length - 1] + 1];
        for (int i = 0; i < arr.length; i++) {
            trackOccurrences[arr[i]]++;
        }

        int highestNumber = trackOccurrences[0];
        for (int i = 1; i < trackOccurrences.length; i++) {
            if (highestNumber < trackOccurrences[i]) {
                highestNumber = trackOccurrences[i];
            }
        }

        System.out.println("Highest = " + highestNumber);

        // If there are no repeating values. Delete all but one.
        if (highestNumber == 1) {
            return arr.length - 1;
        }

        for (int i = 0; i < trackOccurrences.length; i++) {
            if (trackOccurrences[i] != highestNumber) {
                minDeletions += trackOccurrences[i];
            }
        }

        return minDeletions;
    }

    public static void main(String[] args) {
        int[] test = {10, 27, 9, 10, 100, 38, 30, 32, 45, 29, 27, 29, 32, 38, 32, 38, 14, 38, 29, 30, 63, 29, 63, 91, 54, 10, 63};
        //int[] test = {51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51};
        System.out.println(equalizeArray(test));
    }
}
