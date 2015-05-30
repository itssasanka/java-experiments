import java.util.Arrays;
import java.util.List;

/**
 * Created by sasanka on 5/30/15.
 */

//Given intervals like 1..3, 4...5, 7..10, 7..9; output the total length of the non-overlapping interval periods
public class Intervals {

    public static class Pair{
        private Integer left;
        private Integer right;

        public Pair(Integer left, Integer right) {
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
        Pair p1 = new Pair(1, 3);
        Pair p2 = new Pair(2, 5);
        Pair p3 = new Pair(5, 10);
        Pair p4 = new Pair(8, 12);

        intervals.countTotalLength(Arrays.asList(p1, p2, p3, p4));

    }

    public void countTotalLength(List<Pair> intervals) {
        Boolean[] markerArray = new Boolean[100];
        Integer total = 0;

        for (Pair pair : intervals) {
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


}
