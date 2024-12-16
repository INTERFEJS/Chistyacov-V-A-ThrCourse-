// 5 ВАРИАНТ. Операции с матрицами с помощью абстрактной фабрики
package AbstractFactory;

// Интерфейс для операций с матрицами
interface MatrixOperation {
    void perform(double[][] matrixA, double[][] matrixB);
}

// Реализация операции сложения
class MatrixAddition implements MatrixOperation {
    @Override
    public void perform(double[][] matrixA, double[][] matrixB) {
        int rows = matrixA.length;
        int cols = matrixA[0].length;
        double[][] result = new double[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = matrixA[i][j] + matrixB[i][j];
            }
        }

        System.out.println("Result of Addition:");
        printMatrix(result);
    }

    private void printMatrix(double[][] matrix) {
        for (double[] row : matrix) {
            for (double value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}

// Реализация операции умножения
class MatrixMultiplication implements MatrixOperation {
    @Override
    public void perform(double[][] matrixA, double[][] matrixB) {
        int rowsA = matrixA.length;
        int colsA = matrixA[0].length;
        int colsB = matrixB[0].length;
        double[][] result = new double[rowsA][colsB];

        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                for (int k = 0; k < colsA; k++) {
                    result[i][j] += matrixA[i][k] * matrixB[k][j];
                }
            }
        }

        System.out.println("Result of Multiplication:");
        printMatrix(result);
    }

    private void printMatrix(double[][] matrix) {
        for (double[] row : matrix) {
            for (double value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}

// Реализация операции вычисления определителя
class MatrixDeterminant implements MatrixOperation {
    @Override
    public void perform(double[][] matrixA, double[][] matrixB) {
        if (matrixA.length != matrixA[0].length) {
            System.out.println("Determinant can only be calculated for square matrices.");
            return;
        }

        double determinant = calculateDeterminant(matrixA);
        System.out.println("Determinant of the matrix: " + determinant);
    }

    private double calculateDeterminant(double[][] matrix) {
        int size = matrix.length;

        if (size == 1) {
            return matrix[0][0];
        }

        if (size == 2) {
            return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
        }

        double determinant = 0;
        for (int i = 0; i < size; i++) {
            double[][] subMatrix = new double[size - 1][size - 1];
            for (int row = 1; row < size; row++) {
                int colIndex = 0;
                for (int col = 0; col < size; col++) {
                    if (col == i) continue;
                    subMatrix[row - 1][colIndex++] = matrix[row][col];
                }
            }
            determinant += Math.pow(-1, i) * matrix[0][i] * calculateDeterminant(subMatrix);
        }

        return determinant;
    }
}

// Абстрактная фабрика для операций с матрицами
interface MatrixOperationFactory {
    MatrixOperation createOperation();
}

// Конкретные фабрики для каждой операции
class AdditionFactory implements MatrixOperationFactory {
    @Override
    public MatrixOperation createOperation() {
        return new MatrixAddition();
    }
}

class MultiplicationFactory implements MatrixOperationFactory {
    @Override
    public MatrixOperation createOperation() {
        return new MatrixMultiplication();
    }
}

class DeterminantFactory implements MatrixOperationFactory {
    @Override
    public MatrixOperation createOperation() {
        return new MatrixDeterminant();
    }
}

// Демонстрация работы абстрактной фабрики
public class AbstractMatrixOperation {
    public static void main(String[] args) {
        // Матрицы для операций
        double[][] matrixA = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        double[][] matrixB = {
                {9, 8, 7},
                {6, 5, 4},
                {3, 2, 1}
        };

        // Использование фабрик
        MatrixOperationFactory additionFactory = new AdditionFactory();
        MatrixOperationFactory multiplicationFactory = new MultiplicationFactory();
        MatrixOperationFactory determinantFactory = new DeterminantFactory();

        // Создание и выполнение операций
        MatrixOperation addition = additionFactory.createOperation();
        addition.perform(matrixA, matrixB);

        MatrixOperation multiplication = multiplicationFactory.createOperation();
        multiplication.perform(matrixA, matrixB);

        MatrixOperation determinant = determinantFactory.createOperation();
        determinant.perform(matrixA, null);
    }
}
