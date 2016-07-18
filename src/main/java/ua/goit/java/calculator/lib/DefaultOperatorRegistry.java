package ua.goit.java.calculator.lib;

import java.util.Map;

public class DefaultOperatorRegistry implements OperatorRegistry {

    private Map<OperatorDefinition, DefaultBinaryOperation> operatorRegistry;

    @Override
    public DefaultBinaryOperation getOperator(OperatorDefinition definition) {
        if (!operatorRegistry.containsKey(definition)) {
            throw new UnsupportedOperationException("There is no such operation! " +
                    "Please, choose another one (\"+\" or \"-\")");
        }
        return operatorRegistry.get(definition);
    }
}
