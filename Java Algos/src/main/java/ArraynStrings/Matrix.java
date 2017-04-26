package ArraynStrings;

import java.security.Key;
import java.util.Dictionary;
import java.util.HashMap;

/**
 * Created by awdesh on 3/21/15.
 */
public class Matrix {

    /*
    Two Dimensional Array.
     */
    public int[][] CreateArray()
    {
        // m * n  = rows * columns.
        int[][] arr = new int[5][5];
        arr[0][0] = 1;
        arr[0][1] = 2;
        arr[0][2] = 3;
        arr[0][3] = 0;
        arr[0][4] = 2;
        arr[1][0] = 2;
        arr[1][1] = 5;
        arr[1][2] = 6;
        arr[1][3] = 0;
        arr[1][4] = 3;
        arr[2][0] = 3;
        arr[2][1] = 1;
        arr[2][2] = 3;
        arr[2][3] = 4;
        arr[2][4] = 4;
        arr[3][0] = 4;
        arr[3][1] = 2;
        arr[3][2] = 0;
        arr[3][3] = 1;
        arr[3][4] = 5;
        arr[4][0] = 5;
        arr[4][1] = 2;
        arr[4][2] = 6;
        arr[4][3] = 3;
        arr[4][4] = 6;

        for(int i = 0; i <arr.length; i++)
        {
            int[] sub = arr[i];
            for(int j = 0; j<sub.length;j++)
            {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }

        int prev = 0;
        for(int i = 0; i <arr.length; i++)
        {
            int[] sub = arr[i];
            for(int j = 0; j<sub.length;j++)
            {
                if(sub[j] == 0 && j != prev)
                {
                    prev = j;
                    arr  = ReplaceZero(arr,i,j);
                    break;
                }
            }
        }
        return arr;
    }

    /*

     */
    public int[][] ReplaceZero(int[][] ar, int M, int N)
    {

        int[] sub = ar[M];
        for(int i = 0; i<ar.length;i++)
        {
            sub[i] = 0;
            if(i == N)
            {
                for(int j = 0; j<sub.length;j++)
                {
                    ar[j][N] = 0;
                }
            }
        }
        return ar;
    }
}
