package ua.goit.java.calculator.lib;

import org.junit.Test;

/**
 * Created by Roman D. on 28.07.2016.
 */
public class CalculatorTest {

    @Test
    public void calculatorTest() {
        Calculator calculator = CalculatorFactory.getCalculator();

        System.out.println(calculator.compute("2 + 3"));

        try {
            System.out.println(calculator.compute("10 * 20"));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        calculator.addNewBinaryOperation(new MultiOperation());
        System.out.println(calculator.compute("10 * 20"));

        try {
            System.out.println(calculator.compute("s 20"));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        calculator.addNewUnaryOperation(new SquareOperation());
        System.out.println(calculator.compute("s 20"));

        try {
            System.out.println(calculator.compute("asd + fds"));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private class MultiOperation implements BinaryOperation {

        @Override
        public double calculate(double operand1, double operand2) {
            return operand1 * operand2;
        }

        @Override
        public char getOperator() {
            return '*';
        }
    }

    private class SquareOperation implements UnaryOperation {

        @Override
        public double calculate(double operand1) {
            return operand1 * operand1;
        }

        @Override
        public char getOperator() {
            return 's';
        }
    }
}