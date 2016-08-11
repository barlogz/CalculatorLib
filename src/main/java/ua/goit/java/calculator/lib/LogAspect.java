package ua.goit.java.calculator.lib;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.*;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;

@Aspect
public class LogAspect {

    public static final Logger logger = LogManager.getLogger();

    @Before("execution(* Calculator.compute(String)) && args(expression)")
    public void onComputeBefore(String expression) {
        logger.info("Calculator: Method operate with expression: '" + expression + "'");
    }

    @Around(value = "execution(* ua.goit.java.calculator.lib.Calculator.compute(String))")
    public Object onCompute(ProceedingJoinPoint pjp) throws Throwable {
        logger.traceEntry("Calculator: Method '" + pjp.getSignature().getName() + "' called with parameters: "
                + Arrays.toString(pjp.getArgs()));
        Object result = pjp.proceed();
        logger.traceExit("Calculator: Method '" + pjp.getSignature().getName() + "' is finished");
        return result;
    }

    @AfterThrowing(pointcut = "execution(* ua.goit.java.calculator.lib.Calculator.compute(String)) && args(expression)",
                    throwing = "exception")
    public void onComputeExceptions(String expression, Throwable exception) {
        logger.error("Calculator: Thrown exception: " + exception + ". Expression: '" + expression + "'");
    }

    @AfterReturning(pointcut = "execution(* Calculator.compute(String)) && args(expression)", returning = "result",
                    argNames = "expression,result")
    public void onComputeOk(String expression, double result) {
        logger.info("Calculator: Expression '" + expression + "' calculated successful. Result = " + result);
    }

    @Before("execution(* ua.goit.java.calculator.lib.Calculator.compute(String)) && args(expression)")
    public void onParseBefore(String expression) {
        logger.info("Parser: Expression '" + expression + "' is processed...");
    }

    @AfterThrowing(pointcut = "execution(* Parser.parse(String)) && args(expression)", throwing = "exception")
    public void onParseAfterThrowing(String expression, Throwable exception) {
        logger.error("Parser: Thrown exception: " + exception + ". '"+ expression + "' can not be processed");
    }

    @AfterReturning(pointcut = "execution(* Parser.parse(String)) && args(expression)")
    public void onParseAfterReturning(String expression) {
        logger.info("Parser: Expression '" + expression + "' parsed successful");
    }
}
