package com.company;

/**
 * Created by awdesh on 10/29/15.
 */
public class LongestPalindrome
{
    public static String LongestPalindromeImproved(String in)
    {
        char[] input = in.toCharArray();
        int longestStart = 0;
        int longestEnd = 0;

        for(int mid = 0; mid <input.length;mid++)
        {
            //for odd case.
            int left = mid;
            int right = mid;
            while (left >= 0 && right < input.length)
            {
                if(right-left>longestEnd-longestStart)
                {
                    longestStart = left;
                    longestEnd = right;
                }
                left--;
                right++;
            }

            left = mid;
            right = mid+1;
            while (left >= 0 && right < input.length)
            {
                if(right-left>longestEnd-longestStart)
                {
                    longestStart = left;
                    longestEnd = right;
                }
                left--;
                right++;
            }
        }
        return in.substring(longestStart, longestEnd+1);
    }

    public static String LongestPalindromeNaive(String in)
    {
        char[] input = in.toCharArray();
        int longestStart = 0;
        int longestEnd = 0;

        for(int start = 0; start < input.length; start++)
        {
            for(int end = start+1; end<= input.length; end++)
            {
                if(ifPalindrome(input, start, end-1))
                {
                    if(end-start>longestEnd-longestStart)
                    {
                        longestEnd = end;
                        longestStart = start;
                    }
                }
            }
        }

        return in.substring(longestStart,longestEnd);
    }

    /**
     * Only need to compare from start to middle element since comparing element from end too,
     * so if we begin from starting of a string and compare from end, when begin pointer reach to
     * the center, pointer from the last will be at center too.
     * @param input
     * @param start
     * @param end
     * @return
     */
    private static boolean ifPalindrome(char[] input, int start, int end)
    {
        for(int i = start; i <= (start + end)/2; i++)
        {
            if(input[i] == input[start+end-i])
                continue;
            else
                return false;
        }
        return true;
    }
}

class Main1
{
    public static void main(String[] args)
    {
        String naive = LongestPalindrome.LongestPalindromeNaive("1243421");
        System.out.println(naive);

        String improved = LongestPalindrome.LongestPalindromeImproved("1243421");
        System.out.println(improved);
    }
}
