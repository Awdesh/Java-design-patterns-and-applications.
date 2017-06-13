import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

/**
 * Created by awdesh on 11/2/15.
 */
public class FindWords
{
    // Given an input string and a dictionary, split up the input string into words from the dictionary
    //applepie
    public static List splitWords(String input)
    {
        char[] chArr = input.toCharArray();
        int len = chArr.length;

        StringBuffer sb = new StringBuffer();
        List<String> output = new ArrayList<String>();
        int index = 0;

        for(int i = 0; i< len; i++)
        {
            sb.append(chArr[i]);
            String s = sb.toString();

            if(Find1(s))
            {
                output.add(s);
                index = i;
            }

            if(index == len - 1)
                break;

            if(i == len - 1)
            {
                sb.setLength(0);
                i = index;//5
                sb.append(chArr[++i]);//p
            }
        }

        return output;
    }

    /**
     * O(n^2)
     * @param input
     * @return
     */
    public static List findWords(String input)
    {
        char[] chArr = input.toCharArray();
        int len = input.length();
        StringBuffer sb = new StringBuffer();
        List<String> op = new ArrayList<String>();

        for(int i = 0; i< len; i++)
        {
            for(int j = i; j < len; j++)
            {
                sb.append(chArr[j]);
                if(Find1(sb.toString()))
                {
                    op.add(sb.toString());
                }
            }
            sb.setLength(0);
        }

        return op;
    }

    /**
     *
     * @param word
     * @return
     */
    private static boolean Find1(String word)
    {
        Hashtable map = new Hashtable();
        map.put("app", 1);
        map.put("apple", 1);
        map.put("pie", 1);
        map.put("modest", 1);
        map.put("mouse", 1);
        map.put("almighty", 1);
        map.put("GOD", 1);
        map.put("is", 1);
        map.put("watching", 1);
        map.put("cat", 1);
        map.put("cats", 1);
        map.put("sand", 1);
        map.put("and", 1);
        map.put("at", 1);
        map.put("dog", 1);

        if(map.containsKey(word))
            return true;
        else
            return false;
    }

    public static void main(String[] args)
    {
        List<String> ls = findWords("catsanddog");
        for(String s: ls)
        {
            System.out.println(s);
        }
    }
}
