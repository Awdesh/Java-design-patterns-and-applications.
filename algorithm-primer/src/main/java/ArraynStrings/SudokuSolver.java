package ArraynStrings;


import java.util.BitSet;

public class SudokuSolver
{
    public static boolean solve(int[][] matrix)
    {
        // traverse row, col and check if you have number between 1 - 9.
        // check if duplicate doesn't exists.
        // check every 3*3 array that it contains number between 1 - 9.

        // below loop will print the matrix.
        for(int row=0; row < matrix.length; row ++)
        {
            for(int col = 0; col < matrix[row].length; col ++)
            {
                if(matrix[row][col] > 9 || matrix[row][col] < 1)
                    return false;

                if(ifDupsExists(matrix[row][col]))
                    return false;
            }
            System.out.print("\n");
        }

        //  0-2, 3-5, 6-8
        // 0-2, 3-5, 6-8
        // total of 9 squares.

//        i = 0 to len = 9
//        row = 0, row < row+ 2; row ++
//            col=0; col < 3; col++
//                matrix[row][col]



        return false;
    }

    public static boolean ifDupsExists(int i)
    {
        BitSet bs = new BitSet(9);

        //TODO




        return true;
    }

    public static void main(String[] args) {

    }
}
