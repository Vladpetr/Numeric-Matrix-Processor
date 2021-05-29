package processor;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        boolean incomplete = true;
        while(incomplete) {
            System.out.println("1. Add matrices");
            System.out.println("2. Multiply matrix by a constant");
            System.out.println("3. Multiply matrices");
            System.out.println("4. Transpose matrix");
            System.out.println("5. Calculate a determinant");
            System.out.println("6. Inverse matrix");
            System.out.println("0. Exit");
            
            Scanner sc = new Scanner(System.in);
            
            System.out.println("Your choice: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    add();
                    break;
                case 2:
                    cMult();
                    break;
                case 3:
                    matrixMult();
                    break;
                case 4:
                    System.out.println("1. Main diagonal");
                    System.out.println("2. Side diagonal");
                    System.out.println("3. Vertical line");
                    System.out.println("4. Horizontal line");
                    
                    System.out.println("Your choice: ");
                    int transpose_type = sc.nextInt();
                    
                    switch(transpose_type) {
                        
                        case 1:
                            trMain();
                            break;
                        case 2:
                            trSide();
                            break;
                        case 3:
                            trVertical();
                            break;
                        case 4:
                            trHorizontal();
                            break;
                    }
                    break;
                case 5:
                       determinant();
                       break; 
                case 6:
                       inverse();
                       break;
                case 0:
                    incomplete = false;
                    break;
            }
        }
    }
    
    public static void add() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of first matrix: ");
        int rows1 = sc.nextInt();
        int cols1 = sc.nextInt();
        double[][] matrix1 = new double[rows1][cols1];
        System.out.println("Enter first matrix: ");
        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < cols1; j++) {
                matrix1[i][j] = sc.nextDouble();
            }
        }
        System.out.println("Enter size of second matrix: ");
        int rows2 = sc.nextInt();
        int cols2 = sc.nextInt();
        if (rows1 != rows2 || cols1 != cols2) { System.out.print("The operation cannot be performed."); }
        else {
            System.out.println("Enter second matrix: ");
            System.out.println("The result is: ");
            for (int a = 0; a < rows1; a++) {
                for (int b = 0; b < cols1; b++) {
                    System.out.print(matrix1[a][b] + sc.nextDouble() + " ");
                }
                System.out.print("\n");
            }
        }
    }
    
    public static void cMult() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of matrix: ");
        int rows = sc.nextInt();
        int cols = sc.nextInt();
        int[][] matrix = new int[rows][cols];
        System.out.println("Enter matrix: ");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        System.out.println("Enter constant: ");
        double k = sc.nextDouble();
        System.out.println("The result is: ");
        for (int a = 0; a < rows; a++) {
            for (int b = 0; b < cols; b++) {
                System.out.print(matrix[a][b] * k + " ");
            }
            System.out.println();
        }
    }
    
    public static void matrixMult() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of matrix: ");
        int rows1 = sc.nextInt();
        int cols1 = sc.nextInt();
        double[][] matrix1 = new double[rows1][cols1];
        System.out.println("Enter first matrix: ");
        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < cols1; j++) {
                matrix1[i][j] = sc.nextDouble();
            }
        }
        System.out.println("Enter size of second matrix: ");
        int rows2 = sc.nextInt();
        int cols2 = sc.nextInt();
        if (cols1 != rows2) { System.out.print("The operation cannot be performed."); }
        else {
            System.out.println("Enter second matrix: ");
            double[][] matrix2 = new double[rows2][cols2];
            for (int x = 0; x < rows2; x++) {
                for (int y = 0; y < cols2; y++) {
                    matrix2[x][y] = sc.nextDouble();
                }
            }
            System.out.println("The result is: ");
            double[][] matrix3 = new double[rows1][cols2];
            for (int a = 0; a < rows1; a++) {
                for (int b = 0; b < cols2; b++) {
                    matrix3[a][b] = 0;
                    for (int k = 0; k < cols1; k++) {
                        matrix3[a][b] += matrix1[a][k] * matrix2[k][b];
                    }
                    
                    System.out.print(matrix3[a][b] + " ");
                }
                System.out.println();
            }
        }
    }
    
    public static void trMain() {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter matrix size: ");
            int rows = sc.nextInt();
            int cols = sc.nextInt();
            double[][] matrix = new double[rows][cols];
            System.out.println("Enter matrix: ");
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    matrix[i][j] = sc.nextDouble();
                }
            }
            System.out.println("The result is: ");
            double tr_main[][] = new double[cols][rows];
            for (int x = 0; x < cols; x++) {
                for (int y = 0; y < rows; y++) {
                    tr_main[x][y] = matrix[y][x];
                }
            }
            
            for (int a = 0; a < rows; a++) {
                for (int b = 0; b < cols; b++) {
                    System.out.print(tr_main[a][b] + " ");
                }
                System.out.println();
            }
        }
        
    public static void trSide() {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter matrix size: ");
            int rows = sc.nextInt();
            int cols = sc.nextInt();
            double[][] matrix = new double[rows][cols];
            System.out.println("Enter matrix: ");
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    matrix[i][j] = sc.nextDouble();
                }
            }
            System.out.println("The result is: ");
            double tr_side[][] = new double[cols][rows];
            for (int x = 0; x < cols; x++) {
                for (int y = 0; y < rows; y++) {
                    tr_side[x][y] = matrix[cols-y-1][rows-x-1];
                    
                }
            }
            
            for (int a = 0; a < rows; a++) {
                for (int b = 0; b < cols; b++) {
                    System.out.print(tr_side[a][b] + " ");
                }
                System.out.println();
            }
        }
        
    public static void trVertical() {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter matrix size: ");
            int rows = sc.nextInt();
            int cols = sc.nextInt();
            double[][] matrix = new double[rows][cols];
            System.out.println("Enter matrix: ");
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    matrix[i][j] = sc.nextDouble();
                }
            }
            System.out.println("The result is: ");
            double tr_vertical[][] = new double[cols][rows];
            for (int x = 0; x < cols; x++) {
                for (int y = 0; y < rows; y++) {
                    tr_vertical[x][y] = matrix[x][cols-y-1];
                }
            }
            
            for (int a = 0; a < rows; a++) {
                for (int b = 0; b < cols; b++) {
                    System.out.print(tr_vertical[a][b] + " ");
                }
                System.out.println();
            }
        }
        
    public static void trHorizontal() {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter matrix size: ");
            int rows = sc.nextInt();
            int cols = sc.nextInt();
            double[][] matrix = new double[rows][cols];
            System.out.println("Enter matrix: ");
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    matrix[i][j] = sc.nextDouble();
                }
            }
            System.out.println("The result is: ");
            double tr_horizontal[][] = new double[cols][rows];
            for (int x = 0; x < cols; x++) {
                for (int y = 0; y < rows; y++) {
                    tr_horizontal[x][y] = matrix[rows-x-1][y];
                    
                }
            }
            
            for (int a = 0; a < rows; a++) {
                for (int b = 0; b < cols; b++) {
                    System.out.print(tr_horizontal[a][b] + " ");
                }
                System.out.println();
            }
        }
        
    public static double recursiveDet (double[][] matrix) {
        if (matrix.length == 1) {
            return matrix[0][0];
        }
        else if (matrix.length == 2) {
            return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
        }
        else {
            double ans = 0;
            for (int i = 0; i < matrix.length; i++) {
                if (i % 2 == 0) {
                    ans += (matrix[0][i] * recursiveDet(rmRowCol(matrix, 0, i)));
                }
                else {
                    ans -= (matrix[0][i] * recursiveDet(rmRowCol(matrix, 0, i)));
                }
            }
            return ans;
        }
    }    
    
    public static double[][] rmRowCol(double[][] matrix, int row, int col){
        double[][] updated = new double[matrix.length-1][matrix.length-1];
        int r = 0;
        int c = 0;
        for (int i = 0; i < matrix.length; i++) {
            
            for (int j = 0; j < matrix.length; j++) {
                if (i != row && j != col) {
                    updated[r][c] = matrix[i][j];
                    
                    c += 1;
                }
            }
            c = 0;
            if (i != row) {
                r += 1;
            }
        }
        r = 0;
        return updated;
    }
    
        
    public static void determinant() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter matrix size: ");
        int rows = sc.nextInt();
        int cols = sc.nextInt();
        if (rows != cols) {
            System.out.println("Cannot calculate the determinant! Number of rows and columns has to be equal.");
        }
        else {
            double[][] matrix = new double[rows][cols];
            System.out.println("Enter matrix: ");
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    matrix[i][j] = sc.nextDouble();
                }
            }
            System.out.println("The result is: ");
            System.out.println(recursiveDet(matrix));
        }
        
    }
    
    public static void inverse() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter matrix size: ");
        int rows = sc.nextInt();
        int cols = sc.nextInt();
        if (rows != cols) {
            System.out.println("Cannot calculate the determinant! Number of rows and columns has to be equal.");
        }
        else {
            double[][] matrix = new double[rows][cols];
            System.out.println("Enter matrix: ");
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    matrix[i][j] = sc.nextDouble();
                }
            }
            if (recursiveDet(matrix) == 0) { 
                System.out.println("This matrix doesn't have an inverse."); 
            }
            else {
                System.out.println("The result is: ");
                double[][] minors = new double[rows][cols];
                for (int a = 0; a < rows; a++) {
                    for (int b = 0; b < cols; b++) {
                        minors[a][b] = recursiveDet(rmRowCol(matrix, a, b));
                    }
                }
            
                for (int x = 0; x < rows; x++) {
                    for (int y = 0; y < cols; y++) {
                        if (x % 2 == 0 && y % 2 == 1) { minors[x][y] = minors[x][y] * -1; }
                        else if (x % 2 == 1 && y % 2 == 0) { minors[x][y] = minors[x][y] * -1; }
                    }
                }
            
                double adjoint[][] = new double[cols][rows];
                for (int c = 0; c < cols; c++) {
                    for (int d = 0; d < rows; d++) {
                        adjoint[c][d] = minors[d][c];
                    }
                }
                
                for (int e = 0; e < rows; e++) {
                    for (int f = 0; f < cols; f++) {
                        System.out.print(adjoint[e][f] * (1/(double) recursiveDet(matrix)) + " ");
                    }
                    System.out.println();
                }
            } 
            
        }
    }
        
        
}
