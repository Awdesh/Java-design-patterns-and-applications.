package HashTable;

import java.util.Hashtable;

/**
 * Created by awdesh on 11/10/15.
 */
public class TwoSum
{
    public static int[] TwoSum(int[] arr, int target)
    {
        Hashtable<Integer, Integer> map = new Hashtable<Integer, Integer>();
        int count = 0;
        for(int i : arr)
        {
            if(!map.containsKey(i))
                map.put(i, ++count);
        }

        int[] op = new int[2];
        for(int i : arr)
        {
            int val = target - i;
            if(map.containsKey(val))
            {
                op[0] = map.get(i);
                op[1] = map.get(val);
            }
        }
        return op;
    }

    public static void main(String[] args)
    {
        int[] nums = new int[]{2,7,11,15};
        int[] op = TwoSum(nums, 9);
        for(int j : op)
        {
            System.out.println(j);
        }
    }
}
