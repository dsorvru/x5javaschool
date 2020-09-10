import java.util.Scanner;
import java.util.InputMismatchException;

public class Task2 {

    public static void main(String[] args) {
        System.out.print("Введите целое трехзначное число и нажмите [enter]: ");
        final Scanner scanner = new Scanner(System.in);
        
        try {
            int number = scanner.nextInt();
            int absNumber = (number < 0) ? Math.abs(number) : number; 
            if ((absNumber < 100) || (absNumber > 999)) {
                throw new Exception("Ошибка: Введенное значение не является трехзначным числом.");
            } 
            System.out.println("Сумма цифр числа: " + sumDigits(absNumber));

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
    
    private static int sumDigits(int number) {
        // берем число по модулю, иначе сумма цифр отрицательного числа будет отрицательным числом
        if (number < 0) {
            number = Math.abs(number);
        }
        int sum = 0;
        while (number != 0) {
            sum += number % 10;
            number /=  10;
        }
        return sum;
    }
}