import java.util.PriorityQueue;

public class TwoDArray {

    public static void traverse(int[][] matrix)
    {
        System.out.println(matrix.length);
        System.out.println(matrix[0].length);
        System.out.println(matrix[0].length);
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

        // below loop will print the matrix.
        for(int row=0; row < matrix.length; row ++)
        {
            for(int col = 0; col < matrix[row].length; col ++)
            {
                pq.add(matrix[row][col]);
            }
            System.out.print("\n");
        }

        // printing the diagonal.
        for(int row=0; row < matrix.length; row ++)
        {
            for(int col = 0; col < matrix[row].length; col ++)
            {
                if(row == matrix.length - col)
                    System.out.print(matrix[row][col]);
            }
            System.out.print("\n");
        }

        System.out.println("*********");
        while (pq.size() != 0){
            System.out.println(pq.poll());
        }

    }




    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4}, {5,1,2,3}, {9,5,1,2}};
        traverse(matrix);
//        System.out.print();
    }
}
