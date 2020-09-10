import java.math.BigDecimal;

public class Task8 {

    public static void main(String[] args) {
        int[] arr = {1, -10, 5, 6, 45, 23, -45, -34, 0, 32, 56, -1, 2, -2};

        int maxValue = arr[0];
        int countPositives = 0;
        int countNegatives = 0;
        int sumPositives = 0;
        int sumNegatives = 0;
        int sumEvenNegatives = 0;

        for (int element: arr) {
            if (maxValue < element) {
                maxValue = element;
            }
            
            if (element > 0) {
                countPositives++;
                sumPositives += element;

            } else if (element < 0) {
                countNegatives++;
                sumNegatives += element;
                
                if (element % 2 == 0) {
                    sumEvenNegatives += element;
                }
            }
        }

        BigDecimal averageNegatives = BigDecimal.ZERO;
        if (countNegatives > 0) {
            averageNegatives = BigDecimal.valueOf(sumNegatives).divide(BigDecimal.valueOf(countNegatives));
        }

        System.out.println("Максимальное значение: " + maxValue);
        System.out.println("Сумма положительных элементов: " + sumPositives);
        System.out.println("Сумма четных отрицательных элементов: " + sumEvenNegatives);
        System.out.println("Количество положительных элементов: " + countPositives);
        System.out.println("Среднее арифметическое отрицательных элементов: " + averageNegatives);
    }
}
