package problems;

/**
 * Created by sasanka on 5/31/15.
 */
// Given a String, print all possible permutations
public class Permutations {
    public static void main(String args[]) {
        Permutations permutations = new Permutations();
        permutations.jumble("1324567890");
    }

    public void jumble(String toJumble) {
        jumble("", toJumble);
    }

    public void jumble(String prefix, String toProcess) {
        if (toProcess.length() == 2) {
            System.out.println(prefix + toProcess);
            System.out.println(prefix + new StringBuilder(toProcess).reverse().toString());
            return;
        }
        for(int i=0;i<toProcess.length();i++){
            jumble(prefix+String.valueOf(toProcess.charAt(i)), removeCharacter(toProcess, toProcess.charAt(i)));
        }
    }

    public String removeCharacter(String original, char character) {
        return original.substring(0, original.indexOf(character))
                + original.substring(original.indexOf(character) + 1);
    }


}
