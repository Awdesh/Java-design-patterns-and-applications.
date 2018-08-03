import java.util.ArrayList;
import java.util.*;
import java.util.Random;
import java.util.stream.IntStream;

import org.w3c.dom.ranges.Range;

public class Shuffle {

    // public int[] riffle(int[] arr){
    //     int mid = arr.length / 2;
    //     int[] l = arr[]
    //     return arr;
    // }

    public int[] overhand(int[] arr) {
   
        int mid = arr.length / 2;

        int[] A = IntStream.rangeClosed(0, arr[mid]).toArray();
        // for(int i=0; i < arr[mid]; i++){
        //     System.out.print(A[i] + " ");
        // }
        // System.out.print("\n");

     
        int[] B = IntStream.rangeClosed(arr[mid], arr.length).toArray();
        // for(int i=0; i < arr[mid]; i++){
        //     System.out.print(B[i] + " ");
        // }

        int i = mid;
        int j = arr.length - 1;
        System.out.print("\n");

   
        while(i > 0){
            int temp = arr[i];
            arr[i--] = arr[j];
            arr[j--] = temp;
        }

        for(int ii=0; ii < arr.length; ii++){
            System.out.print(arr[ii] + " ");
        }
        return arr;
    }

    // private static parition(int[] arr) {

    // }

    public int[] fisherYatesShuffle(int[] ar) {
        
        if ( ar.length < 2){
            return ar;
        }

        Random rnd = new Random();
        for (int i = ar.length - 1; i > 0; i--)
            {
              int index = rnd.nextInt(i + 1);
              // Simple swap
              int a = ar[index];
              ar[index] = ar[i];
              ar[i] = a;
            }

        for(int ii=0; ii < ar.length; ii++){
            System.out.print(ar[ii] + " ");
        }
        
        return ar;
    }





    public static void main(String[] args) {
        List<Integer> list =new ArrayList<>();
        for(int i=1; i <= 100; i++){
            list.add(i);
        }
        int[] arr = new int[100];
        for(int i=0; i < 100; i++){
            arr[i] = i;
        }        

        for(int i=0; i < 100; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.print("\n");

        System.out.println("*********");

        System.out.print("\n");

      
        Shuffle s = new Shuffle();
        Long start = System.nanoTime();
        s.fisherYatesShuffle(arr);
        System.out.print("\n");

        System.out.println("Time Taken is-:");
        System.out.print(System.nanoTime() - start);
        System.out.print("\n");
        System.out.println("*********");

        System.out.println("Riffle Shuffle");
        start = System.nanoTime();

        s.overhand(arr);

        System.out.print("\n");
        System.out.println("Time Taken is-:");
        System.out.print(System.nanoTime() - start);
        
        start = System.nanoTime();
        Collections.shuffle(list);
        System.out.print("\n");
        System.out.println("Time Taken is-:");
        System.out.print(System.nanoTime() - start);
        System.out.print("\n");

        for (int i = 0; i < list.size(); ++i) {
            System.out.print(list.get(i) + " ");
        }

        // for(int i=0; i < 1000; i++){
        //     System.out.print(arr[i] + " ");
        // }


    }
}