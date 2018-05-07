package ArraynStrings;

public class MakingAnagrams {


    static int makingAnagrams(String s1, String s2) {
        // Complete this function
        if (s1 == null || s1.length() < 0 && s2 == null || s2.length() < 0)
            return -1;
//        import java.io.*;
//import java.util.*;
//import java.text.*;
//import java.math.*;
//import java.util.regex.*;
//
//        public class Solution {

//            public static void main(String[] args) {
//                /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
//                Scanner s = new Scanner(System.in);
//                int[] nA = countLetters(s.next());
//                int[] nB = countLetters(s.next());
//                int diff = 0;
//                for (int i=0; i<26; i++) {
//                    diff += Math.abs(nA[i]-nB[i]);
//                }
//                System.out.println(diff);
//            }
//
//
//            private static int[] countLetters(String text) {
//                // Count for 26 letters
//                int[] count = new int[26];
//
//                for (int i = 0; i < text.length(); i++) {
//                    char character = text.charAt(i);
//                    count[(int)character - 97]++; // The ASCII for 'a' is 97
//                }
//
//                return count; // Return the count array
//            }
//
//        }

//        Character[] charArray = new Character[128];
        int[] a = new int[26];
        for (int i = 0; i < s1.length(); i++)
        {
            char c1 = s1.charAt(i);
            a[(int)c1 - 97]++;
        }

        int[] b = new int[26];
        for (int i=0 ; i< 26; i++) {
            char c2 = s2.charAt(i);
            b[(int)c2 - 97]++;
        }

        int count = 0;
        for (int i = 0; i < 26; i++) {
            count += Math.abs(a[i] - b[i]);
        }

        return count;

    }


    public static void main(String[] args) {


        String s1 = "fcrxzwscanmligyxyvym";
        String s2 = "jxwtrhvujlmrpdoqbisbwhmgpmeoke";
        int result = makingAnagrams(s1, s2);
        System.out.println(result);
    }
}
