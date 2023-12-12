package hw_18;

import java.util.Arrays;

public class Matrix<T> {
    private T[][] matrix;
    public Matrix(T[][] matrix) {
        this.matrix = matrix;
    }
    public void printMatrix() {
        for (T[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }
    public Matrix<T> add(Matrix<T> otherMatrix) {
        if (matrix.length != otherMatrix.matrix.length || matrix[0].length != otherMatrix.matrix[0].length) {
            throw new IllegalArgumentException("Matrices must have the same dimensions for addition.");
        }
        Object[][] result = new Object[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] instanceof Integer && otherMatrix.matrix[i][j] instanceof Integer) {
                    result[i][j] = (Integer) matrix[i][j] + (Integer) otherMatrix.matrix[i][j];
                } else if (matrix[i][j] instanceof Double && otherMatrix.matrix[i][j] instanceof Double) {
                    result[i][j] = (Double) matrix[i][j] + (Double) otherMatrix.matrix[i][j];
                } else {
                    throw new IllegalArgumentException("Unsupported data type for addition.");
                }
            }
        }
        return new Matrix<>((T[][]) result);
    }
    public Matrix<T> subtract(Matrix<T> otherMatrix) {
        if (matrix.length != otherMatrix.matrix.length || matrix[0].length != otherMatrix.matrix[0].length) {
            throw new IllegalArgumentException("Matrices must have the same dimensions for subtraction.");
        }
        Object[][] result = new Object[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] instanceof Integer && otherMatrix.matrix[i][j] instanceof Integer) {
                    result[i][j] = (Integer) matrix[i][j] - (Integer) otherMatrix.matrix[i][j];
                } else if (matrix[i][j] instanceof Double && otherMatrix.matrix[i][j] instanceof Double) {
                    result[i][j] = (Double) matrix[i][j] - (Double) otherMatrix.matrix[i][j];
                } else {
                    throw new IllegalArgumentException("Unsupported data type for subtraction.");
                }
            }
        }
        return new Matrix<>((T[][]) result);
    }
    public Matrix<T> multiply(Matrix<T> otherMatrix) {
        if (matrix[0].length != otherMatrix.matrix.length) {
            throw new IllegalArgumentException("Number of columns of the first matrix must be equal to the number of rows of the second matrix for multiplication.");
        }
        Object[][] result = new Object[matrix.length][otherMatrix.matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < otherMatrix.matrix[0].length; j++) {
                double sum = 0;
                for (int k = 0; k < matrix[0].length; k++) {
                    sum += ((Number) matrix[i][k]).doubleValue() * ((Number) otherMatrix.matrix[k][j]).doubleValue();
                }
                result[i][j] = sum;
            }
        }
        return new Matrix<>((T[][]) result);
    }
    public Matrix<T> transpose() {
        Object[][] transposedMatrix = new Object[matrix[0].length][matrix.length];
        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                transposedMatrix[i][j] = matrix[j][i];
            }
        }
        return new Matrix<>((T[][]) transposedMatrix);
    }

    public static void main(String[] args) {
        Integer[][] matrixData1 = {{1, 2, 3}, {4, 5, 6}};
        Integer[][] matrixData2 = {{7, 8, 9}, {10, 11, 12}};

        Matrix<Integer> matrix1 = new Matrix<>(matrixData1);
        Matrix<Integer> matrix2 = new Matrix<>(matrixData2);

        System.out.println("Matrix 1:");
        matrix1.printMatrix();

        System.out.println("Matrix 2:");
        matrix2.printMatrix();

        System.out.println("Matrix Sum:");
        Matrix<Integer> sumMatrix = matrix1.add(matrix2);
        sumMatrix.printMatrix();

        System.out.println("Matrix subtract:");
        Matrix<Integer> subMatrix = matrix1.subtract(matrix2);
        subMatrix.printMatrix();

        System.out.println("Matrix Multiplication:");
        Double[][] matrixData3 = {{2.0, 0.0, 1.0}, {1.0, 2.0, 3.0}, {3.0, 1.0, 2.0}};
        Double[][] matrixData4 = {{1.0, 2.0, 3.0}, {4.0, 5.0, 6.0}, {7.0, 8.0, 9.0}};
        Matrix<Double> matrix3 = new Matrix<>(matrixData3);
        Matrix<Double> matrix4 = new Matrix<>(matrixData4);

        System.out.println("Matrix 3:");
        matrix3.printMatrix();

        System.out.println("Matrix 4:");
        matrix4.printMatrix();

        Matrix<Double> multiplicationResult = matrix3.multiply(matrix4);
        System.out.println("Matrix Multiplication Result:");
        multiplicationResult.printMatrix();

        Double[][] matrixData = {{1.0, 2.0, 3.0}, {4.0, 5.0, 6.0}, {7.0, 8.0, 9.0}};
        Matrix<Double> matrix = new Matrix<>(matrixData);

        System.out.println("Original Matrix:");
        matrix.printMatrix();

        System.out.println("Transposed Matrix:");
        Matrix<Double> transposedMatrix = matrix.transpose();
        transposedMatrix.printMatrix();
    }
}
