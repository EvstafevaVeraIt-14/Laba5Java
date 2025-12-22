package ru.evstafeva.fraction;

public class CachedFraction extends Fraction {
    private Double cachedDecimalValue = null;

    public CachedFraction(int numerator, int denominator) {
        super(numerator, denominator);
    }

    @Override
    public double getDecimalValue() {
        if (cachedDecimalValue == null) {
            cachedDecimalValue = super.getDecimalValue();
        }
        return cachedDecimalValue;
    }

    @Override
    public void setNumeratorAndDenominator(int numerator, int denominator) {
        super.setNumeratorAndDenominator(numerator, denominator);
        cachedDecimalValue = null;
    }

    @Override
    public void setNumerator(int numerator) {
        super.setNumerator(numerator);
        cachedDecimalValue = null;
    }

    @Override
    public void setDenominator(int denominator) {
        super.setDenominator(denominator);
        cachedDecimalValue = null;
    }

    public boolean hasCachedValue() {
        return cachedDecimalValue != null;
    }

    public Double getCachedValue() {
        return cachedDecimalValue;
    }
}