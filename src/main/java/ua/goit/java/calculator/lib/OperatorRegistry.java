package ua.goit.java.calculator.lib;

/**
 * Created by Roman D. on 18.07.2016.
 */
public interface OperatorRegistry {
    BinaryOperation getOperator(OperatorDefinition definition);
}
