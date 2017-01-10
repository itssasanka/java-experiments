package problems;

/**
 * Created by sasankapanguluri on 1/9/17.
 */


// Given a word, rotate it while holding the middle element if it exists
//    Example: "stealer" --> "leraste"
//    Example: "Java" ----> "vaJa"
public class RotateWord {


    public static void main(String[] args){
        RotateWord r = new RotateWord();
        r.rotateString("stealer");
        r.rotateString("stolen");
    }

    public void rotateString(String a){
        int midStart = (int) Math.floor((double) a.length() / 2);
        int midEnd = (int) Math.ceil((double) a.length() / 2);

        String first = a.substring(0, midStart);
        String mid = a.substring(midStart, midEnd);
        String last = a.substring(midEnd, a.length());

        String finalString = last + mid + first;
        System.out.println(finalString);
    }
}




