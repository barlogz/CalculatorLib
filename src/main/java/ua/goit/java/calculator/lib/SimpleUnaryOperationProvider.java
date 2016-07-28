package ua.goit.java.calculator.lib;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Roman D. on 28.07.2016.
 */
class SimpleUnaryOperationProvider implements UnaryOperationProvider{

    private List<UnaryOperation> unaryOperations;

    @Override
    public List<UnaryOperation> getUnaryOperations() {
        return unaryOperations;
    }

    @Override
    public void addOperations(UnaryOperation unaryOperation) {
        unaryOperations.add(unaryOperation);
    }

    @Override
    public void init() {
        unaryOperations = new ArrayList<>();
    }
}
