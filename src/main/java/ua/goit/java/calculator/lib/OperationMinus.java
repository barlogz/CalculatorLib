package ua.goit.java.calculator.lib;

/**
 * Created by Roman D. on 18.07.2016.
 */
public class OperationMinus implements BinaryOperation {

    @Override
    public double calculate(double firstOperand, double secondOperand) {
        return firstOperand - secondOperand;
    }

    @Override
    public char getOperator() {
        return '-';
    }
}
