public class USD extends Coin {
    private final double conversionValue = 3.52;

    @Override
    double getConversionValue() {
        return conversionValue;
    }
}
