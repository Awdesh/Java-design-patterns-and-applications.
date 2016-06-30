package ArraynStrings;

import java.util.HashMap;

/**
 * Created by awdesh on 6/29/16.
 */
public class Anagram {
    public Anagram(){

    }

    public boolean areAnagram(String s1, String s2){
        if(s1.length() != s2.length()){
            return false;
        }

        HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
        char[] chArr = s1.toCharArray();
        for(char c : chArr){
            if(!hm.containsKey(c)){
                hm.put(c, 1);
            } else {
                hm.put(c, hm.get(c) + 1);
            }
        }

        char[] chArr1 = s2.toCharArray();
        for(char c : chArr1){
            if(!hm.containsKey(c)){
                return false;
            } else {
                int v = hm.get(c);
                v = v - 1;
                hm.put(c, v);

                if(v == 0){
                    hm.remove(c);
                }
            }
        }

        if(hm.values().size() == 0){
          return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Anagram anagram = new Anagram();
        boolean b = anagram.areAnagram("aba", "baa");
        System.out.print(b);
    }
}
