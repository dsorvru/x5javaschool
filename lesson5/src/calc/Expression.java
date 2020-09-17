package calc;

import java.math.BigDecimal;

public class Expression {
    private String operation;
    private BigDecimal operand1;
    private BigDecimal operand2;

    public Expression(String operation, BigDecimal operand1, BigDecimal operand2) {
        this.operation = operation;
        this.operand1 = operand1;
        this.operand2 = operand2;
    }

    @Override
    public String toString() {
        return "Expression: operation=" + operation
                + ", operand1=" + operand1
                + ", operand2=" + operand2;
    }

    public String getOperation() {
        return operation;
    }

    public BigDecimal getOperand1() {
        return operand1;
    }

    public BigDecimal getOperand2() {
        return operand2;
    }
}