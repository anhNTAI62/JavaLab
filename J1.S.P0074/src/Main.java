
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static final Scanner in = new Scanner(System.in);

    private static int checkIntLimit(int min, int max) {
        while (true) {
            try {
                int n = Integer.parseInt(in.nextLine());
                if (n < min || n > max) {
                    System.err.println("value in " + min + " -> " + max);
                }
                return n;
            } catch (NumberFormatException ex) {
                System.err.println("Re-input");
            }
        }
    }

    private static int checkInputInt() {
        while (true) {
            try {
                int result = Integer.parseInt(in.nextLine());
                    return result;
            } catch (NumberFormatException ex) {
                System.err.println("Re-input");
            }
        }

    }

    private static int[][] inputMatrix(int n) {
        while (true) {
            System.out.print("Enter Row Matrix" + n + ":");
            int row = checkInputInt();
            System.out.print("Enter Colum Matrix" + n + ":");
            int col = checkInputInt();
            if (row > 0 && col > 0) {
                int[][] matrix = new int[row][col];
                for (int i = 0; i < row; i++) {
                    for (int j = 0; j < col; j++) {
                        System.out.print("Enter Matrix" + n + "[" + (i + 1) + "]" + "[" + (j + 1) + "]:");
                        matrix[i][j] = checkInputInt();
                    }
                }
                return matrix;
            } else {
                System.out.println("Enter row and colum > 0:");
            }
        }
    }


    public static int[][] additionMatrix(int[][] matrix1, int[][] matrix2) {
//        System.out.println("oke success");
        int row = matrix1.length;
        int col = matrix1[0].length;
        int[][] result = new int[row][col];
        if (matrix1[0].length != matrix2[0].length || matrix1.length != matrix2.length) {
            return null;
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                result[i][j] = (matrix1[i][j] + matrix2[i][j]);
            }
        }   
        return result;
    }

    public static int[][] subtractionMatrix(int[][] matrix1, int[][] matrix2) {
        int row = matrix1.length;
        int col = matrix1[0].length;
        int[][] result = new int[row][col];
        if (matrix1[0].length != matrix2[0].length || matrix1.length != matrix2.length) {
            return null;
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                result[i][j] = (matrix1[i][j] - matrix2[i][j]);
            }
        }
        return result;
    }

    public static int[][] multiplicationMatrix(int[][] matrix1, int[][] matrix2) {
        int row1 = matrix1.length;
        int col1 = matrix1[0].length;
        int row2 = matrix2.length;
        int col2 = matrix2[0].length;
        int[][] matrixResult = new int[row1][col2];
        if (matrix1[0].length != matrix2.length) {
            return null;
        }

        for (int i = 0; i < row1; i++) {
            for (int j = 0; j < col2; j++) {
                for (int k = 0; k < col1; k++) {
                    matrixResult[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        return matrixResult;
    }
    
    private static void displayMatrix(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print("[" + matrix[i][j] + "]");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] matrix1;
        int[][] matrix2;
        while (true) {
            System.out.println("=======Calculator program=======");
            System.out.println("1. Addition Matrix");
            System.out.println("2. Subtraction Matrix");
            System.out.println("3. Multiplication Matrix");
            System.out.println("4. Quit");
            System.out.print("Enter your choice: ");
            int choice = checkIntLimit(1, 4);
            switch (choice) {
                case 1:
                    System.out.println("-------- Addition --------");
                    matrix1 = inputMatrix(1);
                    matrix2 = inputMatrix(2);
                    System.out.println("-------- Result --------");
                    displayMatrix(matrix1);
                    System.out.println("+");
                    displayMatrix(matrix2);
                    System.out.println("=");
                    if(additionMatrix(matrix1, matrix2) == null){
                        System.out.println("ko thoa man");
                    }
                    else{
                    displayMatrix(subtractionMatrix(matrix1, matrix2));
                    }
                    
                    break;
                case 2:
                    System.out.println("----- Subtraction -----");
                    matrix1 = inputMatrix(1);
                    matrix2 = inputMatrix(2);
                    System.out.println("-------- Result --------");
                    displayMatrix(matrix1);
                    System.out.println("-");
                    displayMatrix(matrix2);
                    System.out.println("=");
                    if(subtractionMatrix(matrix1, matrix2)== null){
                        System.out.println("ko thoa man");
                    }
                    else{
                    displayMatrix(subtractionMatrix(matrix1, matrix2));
                    }
                    break;
                case 3:
                    System.out.println("----- Multiplication -----");
                    matrix1 = inputMatrix(1);
                    matrix2 = inputMatrix(2);
                    System.out.println("-------- Result --------");
                    displayMatrix(matrix1);
                    System.out.println("*");
                    displayMatrix(matrix2);
                    System.out.println("=");
                    if(multiplicationMatrix(matrix1, matrix2)== null){
                        System.out.println("ko thoa man");
                    }else{
                    displayMatrix(multiplicationMatrix(matrix1, matrix2));}
                    break;
                case 4:
                    return;
            }
        }
    }
}
