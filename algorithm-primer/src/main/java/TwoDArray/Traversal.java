package com.company;

public class Traversal {

    public Traversal() {

    }

    public void traverseRowWise(int[][] A) {
        for (int i = 0; i < A.length ; i++) {
            for (int j = 0; j < A[i].length ; j++) {
                System.out.print(A[i][j]);
            }
            System.out.println();
        }
    }

    public void traverseColWise(int[][] A) {
        for (int i = 0; i < A[0].length ; i++) {
            for (int j = 0; j < A.length ; j++) {
                System.out.print(A[j][i]);
            }
            System.out.println();
        }
    }

    /**
     * Insert Zero on all the diagonals.
     * @param A
     */
    public void traverseDiagonalWise(int[][] A) {
        for (int i = 0; i < A.length ; i++) {
            for (int j = 0; j < A[i].length ; j++) {
                if(i == j) {
                    A[i][j] = 0;
                }
            }
        }

        for (int i = 0; i < A.length ; i++) {
            for (int j = 0; j < A[i].length ; j++) {
                System.out.print(A[i][j]);
            }
            System.out.println();
        }
    }



    public static void main(String[] args) {
        int[][] A = new int[3][3];
        A[0][0] = 1;
        A[0][1] = 2;
        A[0][2] = 3;
        A[1][0] = 4;
        A[1][1] = 5;
        A[1][2] = 6;
        A[2][0] = 7;
        A[2][1] = 8;
        A[2][2] = 9;
        Traversal traversal = new Traversal();
        traversal.traverseRowWise(A);
        System.out.println("=======");
        traversal.traverseColWise(A);
        System.out.println("=======");
        traversal.traverseDiagonalWise(A);
    }
}