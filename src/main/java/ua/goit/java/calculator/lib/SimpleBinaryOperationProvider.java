package ua.goit.java.calculator.lib;

import java.util.ArrayList;
import java.util.List;

public class SimpleBinaryOperationProvider implements BinaryOperationProvider {

    private List<BinaryOperation> binaryOperations = new ArrayList<>();

    @Override
    public List<BinaryOperation> getBinaryOperations() {
        return binaryOperations;
    }

    @Override
    public void addOperation(BinaryOperation binaryOperation) {
        binaryOperations.add(binaryOperation);
    }

    @Override
    public void init() {
        addOperation(new OperationPlus());
        addOperation(new OperationMinus());
    }
}
