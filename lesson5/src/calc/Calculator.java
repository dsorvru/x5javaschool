package calc;

import log.Logger;
import log.LoggerFactory;

import java.math.BigDecimal;

public class Calculator {

    private LoggerFactory loggerFactory;
    private Logger logger;

    public Calculator(LoggerFactory loggerFactory) {
        this.loggerFactory = loggerFactory;
        logger = loggerFactory.createLogger();
    }

    public BigDecimal add(BigDecimal operand1, BigDecimal operand2) {
        Expression expression = new Expression("add", operand1, operand2);
        logger.log(expression.toString());
        BigDecimal result = operand1.add(operand2);
        logger.log("Result: " + result);
        return result;
    }

    public BigDecimal subtract(BigDecimal operand1, BigDecimal operand2) {
        Expression expression = new Expression("subtract", operand1, operand2);
        logger.log(expression.toString());
        BigDecimal result = operand1.subtract(operand2);
        logger.log("Result: " + result);
        return result;

    }

    public BigDecimal multiply(BigDecimal operand1, BigDecimal operand2) {
        Expression expression = new Expression("multiply", operand1, operand2);
        logger.log(expression.toString());
        BigDecimal result = operand1.multiply(operand2);
        logger.log("Result: " + result);
        return result;
    }

    public BigDecimal divide(BigDecimal operand1, BigDecimal operand2) {
        Expression expression = new Expression("divide", operand1, operand2);
        logger.log(expression.toString());
        try {
            BigDecimal result = operand1.divide(operand2);
            logger.log("Result: " + result);
            return result;
        } catch (Exception e) {
            logger.log(e.toString());
            throw e;
        }
    }
}


