import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sasanka on 6/7/15.
 */
//Given an array of numbers, find all pairs which yield a given sum
public class CommonSumPairs {

    public static void main(String arg[]) {
        //TODO sort the numbers first.

        int[] array = {0, 2, 3, 4, 5, 7, 9};
        CommonSumPairs commonSumPairs = new CommonSumPairs();
        List<Pair> pairs = commonSumPairs.findSumPairs(9, array);
        System.out.println("pairs = " + pairs);

    }

    public List<Pair> findSumPairs(int sum, int[] array) {
        int low = 0;
        int high = array.length - 1;
        List<Pair> resultList = new ArrayList<>();

        for (int i = low + 1; i <= high; i++) {

            if ((array[low] + array[i]) == sum) {
                resultList.add(new Pair<>(array[low], array[i]));
                high = i-1;
                i = ++low;
            }else if(i==high){
                i=++low;
            }
        }
        return resultList;
    }

}
