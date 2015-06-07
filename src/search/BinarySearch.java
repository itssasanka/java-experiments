package search;

/**
 * Created by sasanka on 6/7/15.
 */
public class BinarySearch {
    public static void main(String args[]) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        BinarySearch binarySearch = new BinarySearch();
        int position = binarySearch.binarySearch(10, array);

        if (position != -1) {
            System.out.println("position = " + position);
        }else {
            System.out.println("Not found");
        }
    }


    public int binarySearch(int searchKey, int[] array) {
        int low = 0;
        int high = array.length-1;
        int mid;
        while(low<=high) {
            mid=(low+high)/2;
            if (array[mid] == searchKey) {
                return mid;
            }

            if (array[mid] < searchKey) {
                low = mid+1;
            }else if (array[mid] > searchKey) {
                high = mid;
            }

        }
        return -1;
    }


}
