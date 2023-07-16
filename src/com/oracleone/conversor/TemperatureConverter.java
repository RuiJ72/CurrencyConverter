package com.oracleone.conversor;

public class TemperatureConverter {
    public double convertTemperature(double temperature, String fromUnit, String toUnit) {
        double convertedTemperature = 0;

        if (fromUnit.equals(toUnit)) {
            convertedTemperature = temperature;
        } else if (fromUnit.equals("Celsius")) {
            convertedTemperature = convertFromCelsius(temperature, toUnit);
        } else if (fromUnit.equals("Fahrenheit")) {
            convertedTemperature = convertFromFahrenheit(temperature, toUnit);
        } else if (fromUnit.equals("Kelvin")) {
            convertedTemperature = convertFromKelvin(temperature, toUnit);
        }

        return convertedTemperature;
    }

    private double convertFromCelsius(double celsius, String toUnit) {
        switch (toUnit) {
            case "Fahrenheit":
                return (celsius * 9 / 5) + 32;
            case "Kelvin":
                return celsius + 273.15;
            default:
                return celsius;
        }
    }

    private double convertFromFahrenheit(double fahrenheit, String toUnit) {
        switch (toUnit) {
            case "Celsius":
                return (fahrenheit - 32) * 5 / 9;
            case "Kelvin":
                return (fahrenheit + 459.67) * 5 / 9;
            default:
                return fahrenheit;
        }
    }

    private double convertFromKelvin(double kelvin, String toUnit) {
        switch (toUnit) {
            case "Celsius":
                return kelvin - 273.15;
            case "Fahrenheit":
                return (kelvin * 9 / 5) - 459.67;
            default:
                return kelvin;
        }
    }
}

