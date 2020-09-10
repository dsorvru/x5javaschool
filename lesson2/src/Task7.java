import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import java.util.Scanner;

public class Task7 {

    private static final int DURATION_MINUTES = 10;
    private static final char DECIMAL_SEPARATOR = '.';

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Введите код города и нажмите [enter]: ");
            String code = scanner.nextLine().strip();
   
            String cityName;
            BigDecimal costPerMinute;
            switch (code) {
                case "905":
                    cityName = "Москва";
                    costPerMinute = BigDecimal.valueOf(4.15);
                    break;
                
                case "194":
                    cityName = "Ростов";
                    costPerMinute = BigDecimal.valueOf(1.98);
                    break;
                
                case "491":
                    cityName = "Краснодар";
                    costPerMinute = BigDecimal.valueOf(2.69);
                    break;
                
                case "800":
                    cityName = "Киров";
                    costPerMinute = BigDecimal.valueOf(5.00);
                    break;
  
                default:
                    throw new Exception("Введен неизвестный код города.");
                
            }

            DecimalFormat df = setupDecimalFormat();
            printCallCost(cityName, calcCallCost(costPerMinute, DURATION_MINUTES), df);

        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());

        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
    }

    private static DecimalFormat setupDecimalFormat() {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.getDefault());
        symbols.setDecimalSeparator(DECIMAL_SEPARATOR);
        DecimalFormat df = new DecimalFormat("#0.0#", symbols);
        df.setMinimumFractionDigits(0);
        df.setMaximumFractionDigits(2);
        return df;
    }

    private static void printCallCost(String cityName, BigDecimal cost, DecimalFormat df) {
        System.out.println(cityName + ". Стоимость разговора: " + df.format(cost));
    }

    private static BigDecimal calcCallCost(BigDecimal pricePerMinute, int duration) {
        return pricePerMinute.multiply(BigDecimal.valueOf(duration));
    }
}
