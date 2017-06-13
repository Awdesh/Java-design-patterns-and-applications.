import java.util.Stack;

/**
 * Created by awdesh on 3/24/15.
 */
public class StringPalindrome
{
    public static boolean isPalindrome(String str)
    {
        char[] chArr = str.toCharArray();
        int start = 0;
        int end = str.length() - 1;

        while(start <= end)
        {
            if(chArr[start] != chArr[end])
                return false;
            start++;
            end--;
        }

        return true;
    }

    public static boolean isPalindromeUsingStack(String str)
    {
        char[] chArr = str.toCharArray();
        Stack<Character> s = new Stack<Character>();
        for(char c : chArr)
        {
            s.push(c);
        }

        char[] op = new char[str.length()];
        int index = 0;
        while(!s.empty())
        {
            op[index] = s.pop();
            index++;
        }

        if(op.length != chArr.length)
            return false;

        String s1 = new String(op);
        if(s1.compareTo(str) == 0)
            return true;
        else
            return false;
    }

    public static void main(String[] args)
    {
        boolean val = StringPalindrome.isPalindrome("abba");
        System.out.println(val);

        boolean val1 = StringPalindrome.isPalindromeUsingStack("abba");
        System.out.println(val1);
    }
}
