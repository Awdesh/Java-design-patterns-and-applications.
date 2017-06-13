package TwoPointer;

/**
 * Created by awdesh on 11/7/15.
 */
public class MinSubArray
{
    public static int FindMinSub(int[] nums, int s)
    {
        int len = nums.length;
        if(len == 0)
            return 0;

        int totalSum = 0;
        for(int num: nums)
        {
            totalSum+=num;
        }
        if(totalSum < s)
            return 0;

        int i = 0;
        int j = 0;
        int minLength = nums.length;
        int currSum = nums[0];

        while (i < nums.length)
        {
            if(currSum >= s)
            {
                if(minLength > (j-i+1))
                {
                    minLength = j-i+1;
                }
                currSum -= nums[i];
                i++;
            }
            else
            {
                j++;
                if(j>=nums.length)
                    break;
                currSum +=nums[j];
            }
        }

        return minLength;
    }

    public static void main(String[] args)
    {
        int[] nums = new int[]{2,3,1,2,4,3};
        int minLen = FindMinSub(nums, 7);
        System.out.println(minLen);
    }
}
