import java.util.Arrays;
import java.util.Scanner;

public class Matrix {
    public static void main(String[] args) {
        Scanner inputStream = new Scanner(System.in);
        System.out.print("Введите размерность матрицы: n = ");
        int dimensionOfTheMatrix = inputStream.nextInt();
        System.out.print("\nВведите диапазон рандомных чисел(-M; M): M = ");
        int rangeOfValue = inputStream.nextInt();
        System.out.printf("\nДиапазон значений: %d, -%d\n", rangeOfValue, rangeOfValue);
        int[][] arrayMatrix = new int[dimensionOfTheMatrix][dimensionOfTheMatrix];
        for (int i = 0; i < dimensionOfTheMatrix; i++) {
            for (int j = 0; j < dimensionOfTheMatrix; j++) {
                int randomRowNumber = (int) (Math.random() * (rangeOfValue * 2) - rangeOfValue);
                System.out.printf("%2d\t", randomRowNumber);
                arrayMatrix[i][j] = randomRowNumber;
            }
            System.out.print("\n");
        }

        System.out.printf("Сортировка пузырьком\nВведите номер столбца для сортировки матрицы(в пределах от 1 до %d): k = ", dimensionOfTheMatrix);
        int columnToSort = inputStream.nextInt();
        Arrays.sort(arrayMatrix, (x, y) -> -(y[columnToSort - 1] - x[columnToSort - 1]));
        for (int i[] : arrayMatrix) {
            for (int j : i)
                System.out.printf("%2d\t", j);
            System.out.println();
        }
    }
}
