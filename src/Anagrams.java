import java.util.HashMap;
import java.util.Map;

/**
 * Created by sasanka on 6/21/15.
 */
public class Anagrams {

    public static void main(String args[]) {
        System.out.println(areAnagrams("abcde", "ebcda"));
    }

    public static boolean areAnagrams(String string1, String string2) {
        Map<Character, Integer> map1 = new HashMap<>();

        for (Character c : string1.toCharArray()) {
            if (map1.containsKey(c)) {
                map1.put(c, map1.get(c)+1);
            }

            map1.putIfAbsent(c, 1);
        }


        for (Character c : string2.toCharArray()) {
            if (map1.containsKey(c)) {
                map1.put(c, map1.get(c) - 1);
            }
            else{
                return false;
            }
        }

        for (Map.Entry<Character, Integer> entry : map1.entrySet()) {
            if (entry.getValue() != 0) {
                return false;
            }
        }

        return true;

    }

}
