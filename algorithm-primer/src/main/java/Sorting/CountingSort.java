/**
 * Created by awdesh on 10/31/15.
 */
public class CountingSort
{
    /**
     * sort method fits well when array of numbers lies between given range of number.
     * @param arrayToSort - array of integers.
     * @return - return an array of integers.
     */
    public int[] sort(int[] arrayToSort)
    {
        int max = getMaxValue(arrayToSort);
        // 1st step -: create a new buffer array of same length.
        int[] tempArray = new int[max + 1];

        // 2nd step -: fill in temp array with frequency of the number.
        for(int i = 0; i < arrayToSort.length; i++)
        {
            tempArray[arrayToSort[i]] = tempArray[arrayToSort[i]] + 1;
        }

        // 3rd step -: add 2 values at the indexes.
        for(int i = 1; i < max; i++)
        {
            tempArray[i] = tempArray[i] + tempArray[i-1];
        }

        int[] finalSortedArray = new int[arrayToSort.length];
        // start from the end of original array.
        for(int i = (arrayToSort.length - 1); i >=0; i--)
        {
            // go to the index on the finalSortedArray, index would be the value on tempArray.
            finalSortedArray[tempArray[arrayToSort[i]]  - 1] = arrayToSort[i];
            //
            tempArray[arrayToSort[i]] = tempArray[arrayToSort[i]] - 1;
        }

        return finalSortedArray;
    }

    /**
     * Calculate maximum value from the array.
     * @param array - an integer array.
     * @return - An integer representing maximum value.
     */
    private int getMaxValue(int[] array)
    {
        int max = Integer.MIN_VALUE;
        for(int i : array)
        {
            if(i > max)
            {
               max = i;
            }
        }

        return max;
    }

    public static void main(String[] args)
    {
        CountingSort countingSort = new CountingSort();
        int[] arrayToSort = new int[] { 0, 3, 1, 0, 5, 2, 4, 5, 2,7,9,10 };
        int[] sortedArray = countingSort.sort(arrayToSort);

        for (int i = 0; i < sortedArray.length; i++)
        {
            System.out.print(sortedArray[i] + ",");
        }
    }
}
