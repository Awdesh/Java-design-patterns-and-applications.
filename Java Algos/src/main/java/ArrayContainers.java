package com.company;

/**
 * Created by awdesh on 7/14/15.
 */
public class ArrayContainers implements Comparable<ArrayContainers>
{
    private int startIndex;
    private int[] array;

    public ArrayContainers(int[] array)
    {
        this.array = array;
        startIndex = 0;
    }

    public boolean IsEmpty()
    {
        return startIndex == array.length;
    }

    public int peek()
    {
        return array[startIndex];
    }

    public int getNextInt()
    {
        return array[startIndex++];
    }

    @Override
    public int compareTo(ArrayContainers o)
    {
        return new Integer(peek()).compareTo(o.peek());
    }
}
