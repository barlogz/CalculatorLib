package ua.goit.java.calculator.lib;

import java.util.List;

public class Calculator {

    private Parser parser;
    private List<BinaryOperation> binaryOperationsSet;
    private List<UnaryOperation> unaryOperationSet;

    public void setParser(Parser parser) {
        this.parser = parser;
    }

    public void setBinaryOperationsSet(List<BinaryOperation> binaryOperationsSet) {
        this.binaryOperationsSet = binaryOperationsSet;
    }

    public void setUnaryOperationSet(List<UnaryOperation> unaryOperationSet) {
        this.unaryOperationSet = unaryOperationSet;
    }

    public double compute(String expression) throws IllegalArgumentException {

        boolean operatorFound = false;
        double result = 0;
        parser.parse(expression);

        for (BinaryOperation binaryOperation : binaryOperationsSet) {
            if (binaryOperation.getOperator() != parser.getOperator()) {
                continue;
            }
            operatorFound = true;
            result = binaryOperation.calculate(parser.getOperands().get(0), parser.getOperands().get(1));
        }

        for (UnaryOperation unaryOperation : unaryOperationSet) {
            if (unaryOperation.getOperator() != parser.getOperator()) {
                continue;
            }
            operatorFound = true;
            result = unaryOperation.calculate(parser.getOperands().get(0));
        }

        if (!operatorFound) {
            throw new IllegalArgumentException("Operator not found: '" + parser.getOperator() + "'");
        }
        return result;
    }

    public void addNewBinaryOperation(BinaryOperation binaryOperation) {
        binaryOperationsSet.add(binaryOperation);
    }

    public void addNewUnaryOperation(UnaryOperation unaryOperation) {
        unaryOperationSet.add(unaryOperation);
    }

    public void addNewValueParser(ValueParser valueParser) {
        parser.addNewValueParser(valueParser);
    }

}
