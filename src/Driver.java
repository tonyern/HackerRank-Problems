import java.util.*;

public class Driver {
    static boolean isPalindrome(int number) {
        // Negative numbers cannot be palindromes.
        if (number < 0) {
            return false;
        }

        String numberString = String.valueOf(number);
        char[] n1 = new char[numberString.length()];
        char[] n2 = new char[numberString.length()];

        for (int i = 0; i < numberString.length(); i++) {
            n1[i] = numberString.charAt(i);
        }
        for (int i = numberString.length() - 1; i >= 0; i--) {
            n2[i] = numberString.charAt(i);
        }

        for (int i = 0; i < numberString.length(); i++) {
            if (n1[i] != n2[i]) {
                return false;
            }
        }

        return true;
    }

    static int[] everyThirds(int[] arr) {
        //System.out.println("New Size = " + (int) Math.floor(arr.length / 3));
        int[] newArr = new int[(int) Math.floor((arr.length / 3))];

        int newArrIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if ((i + 1) % 3 == 0) {
                newArr[newArrIndex++] = arr[i];
            }
        }

        return newArr;
    }

    // Complete the whatFlavors function below.
    static void whatFlavors(int[] cost, int money) {
        Map<Integer, Integer> flavors = new HashMap<>();

        for (int i = 0; i < cost.length; i++) {
            if (!flavors.containsKey(cost[i])) {
                flavors.put(money - cost[i], i + 1);
            } else {
                System.out.println(flavors.get(cost[i]) + " " + (i + 1));
            }
        }
    }

    static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
        List<Integer> scores = new ArrayList<>();
        int aScore = 0;
        int bScore = 0;

        for (int i = 0; i < a.size(); i++) {
            if (a.get(i) > b.get(i)) {
                aScore++;
            }
            if (a.get(i) < b.get(i)) {
                bScore++;
            }
        }

        scores.add(0, aScore);
        scores.add(1, bScore);
        return scores;
    }

    static int findMissingNumber(int[] ar) {
        // Sort as we assume ar isn't sorted.
        Arrays.sort(ar);

        // Since it is missing then that spot would be sorted to 0 index.
        int missingNumber = ar[0];

        int counter = 0;
        for (int i = 1; i < ar.length; i++) {
            System.out.println("Counter = " + counter);
            if (ar[i] != counter) {
                missingNumber = counter;
                break;
            }
            counter++;
        }

        return missingNumber;
    }

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

        for (int i = 1; i < arr.length; i++) {
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
        System.out.println("Test Environment");
        /*int[] test = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        int[] testing = everyThirds(test);
        for (int i: testing) {
            System.out.println(i);
        }*/

        System.out.println(isPalindrome(121));
    }
}
