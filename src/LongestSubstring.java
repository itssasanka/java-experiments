import java.util.*;

/**
 * Created by Sasanka on 5/31/2015.
 */
// Given a String, print the longest substring without repeating characters.
// Example: If you're given "abccccdefii12345", print "12345"

public class LongestSubstring {
    public static void main(String args[]) {
        LongestSubstring longestSubstring = new LongestSubstring();
        longestSubstring.longestString("abccccdefii12345");
    }

    public void longestString(String original) {
        List<Set<Character>> list = new ArrayList<>();
        Set<Character> set = new HashSet<>();
        boolean retainCheck = false;

        for (int i=0;i<original.length();i++) {
            if (i == original.length() - 1) {
                list.add(set);
            }
            if (set.contains(original.charAt(i))) {
                retainCheck = true;
            } else {
                if (retainCheck) {
                    list.add(set);
                    set = new HashSet<>();
                    retainCheck = false;
                }
                set.add(original.charAt(i));
            }
        }

        Set longestSet = list.get(0);
        for (Set<Character> set1 : list) {
            if (set1.size() > longestSet.size()) {
                longestSet = set1;
            }
        }

        System.out.println("The longest substring is " + longestSet);

    }
}
