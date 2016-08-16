package ArraynStrings;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by awdesh on 8/1/16.
 */
public class FirstNonRepeatedLetter {

    Queue<Character> q = new LinkedList<Character>();

    public FirstNonRepeatedLetter(){
        q = new LinkedList<Character>();
    }

    public char Find(String input){
        HashMap hm = new HashMap();

        char[] chArr = input.toCharArray();

         for(char c : chArr){
             if(!hm.containsKey(c)){
                 hm.put(c, 1);
                 q.add(c);
             } else {
                 if(q.size() > 0)
                    q.remove();
             }
         }

        if(q.size() > 0){
            return q.poll();
        }

        return 'a';
    }

    public static void main(String[] args) {
        FirstNonRepeatedLetter f = new FirstNonRepeatedLetter();

        char c = f.Find("aaabccdbxyz");
        System.out.println(c);
        char c1 = f.Find("abcdeefg");
        System.out.println(c1);
        char c2 = f.Find("aaaaaaaaa");
        System.out.println(c2);
    }
}
