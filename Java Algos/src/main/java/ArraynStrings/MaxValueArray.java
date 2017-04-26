package ArraynStrings;

import java.util.List;

/**
 * Created by awdesh on 7/25/16.
 */
public class MaxValueArray {
    private int[] ages;

    public MaxValueArray(int[] ages){
        this.ages = ages;
    }

    // Basic approach-: O(n).
    public int getMax(){
        int max = 0;
        if(ages.length < 0){
            return max;
        }

        for(int age : ages){
            if(age > max){
                max = age;
            }
        }

        return max;
    }

//    public int getMaxBetter(){
//        int[] maxAge = new int[1];
//
//    }

    public static void main(String[] args) {
        int[] arr = new int[4];
        arr[0] = 35;
        arr[1] = 25;
        arr[2] = 57;
        arr[3] = 45;

        MaxValueArray mA = new MaxValueArray(arr);
        System.out.println(mA.getMax());
    }

}
