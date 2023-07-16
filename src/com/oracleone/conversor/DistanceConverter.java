package com.oracleone.conversor;

public class DistanceConverter {
    private static final double KM_TO_MILES = 0.621371;

    public double convertDistance(double amount, String fromUnit, String toUnit) {
        double convertedAmount = 0;

        if (fromUnit.equals(toUnit)) {
            convertedAmount = amount;
        } else if (fromUnit.equals("KM") && toUnit.equals("Miles")) {
            convertedAmount = amount * KM_TO_MILES;
        } else if (fromUnit.equals("Miles") && toUnit.equals("KM")) {
            convertedAmount = amount / KM_TO_MILES;
        }

        return convertedAmount;
    }
}
