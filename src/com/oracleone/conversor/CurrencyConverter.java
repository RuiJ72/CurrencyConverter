package com.oracleone.conversor;

public class CurrencyConverter {
    private static final double USD_TO_BRL = 4.80;
    private static final double EUR_TO_BRL = 0.19;
    private static final double GBP_TO_BRL = 0.16;
    private static final double ARS_TO_BRL = 55.32;
    private static final double CPL_TO_BRL = 168.95;

    public double convertCurrency(double amount, String fromCurrency, String toCurrency) {
        double convertedAmount = 0;

        if (fromCurrency.equals(toCurrency)) {
            convertedAmount = amount;
        } else if (fromCurrency.equals("BRL")) {
            convertedAmount = convertFromBRL(amount, toCurrency);
        } else if (toCurrency.equals("BRL")) {
            convertedAmount = convertToBRL(amount, fromCurrency);
        }

        return convertedAmount;
    }

    private double convertFromBRL(double amount, String toCurrency) {
        switch (toCurrency) {
            case "USD":
                return amount / USD_TO_BRL;
            case "EUR":
                return amount / EUR_TO_BRL;
            case "GBP":
                return amount / GBP_TO_BRL;
            case "ARS":
                return amount / ARS_TO_BRL;
            case "CPL":
                return amount / CPL_TO_BRL;
            default:
                return amount;
        }
    }

    private double convertToBRL(double amount, String fromCurrency) {
        switch (fromCurrency) {
            case "USD":
                return amount * USD_TO_BRL;
            case "EUR":
                return amount * EUR_TO_BRL;
            case "GBP":
                return amount * GBP_TO_BRL;
            case "ARS":
                return amount * ARS_TO_BRL;
            case "CPL":
                return amount * CPL_TO_BRL;
            default:
                return amount;
        }
    }
}
