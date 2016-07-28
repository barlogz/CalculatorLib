package ua.goit.java.calculator.lib;

import java.util.List;

/**
 * Created by Roman D. on 28.07.2016.
 */
public interface UnaryOperationProvider {

    List<UnaryOperation> getUnaryOperations();

    void addOperations(UnaryOperation unaryOperation);

    void init();
}
