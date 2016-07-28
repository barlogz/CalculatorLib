package ua.goit.java.calculator.lib;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Spring java-based config file
 * Created by Roman D. on 28.07.2016.
 */
@Configuration
public class AppConfigCalculator {

    @Bean
    public Calculator calculator(UnaryOperationProvider unaryOperationProvider,
                                 BinaryOperationProvider binaryOperationProvider, Parser parser) {
        Calculator calculator = new Calculator();
        calculator.setBinaryOperationsSet(binaryOperationProvider.getBinaryOperations());
        calculator.setUnaryOperationSet(unaryOperationProvider.getUnaryOperations());
        calculator.setParser(parser);

        return calculator;
    }

    @Bean
    public UnaryOperationProvider unaryOperationProvider() {
        SimpleUnaryOperationProvider simpleUnaryOperationProvider = new SimpleUnaryOperationProvider();
        simpleUnaryOperationProvider.init();

        return simpleUnaryOperationProvider;
    }

    @Bean
    public BinaryOperationProvider binaryOperationProvider() {
        SimpleBinaryOperationProvider simpleBinaryOperationProvider= new SimpleBinaryOperationProvider();
        simpleBinaryOperationProvider.init();

        return simpleBinaryOperationProvider;
    }

    @Bean
    public Parser parser() {
        OperandParser operandParser = new OperandParser();
        operandParser.addNewValueParser(new DoubleValueParser());
        operandParser.addNewValueParser(new BinaryValueParser());

        return operandParser;
    }

    @Bean
    public OperandParser operandParser() {
        return new OperandParser();
    }
}
