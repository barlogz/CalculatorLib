package ua.goit.java.calculator.lib;

import java.util.ArrayList;
import java.util.List;

public class OperandParser implements Parser {

    private List<ValueParser> valueParsers = new ArrayList<>();
    private String parsedExpression;
    private List<Double> operands;
    private char operator;

    @Override
    public void addNewValueParser(ValueParser valueParser) {
        valueParsers.add(valueParser);
    }

    @Override
    public boolean parse(String expression) {

        parsedExpression = expression;
        operator = 0;
        operands = new ArrayList<>();
        boolean isParsed = false;
        String[] splittedExpression = expression.split(" ");

        for (String element : splittedExpression) {
            if (operands.size() == 2) {
                break;
            }
            char firstChar = element.toCharArray()[0];

            if ((firstChar >= '0' && firstChar <= '9') || firstChar == '#' || (firstChar == '-' && element.length() > 1)) {
                double operand = 0;

                if (firstChar == '#') {
                    ValueParser valueParser = null;

                    for (ValueParser parser : valueParsers) {
                        if (parser.dataTypeIdentitySymbol() == element.charAt(1)) {
                            valueParser = parser;
                        }
                    }

                    if (valueParser == null) {
                        throw new NumberFormatException("Such data type is not supported" + element.charAt(1));
                    }

                    try {
                        operand = valueParser.parse(element.substring(2));
                        isParsed = true;
                    } catch (NumberFormatException ignored) {
                    }

                } else {
                    for (ValueParser valueParser : valueParsers) {
                        try {
                            operand = valueParser.parse(element);
                            isParsed = true;
                            break;
                        } catch (NumberFormatException ignored) {
                        }
                    }
                }

                if (isParsed) {
                    operands.add(operand);
                } else {
                    throw new NumberFormatException("Wrong value: " + element);
                }
            } else if (element.length() == 1) {
                operator = element.charAt(0);
            } else {
                throw new NumberFormatException("Wrong value: " + element);
            }
        }
        return true;
    }

    @Override
    public String getParsedExpression() {
        return parsedExpression;
    }

    @Override
    public List<Double> getOperands() {
        return operands;
    }

    @Override
    public char getOperator() {
        return operator;
    }
}
