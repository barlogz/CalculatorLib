package ua.goit.java.calculator.lib;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Roman D. on 28.07.2016.
 */
public class CalculatorFactory {

    public static Calculator getCalculator() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("calculator-context.xml", "calculator-aop-context.xml");

        return applicationContext.getBean("calculator", Calculator.class);
    }
}
