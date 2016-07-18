package ua.goit.java.calculator.lib;

import java.util.List;

public class ParsedExpression {

    private OperatorDefinition operatorDefinition;
    private List<?> args;

    public ParsedExpression(OperatorDefinition definition, String operator) {
        this.operatorDefinition = operatorDefinition;
        this.operatorDefinition.operator = operator;
    }

    public List<?> getArgs() {
        return args;
    }

    public OperatorDefinition getOperatorDefinition() {
        return operatorDefinition;
    }
}
