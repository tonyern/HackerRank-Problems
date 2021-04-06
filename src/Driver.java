import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Driver {
    /**
     * Brute force attempt. Not very efficient performance and memory wise.
     * @param ar Array to find number of number pairs.
     * @return All number pairs.
     */
    static int sockMerchant(int[] ar) {
        int numberOfPairs = 0;

        // Sort ar to help with runtime.
        Arrays.sort(ar);
        // Use the largest number as the size to loop through.
        int[] sockCloset = new int[ar[ar.length - 1] + 1];

        // Count and track all types of socks.
        for (int i = 0; i < ar.length; i++) {
            sockCloset[ar[i]]++;
        }

        // Brute force method.
        for (int i = 0; i < sockCloset.length; i++) {
            if (sockCloset[i] != 1) {
                if (sockCloset[i] % 2 == 0) {
                    numberOfPairs += sockCloset[i] / 2;
                }
                if (sockCloset[i] % 2 != 0) {
                    sockCloset[i]--;
                    numberOfPairs += sockCloset[i] / 2;
                }
            }
        }

        return numberOfPairs;
    }

    /**
     * A more efficient way to solve sockMerchant problem.
     * @param ar Array to find number of number pairs.
     * @return All number pairs.
     */
    static int efficientSockMerchant(int[] ar) {
        int numberOfPairs = 0;
        Map<Integer, Integer> sockCloset = new HashMap<>();

        for (int i: ar) {
            if (!sockCloset.containsKey(i)) {
                sockCloset.put(i, 1);
            } else {
                sockCloset.put(i, sockCloset.get(i) + 1);
            }
        }

        for (int i: sockCloset.keySet()) {
            if (sockCloset.get(i) != 1) {
                if (sockCloset.get(i) % 2 == 0) {
                    numberOfPairs += sockCloset.get(i) / 2;
                } else {
                    numberOfPairs += (sockCloset.get(i) - 1) / 2;
                }
            }
        }

        return numberOfPairs;
    }

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

    static int hashedEqualizeArray(int[] arr) {
        Map<Integer, Integer> tracker = new HashMap<>();
        int highestNumber = 1;

        for (int i: arr) {
            if (!tracker.containsKey(i)) {
                tracker.put(i, 1);
            } else {
                tracker.put(i, tracker.get(i) + 1);
                if (highestNumber < tracker.get(i)) {
                    highestNumber = tracker.get(i);
                }
            }
        }

        return arr.length - highestNumber;
    }

    public static void main(String[] args) {
        //int[] test = {10, 27, 9, 10, 100, 38, 30, 32, 45, 29, 27, 29, 32, 38, 32, 38, 14, 38, 29, 30, 63, 29, 63, 91, 54, 10, 63};
        //int[] test = {51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51};
        //System.out.println(equalizeArray(test));

        int[] test = {1, 2, 1, 2, 1, 3, 2};
        System.out.println(efficientSockMerchant(test));
    }
}
