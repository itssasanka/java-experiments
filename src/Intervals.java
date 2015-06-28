import javafx.util.Pair;

import java.util.*;

/**
 * Created by sasanka on 5/30/15.
 */

//Given intervals like 1..3, 4...5, 7..10, 7..9; output the total length of the non-overlapping interval periods
public class Intervals {

    public static class MyPair {
        private Integer left;
        private Integer right;

        public MyPair(Integer left, Integer right) {
            this.left = left;
            this.right = right;
        }

        public Integer getRight() {
            return right;
        }

        public Integer getLeft() {
            return left;
        }

        public void setLeft(Integer left) {
            this.left = left;
        }

        public void setRight(Integer right) {
            this.right = right;
        }
    }

    public static void main(String args[]) {
        Intervals intervals = new Intervals();
        MyPair p1 = new MyPair(1, 3);
        MyPair p2 = new MyPair(2, 5);
        MyPair p3 = new MyPair(5, 10);
        MyPair p4 = new MyPair(8, 12);

        intervals.countTotalLength(Arrays.asList(p1, p2, p3, p4));
        intervals.countTotalLengthUsingSort(Arrays.asList(p1, p2, p3, p4));

    }

    public void countTotalLength(List<MyPair> intervals) {
        Boolean[] markerArray = new Boolean[100];
        Integer total = 0;

        for (MyPair pair : intervals) {
            for (int i = pair.getLeft(); i < pair.getRight(); i++) {
                markerArray[i] = true;
            }
        }


        for (Boolean aMarkerArray : markerArray) {
            if (aMarkerArray != null && aMarkerArray) {
                total++;
            }
        }
        System.out.println(total);
    }

    public void countTotalLengthUsingSort(List<MyPair> intervals) {
        ArrayList<javafx.util.Pair<Integer, Boolean>> finalList = new ArrayList<>();

        for (MyPair interval : intervals) {
            finalList.add(new Pair<>(interval.getLeft(), true));
            finalList.add(new Pair<>(interval.getRight(), false));
        }

        //Sort each one now.
        for (int i = 1; i < finalList.size(); i++) {
            int j=i;
            while (j > 0 && finalList.get(j).getKey() < finalList.get(j - 1).getKey()) {
                Pair<Integer, Boolean> temp = finalList.get(j);
                finalList.set(j, finalList.get(j - 1));
                finalList.set(j-1, temp);
                j--;
            }
        }

        //Now start counting
        int start =0;
        int end;
        int total=0;
        //Use a stack to ignore all the sub-intervals within an interval.
        Stack<Object> determinantStack = new Stack<>();
        for (Pair<Integer, Boolean> element : finalList) {
            if (element.getValue()) {
                if(start>0) {
                    determinantStack.push(new Object());
                }
                else{
                    start=element.getKey();
                }
            }
            else {
                if (determinantStack.size() > 0) {
                    determinantStack.pop();
                }
                else if(determinantStack.size()==0){
                    end = element.getKey();
                    total += (end - start +1);
                    start=0;
                }
            }
        }

        System.out.println("total = " + total);
    }
}
