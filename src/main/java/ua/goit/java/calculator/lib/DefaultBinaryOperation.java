package ua.goit.java.calculator.lib;

/**
 * Created by Roman D. on 18.07.2016.
 */
public interface DefaultBinaryOperation {

    double calculate(double firstOperand, double secondOperand);

    char getOperator();
}
