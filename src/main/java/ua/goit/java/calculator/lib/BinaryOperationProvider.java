package ua.goit.java.calculator.lib;

import java.util.List;

/**
 * Created by Roman D. on 18.07.2016.
 */
public interface BinaryOperationProvider {

    List<BinaryOperation> getBinaryOperations();

    void addOperation (BinaryOperation binaryOperation);

    void init();

}
