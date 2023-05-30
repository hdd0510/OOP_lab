package OOPlab.lab1;

import java.util.Scanner;

public class MatricesAdd {
    public static int[][] addmatrices(int[][] m1, int[][] m2) {
        int r = m1.length;
        int c = m1[0].length;
        int[][] m = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                m[i][j] = m1[i][j] + m2[i][j];
            }
        }
        return m;
    }

    public static void print(int[][] m) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                System.out.print(m[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int r = input.nextInt();
        int c = input.nextInt();
        int[][] m1 = new int[r][c];
        int[][] m2 = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.printf("Element row %d, column %d of matrix 1:", i + 1, j + 1);
                m1[i][j] = input.nextInt();
            }
        }
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.printf("Element row %d, column %d of matrix 2:", i + 1, j + 1);
                m2[i][j] = input.nextInt();
            }
        }
        input.close();
        int[][] m = MatricesAdd.addmatrices(m1, m2);
        System.out.println("matrix 1 is:");
        MatricesAdd.print(m1);
        System.out.println("matrix 2 is:");
        MatricesAdd.print(m2);
        System.out.println("The new matrix after add matrix 1 and matrix 2:");
        MatricesAdd.print(m);
    }
}
