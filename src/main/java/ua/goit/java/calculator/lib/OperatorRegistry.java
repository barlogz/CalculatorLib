package ua.goit.java.calculator.lib;

/**
 * Created by Roman D. on 18.07.2016.
 */
public interface OperatorRegistry {
    DefaultBinaryOperation getOperator(OperatorDefinition definition);
}
