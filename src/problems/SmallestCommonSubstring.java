package problems;

/**
 * Created by Sasanka on 6/9/2015.
 */
// Given a string, find the smallest substring from the string that contains all the characters in another given string
// Example: Given (aabbcdeffjaabc12abbc, abbc), print abbc, not aabbc or 12abbc.

public class SmallestCommonSubstring {
    public static void main(String args[]) {
        SmallestCommonSubstring commonSubstring = new SmallestCommonSubstring();
        commonSubstring.smallestCommonSubstring("aabbcdeffjaabc12abbc", "abbc");
    }

    public void smallestCommonSubstring(String longString, String smallString) {
        int front = 0;
        int rear = 0;

        int minFront = 0;
        int minRear = 0;
        int minFinalLength = longString.length();
        int charactersMatched = 0;

        int[] longArray = new int[128];
        int[] smallArray = new int[128];

        for (int i = 0; i < smallString.length(); i++) {
            smallArray[smallString.charAt(i)]++;
        }
        for (int i = 0; i < longString.length(); i++) {
            Character currentChar = longString.charAt(i);
            longArray[currentChar]++;
            if (smallArray[currentChar] != 0 && longArray[currentChar] <= smallArray[currentChar]) {
                charactersMatched++;
            }

            if (charactersMatched == smallString.length()) {
                rear = i;
                for (int j = front; j < rear; j++) {
                    if (smallArray[longString.charAt(j)] == 0) {
                        front++;
                    } else {
                        if (longArray[longString.charAt(j)] > smallArray[longString.charAt(j)]) {
                            front++;
                            longArray[longString.charAt(j)]--;
                        } else {
                            break;
                        }
                    }
                }

                if ((rear + 1 - front) < minFinalLength) {
                    minFinalLength = (rear + 1 - front);
                    minFront = front;
                    minRear = rear;
                }
            }
        }
        System.out.println("longString.substring(minFront, minRear) = " + longString.substring(minFront, minRear + 1));
        System.out.println("string = " + longString.substring(front, rear + 1));


    }

}
