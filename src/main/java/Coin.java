
public abstract class Coin implements ICalculate {
    abstract double getConversionValue();
    double conversionResult;
    public double calculate(double value) {
        double result = getConversionValue() * value;
        this.conversionResult = result;
        return result;
    }

    public double getConversionResult() {
        return conversionResult;
    }
}




