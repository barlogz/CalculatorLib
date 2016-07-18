package ua.goit.java.calculator.lib;

public class Calculator {

    private Parser parser;
    private OperatorRegistryProvider operatorRegistry;

    public String calculate(String expression) {
        ParsedExpression parsedExpression = parser.pars(expression);
        DefaultBinaryOperation<?> binaryOperation = operatorRegistry.getOperator(parsedExpression.getOperatorDefinition());
        return binaryOperation.calculate(parsedExpression.getArgs()).toString();
    }

    public void register(OperatorRegistry registry) {
        operatorRegistry.addOperatorRegistry(registry);
    }

}
