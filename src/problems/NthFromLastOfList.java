package problems;

/**
 * Created by sasankapanguluri on 1/11/17.
 */

import utils.*;

import javax.swing.tree.TreeNode;

// Given a list, return the nth element from the end of the list
// Example: 2->3->4->5->6->7->3->1

// return the 3rd element from the end;
// Output : 7

public class NthFromLastOfList {
    public static void main(String[] args){
        ListImp l = new ListImp(7);
        NthFromLastOfList n = new NthFromLastOfList();
        try {
            l.add(2);
            l.add(3);
            l.add(4);
            l.add(5);
            l.add(6);
            l.add(7);
            l.add(8);

            System.out.println(n.nthFromLast(l.getHead(), 3));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public int nthFromLast(Node n, int pos){


        if (n.getNext() == null){
            return 1;
        }

        int k = 1 + nthFromLast(n.getNext(), pos);

        if (k == pos){
            System.out.println(n.getValue());
            System.exit(0);
        }else{
            return k;
        }

        return -1;
    }
}
