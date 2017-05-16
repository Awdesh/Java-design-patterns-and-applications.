package TwoPointer;

import java.util.Hashtable;

/**
 * Created by awdesh on 11/8/15.
 */
public class strStr
{
    /**
     *
     * @param haystack
     * @param needle
     * @return
     */
    public static int implmenteStrNaive(String haystack, String needle)
    {
        int i = 0;
        int j = 0;

        char[] A = haystack.toCharArray();
        char[] B = needle.toCharArray();

        int lenA = haystack.length();
        int lenB = needle.length();

        while (i < lenA && j < lenB)
        {
            if(A[i] == B[j])
            {
                if(j == lenB -1)
                    return i;
                j++;
            }

            // start from beginning.
            else
                j = 0;

            i++;
        }

        return -1;
    }

    public static int strStr1(String haystack, String needle) {
        if(haystack==null || needle==null)
            return 0;

        if(needle.length() == 0)
            return 0;

        for(int i=0; i<haystack.length(); i++)
        {
            if(i + needle.length() > haystack.length())
                return -1;

            int m = i;
            for(int j=0; j<needle.length(); j++){
                if(needle.charAt(j)==haystack.charAt(m)){
                    if(j==needle.length()-1)
                        return i;
                    m++;
                }else{
                    break;
                }

            }
        }

        return -1;
    }

    public static boolean implementStrUsingMap(String haystack, String needle)
    {
        String[] inputArray = haystack.split(" ");
        Hashtable<String, Integer> hm = new Hashtable<String, Integer>();
        for(String s : inputArray)
        {
            if(!hm.containsKey(s))
            {
                hm.put(s, 1);
            }
            else
            {
                int val = hm.get(s);
                hm.put(s,++val);
            }
        }

        for(String s : hm.keySet())
        {
            if(s.compareToIgnoreCase(needle) == 0)
            {
                return true;
            }
        }

        return false;
    }

    /**
     * test case.
     * @param args
     */
    public static void main(String[] args)
    {
        String haystack = "This is a defective demo, Today is sunday. A bit cold weather. It's a start of winter already";
        String needle = "demo";
        int val = strStr1(haystack, needle);
//        int val1 = implmenteStrNaive(haystack, needle);
        System.out.println(val);
//        System.out.println(val1);
    }
}
