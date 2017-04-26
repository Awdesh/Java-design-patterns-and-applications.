package TwoPointer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by awdesh on 11/10/15.
 */
public class ThreeSum
{
    public static List<List<Integer>> ThreeSum(int[] nums)
    {
        List<Integer> list = new ArrayList<Integer>();
        List<List<Integer>> nList = new ArrayList<List<Integer>>();

        for(int i =0; i < nums.length; i++)
        {

            int sum = nums[i];
            int count = 0;
            while(count < 2)
            {
                if(i + 1 > nums.length - 1)
                    break;

                sum += nums[++i];
                ++count;
            }

            if(sum == 0)
            {
                list.add(nums[i]);
                list.add(nums[--i]);
                list.add(nums[--i]);

                nList.add(list);
            }
            else
            {
                i -= 2;
            }
        }

            return nList;

    }

    public static void main(String[] args)
    {
        int[] ip = new int[]{-1,0,1,2,-1,-4};
        List<List<Integer>> list = ThreeSum(ip);
        for(List<Integer> l : list)
        {
            for(int ll : l)
                System.out.println(ll);
        }
    }
}
