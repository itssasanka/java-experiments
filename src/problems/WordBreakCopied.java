package problems;

import java.util.*;

/**
 * Created by sasankapanguluri on 1/4/17.
 */
public class WordBreakCopied {

    public List<String> wordBreak(String s, Set<String> wordDict) {
        ArrayList<String> [] pos = new ArrayList[s.length()+1];
        pos[0]= new ArrayList<>();

        for(int i=0; i<s.length(); i++){
            if(pos[i]!=null){
                for(int j=i+1; j<=s.length(); j++){
                    String sub = s.substring(i,j);
                    if(wordDict.contains(sub)){
                        if(pos[j]==null){
                            ArrayList<String> list = new ArrayList<>();
                            list.add(sub);
                            pos[j]=list;
                        }else{
                            pos[j].add(sub);
                        }

                    }
                }
            }
        }

        if(pos[s.length()]==null){
            return new ArrayList<>();
        }else{
            ArrayList<String> result = new ArrayList<>();
            dfs(pos, result, "", s.length());
            return result;
        }
    }

    public void dfs(ArrayList<String> [] pos, ArrayList<String> result, String curr, int i){
        if(i==0){
            result.add(curr.trim());
            return;
        }

        for(String s: pos[i]){
            String combined = s + " "+ curr;
            dfs(pos, result, combined, i-s.length());
        }
    }


    public static void main(String[] args){
        WordBreakCopied w = new WordBreakCopied();
        List<String> result = w.wordBreak("catsanddogold", new HashSet<>(Arrays.asList("gold","old","do","cat", "cats", "sand", "and", "dog")));
        System.out.println("result = " + result);

    }
}
