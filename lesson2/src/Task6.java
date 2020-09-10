import java.util.Scanner;
import java.util.InputMismatchException;

public class Task6 {

    public static void main(String[] args) {
        System.out.print("Введите целое число и нажмите [enter]: ");

        final Scanner scanner = new Scanner(System.in);
        
        try {
            int number = scanner.nextInt();
            System.out.println(getDescription(number));
            
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

    private static String getDescription(int number) {
        StringBuilder description = new StringBuilder();
        
        if (number == 0) {
            description.append("нулевое");
        } else {
            description.append((number < 0) ? "отрицательное" : "положительное");
            description.append((number % 2 == 0) ? " четное" : " нечетное");
        }
        description.append(" число");

        return description.toString();
    }
}
