import java.util.Scanner;
import java.util.InputMismatchException;

public class Task1 {

    public static void main(String[] args) {
        System.out.print("Введите целое число и нажмите [enter]: ");

        final Scanner scanner = new Scanner(System.in);
        try {
            int number = scanner.nextInt();

            // берем число по модулю, иначе сумма цифр отрицательного числа будет отрицательным числом
            int absNumber = (number < 0) ? Math.abs(number) : number;  
            System.out.println("Последняя цифра: " + absNumber % 10);

        } catch (InputMismatchException e) {
            System.out.println("Ошибка: введенное значение не является целым числом или находится вне допустимого диапазона.");
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
    }
}
