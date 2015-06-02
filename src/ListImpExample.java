/**
 * Created by Sasanka on 6/1/2015.
 */
public class ListImpExample {
    public static void main(String args[]) throws Exception {
        ListImp listImp = new ListImp(3);
        listImp.add(1);
        listImp.add(2);
        listImp.add(3);

        listImp.print();

        listImp.remove(1);

        listImp.print();
        listImp.reverse();

        listImp.print();
    }
}
