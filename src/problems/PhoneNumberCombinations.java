package problems;

import java.util.*;

/**
 * Created by Sasanka on 8/13/2015.
 */
public class PhoneNumberCombinations {
    private static final Map<Integer, String> numberMap = new HashMap<>();

    public static void initializeMap() {
        numberMap.put(2, "abc");
        numberMap.put(3, "def");
        numberMap.put(4, "ghi");
        numberMap.put(5, "jkl");
        numberMap.put(6, "mno");
        numberMap.put(7, "pqrs");
        numberMap.put(8, "tuv");
        numberMap.put(9, "wxyz");
    }


    public static void main(String args[]) {
        initializeMap();
        parseNumber("234");
    }

    public static void parseNumber(String number) {
        List<Integer> integerList = new ArrayList<>();
        for (Character c : number.toCharArray()) {
            integerList.add(Character.getNumericValue(c));
        }
        parseNumber("", integerList.listIterator());
    }

    private static void parseNumber(String previousString, ListIterator<Integer> iterator) {
        if (iterator.hasNext()) {
            Integer currentNumber = iterator.next();
            for (Character c : numberMap.get(currentNumber).toCharArray()) {
                parseNumber(previousString + c, iterator);
            }
            iterator.previous();
        } else {
            System.out.println(previousString);
        }
    }

}
