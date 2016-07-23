package ua.goit.java.calculator.lib;

public interface ValueParser {

    double parse(String stringValue);

    String getString(double value);

    void setPrecision(int precision);

    char dataTypeIdentitySymbol();
}
