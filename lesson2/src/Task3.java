import java.util.Scanner;
import java.util.InputMismatchException;

public class Task3 {

    public static void main(String[] args) {
        System.out.print("Введите целое число и нажмите [enter]: ");

        final Scanner scanner = new Scanner(System.in);
        
        try {
            int number = scanner.nextInt();

            long result = (number > 0) ? (long)number + 1 : number; // используем long, т.к. может произойти переполнение      
            System.out.println("Полученное число: " + result);
            
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
