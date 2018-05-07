package Sorting;
import java.util.*;

public class Duplicates {

    public static void findDups(int[] arr)
    {
        // BitSet is an array of bits represented by boolean values.
        // 0 represents boolean false (off) value.
        // BitSet uses about 1 bit per boolean value.
        // Since it's an array index starts at index 0.
        BitSet bs = new BitSet(32000);
        for(int i=0; i < bs.length(); i++)
            System.out.print(bs.get(i));

        for(int i = 0; i < arr.length; i++)
        {
            int num0 = arr[i] - 1;
            if(bs.get(num0))
                System.out.print(arr[i]);
            else
                bs.set(num0);
        }
    }

    public static void main(String[] args) {
        int[] ip = {3,5,4,2,1,6};
        Duplicates.findDups(ip);
    }
}



