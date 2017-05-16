package com.company;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

/**
 * Created by awdesh on 10/31/15.
 */
public class UnionArray
{
    /**
     * Method finds intersection of 2 arrays.
     * Note: works only when array A has greater length than array B.
     * @param A - An integer array containing integers.
     * @param B - An integer array containing integers.
     * @return - An interger array.
     */
    public static int[] Intersection(int[] A, int[] B)
    {
        int len1 = A.length;
        int len2 = B.length;
        int[] op = new int[B.length];

        int i = 0;
        int j = 0;
        int k = 0;
        while (i < len1 && j < len2)
        {
            if(A[i] == B[j])
            {
                op[k] = A[i];
                i++;
                j++;
                k++;
                continue;
            }

            if(len1 > len2)
                i++;
            else
                j++;
        }

        return op;
    }

    /**
     * Using HashTable to store key, value pair.
     * @param A - An integer array.
     * @param B - An integer array.
     * @return - A list containing common elements.
     */
    public static List intersectionImproved(int[]A, int[]B)
    {
        Hashtable<Integer,Integer> map = new Hashtable<Integer, Integer>();
        for(int i : A)
        {
            if(!map.containsKey(i))
                map.put(i,1);
            else
                map.put(i, map.get(i) + 1);
        }

        List<Integer> op = new ArrayList<Integer>();
        for(int i : B)
        {
            if(map.containsKey(i))
            {
                op.add(i);
            }
        }
        return op;
    }

    public static List Union(int[] A, int[] B)
    {
        List<Integer> list = new ArrayList<Integer>();
        Hashtable<Integer,Integer> map = new Hashtable<Integer, Integer>();
        for(int i : A)
        {
            if(!map.containsKey(i))
                map.put(i,1);
        }

        for(int i : B)
        {
            if(!map.containsKey(i))
                map.put(i, 1);
        }

        for(int key : map.keySet())
        {
            list.add((key));
        }

        return list;
    }

    public static void main(String[] args)
    {
        int[] A = new int[]{1,2,3,4,5,6,3};
        int[] B = new int[]{3,4,5,6};
        List<Integer> op = intersectionImproved(A,B);
        for(int i : op)
        {
            System.out.println(i);
        }

        List<Integer> op1 = Union(A, B);
        for(int i : op1)
        {
            System.out.println(i);
        }

    }
}
