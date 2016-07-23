package ua.goit.java.calculator.lib;

import java.util.List;

public interface Parser {

    void addNewValueParser(ValueParser valueParser);

    boolean parse(String expression);

    String getParsedExpression();

    List<Double> getOperands();

    char getOperator();

}