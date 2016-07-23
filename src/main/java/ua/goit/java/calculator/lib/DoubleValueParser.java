package ua.goit.java.calculator.lib;

/**
 * Created by Roman on 23.07.2016.
 */
public class DoubleValueParser implements ValueParser {

    private int precision;

    @Override
    public double parse(String stringValue) throws NumberFormatException{
        return Double.parseDouble(stringValue);
    }

    @Override
    public String getString(double value) {
        return Double.toString(value);
    }

    @Override
    public void setPrecision(int precision) {
        this.precision = precision;
    }

    @Override
    public char dataTypeIdentitySymbol() {
        return 'd';
    }
}
