package problems;

import java.util.*;

/**
 * Created by sasanka on 6/21/15.
 */
public class GroupAnagramsTogether {

    public static void main(String args[]) {
        groupAnagrams(new String[]{"abcd", "efgh", "dbca", "dcba", "fghe"});
    }

    public static void groupAnagrams(String[] strings) {
        for (int i = 0; i < strings.length; i++) {
            char[] stringCharacters = strings[i].toCharArray();
            Arrays.sort(stringCharacters);

            strings[i] = String.valueOf(stringCharacters);
        }

        Map<String, Intervals.MyPair> groupMap = new TreeMap<>();
        for(int i=0;i<strings.length;i++) {
            if (groupMap.containsKey(strings[i])) {
                Intervals.MyPair currentPair = groupMap.get(strings[i]);
                groupMap.put(strings[i], new Intervals.MyPair(currentPair.getLeft(), currentPair.getRight() + 1));
            }
            else {
                groupMap.put(strings[i], new Intervals.MyPair(i, 1));
            }
        }

        List<String> finalList = new ArrayList<>();

        for (Map.Entry<String, Intervals.MyPair> entry : groupMap.entrySet()) {
            for (int i = 0; i < entry.getValue().getRight(); i++) {
                finalList.add(entry.getKey());
            }
        }

        System.out.println("finalList = " + finalList);
    }

}
