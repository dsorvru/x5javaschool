import java.util.Arrays;
import java.util.Scanner;

public class Task5 {

    public static void main(String[] args) {
        System.out.print("Введите три целых числа и нажмите [enter]: ");

        final Scanner scanner = new Scanner(System.in);
        try {

            int[] values = getNumbersFromUser(scanner, 3);
            System.out.println("Наименьшее из чисел " + Arrays.toString(values) + ": " + minValue(values));

        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }    
    }

    private static int[] getNumbersFromUser(Scanner scanner, int requestedNumbers) throws Exception {

        int[] numbers = new int[requestedNumbers];
        for (int i = 0; i < requestedNumbers; i++) {
            while (!scanner.hasNextInt()) {
                System.out.println("Введенное значение " + scanner.next() + " не является целым числом или находится вне допустимого диапазона.");
            }
            numbers[i] = scanner.nextInt();
        }
        // подскажите, пожалуйста, как с помощью Scanner.nextInt контролировать ввод заданного количества целых чисел. 
        // пользователь может ввести больше чисел или 3 числа и что-то еще.
        return numbers;
    }

    public static int minValue(int[] arr) {
        if ((arr == null) || (arr.length == 0)) {
            throw new IllegalArgumentException("Массив не определен или не имеет элементов.");
        }

        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if ( arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }
}
