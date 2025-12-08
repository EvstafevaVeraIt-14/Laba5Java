package ru.evstafeva.fraction;

public class CachedFraction implements FractionMethods {
    private final FractionMethods fraction;
    private Double cachedValue;
    private boolean isCacheValid;

    public CachedFraction(FractionMethods fraction) {
        this.fraction = fraction;
        this.isCacheValid = false;
    }

    public CachedFraction(int numerator, int denominator) {
        this(new Fraction(numerator, denominator));
    }

    @Override
    public double getDecimalValue() {
        if (!isCacheValid) {
            cachedValue = fraction.getDecimalValue();
            isCacheValid = true;
        }
        return cachedValue;
    }

    @Override
    public void setNumeratorAndDenominator(int numerator, int denominator) {
        fraction.setNumeratorAndDenominator(numerator, denominator);
        invalidateCache();
    }

    private void invalidateCache() {
        isCacheValid = false;
        cachedValue = null;
    }

    @Override
    public String toString() {
        return fraction.toString();
    }
}