package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by awdesh on 10/24/15.
 * Certain modification on the code from -: geek view point
 */
public class BucketSort
{
    /**
     * Bucket sort method helps to sort array of integers that are uniformly distributed.
     * Uniformly distribution suggests that there is equal or not drastic difference between
     * consecutive numbers inside an array.
     */
    public int[] bucketsort(int[] input) {

        //get hash codes
        final int[] code = hash(input);

        //create and initialize buckets to ArrayList: O(n)
        List<Integer>[] buckets = new List[code[1]];
        for (int i = 0; i < code[1]; i++) {
            buckets[i] = new ArrayList<Integer>();
        }

        //distribute data into buckets: O(n)
        for (int i : input) {
            buckets[hash(i, code)].add(i);
        }
        /**
         * Sort each bucket: O(n).
         * I mentioned above that the worst case for bucket sort is counting
         * sort. That's because in the worst case, bucket sort may end up
         * with one bucket per key. In such case, sorting each bucket would
         * take 1^2 = O(1). Even after allowing for some probabilistic
         * variance, to sort each bucket would still take 2-1/n, which is
         * still a constant. Hence, sorting all the buckets takes O(n).
         ***/
        for (List bucket : buckets) {
            Collections.sort(bucket);
        }

        int ndx = 0;
        //merge the buckets: O(n)
        for (int b = 0; b < buckets.length; b++) {
            for (int v : buckets[b]) {
                input[ndx++] = v;
            }
        }

        return input;
    }

    /**
        Method will tell number of buckets that needs to be created.
     *  take the square root of the length of the array, that will be the number of
     *  buckets required. Since numbers are uniformly distributed.
     */
    private int[] hash(int[] input) {
        int m = input[0];
        for (int i = 1; i < input.length; i++) {
            if (m < input[i]) {
                m = input[i];
            }
        }

        int[] hash = new int[]{m, (int) Math.sqrt(input.length)};
        return hash;
    }

    /*
     *  Method will help in finding the appropriate index in the buckets.
     *  Creates a hash value for each supplied array value.
     */
    private int hash(int i, int[] code)
    {
        int v = (int) ((double) i / code[0] * (code[1] - 1));
        return v;
    }
}
