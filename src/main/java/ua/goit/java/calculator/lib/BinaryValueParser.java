package ua.goit.java.calculator.lib;

public class BinaryValueParser  implements ValueParser{


    @Override
    public double parse(String stringValue) throws NumberFormatException {
        return Integer.parseInt(stringValue, 2);
    }

    @Override
    public String getString(double value) {
        return Double.toString(value);
    }

    @Override
    public void setPrecision(int precision) {
    }

    @Override
    public char dataTypeIdentitySymbol() {
        return 'b';
    }
}
