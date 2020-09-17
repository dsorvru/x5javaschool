package calc;

import log.LoggerFactory;
import log.ConsoleLoggerFactory;

import java.math.BigDecimal;

public class App {

    public static void main(String[] args) {
        LoggerFactory loggerFactory = new ConsoleLoggerFactory();
        Calculator calc = new Calculator(loggerFactory);

        System.out.println(calc.add(BigDecimal.TEN, BigDecimal.TEN));
        System.out.println(calc.subtract(BigDecimal.TEN, BigDecimal.TEN));
        System.out.println(calc.multiply(BigDecimal.TEN, BigDecimal.TEN));
        System.out.println(calc.divide(BigDecimal.TEN, BigDecimal.TEN));
    }

}
