
public abstract class Coin implements ICalculate {
    abstract double getConversionValue();
    public double calculate(double value) {
        double result = getConversionValue() * value;
        return result;
    }
}




