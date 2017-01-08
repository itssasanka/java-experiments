import java.util.*;

/**
 * Created by sasanka on 1/8/17.
 */

// Given a list that represents a non-negative number, get the number.
// Example: 2->3->6 yields the number 236.
public class ListToNumber {

    public static void main(String[] args) {
        ListToNumber l = new ListToNumber();
        l.listToNum(Arrays.asList(2, 3, 4,5,6,7,8));
    }


    public void listToNum(List<Integer> inputList) {
        Collections.reverse(inputList);
        ListIterator<Integer> iterator = inputList.listIterator();
        System.out.println(getNumber(iterator));
    }

    public int getNumber(ListIterator current) {

        int multiplier = 1;
        int total = 0;
        while (current.hasNext()) {
            int next = (Integer) current.next();
            total += (multiplier * next);
            multiplier = multiplier * 10;
        }
        return total;
    }


}



