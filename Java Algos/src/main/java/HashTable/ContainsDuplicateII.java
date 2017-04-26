package HashTable;

import java.util.Hashtable;

/**
 * Created by awdesh on 11/10/15.
 */
public class ContainsDuplicateII
{
    /**
     * Given an array of integers and an integer k.
     * Find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j] and the difference between i and j is at most k.
     * @param nums -: An array containing integers.
     * @param k - An integer value.
     * @return -: A boolean value.
     */
    public static boolean containsNearbyDuplicate(int[] nums, int k)
    {
        Hashtable<Integer, Integer> map = new Hashtable<Integer, Integer>();
        for(int i = 0; i < nums.length; i++)
        {
            if(!map .containsKey(nums[i]))
                map.put(nums[i],i);
            else
            {
                int v = map.get(nums[i]);
                map.put(nums[i], i - v);
            }
        }

        for(int i : map.values())
        {
            if(i==k)
            {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args)
    {
        int[] nums = new int[]{1,2,1,3,4,3,4};
        boolean val = ContainsDuplicateII.containsNearbyDuplicate(nums, 2);
        System.out.println(val);
    }
}
