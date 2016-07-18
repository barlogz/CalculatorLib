package ua.goit.java.calculator.lib;

import java.util.List;

public class OperatorRegistryProvider implements OperatorRegistry{

    private List<OperatorRegistry> operatorRegistries;

    @Override
    public DefaultBinaryOperation getOperator(OperatorDefinition definition) {
        for (OperatorRegistry operatorRegistry : operatorRegistries) {
            try {
                return operatorRegistry.getOperator(definition);
            } catch (UnsupportedOperationException ex) {
                //ignore
            }
        }
        throw new UnsupportedOperationException("No such operator available in this calculator");
    }

    public void addOperatorRegistry(OperatorRegistry registry) {
        operatorRegistries.add(registry);
    }

}