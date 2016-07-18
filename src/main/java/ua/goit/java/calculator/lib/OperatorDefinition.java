package ua.goit.java.calculator.lib;

import java.util.List;

public class OperatorDefinition {
    List<Class<?>> argsTypes;
    String operator;

    public OperatorDefinition() {
    }

    public List<Class<?>> getArgsTypes() {
        return argsTypes;
    }

    public String getOperator() {
        return operator;
    }
}