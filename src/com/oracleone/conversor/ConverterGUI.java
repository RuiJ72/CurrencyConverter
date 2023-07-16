package com.oracleone.conversor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConverterGUI {
    private CurrencyConverter currencyConverter;
    private DistanceConverter distanceConverter;
    private TemperatureConverter temperatureConverter;

    private JFrame frame;
    private JComboBox<String> converterDropdown;
    private JLabel resultLabel;
    private JTextField valueField;
    private JComboBox<String> fromDropdown;
    private JComboBox<String> toDropdown;
    private JButton convertButton;

    public ConverterGUI() {
        currencyConverter = new CurrencyConverter();
        distanceConverter = new DistanceConverter();
        temperatureConverter = new TemperatureConverter();

        frame = new JFrame("Conversor");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 250);

        String[] converters = {"Conversor de Moeda", "Conversor de Distâncias", "Conversor de Temperaturas"};
        converterDropdown = new JComboBox<>(converters);
        converterDropdown.setBounds(10, 10, 200, 30);
        frame.add(converterDropdown);

        resultLabel = new JLabel("");
        resultLabel.setBounds(10, 180, 380, 30);
        resultLabel.setHorizontalAlignment(SwingConstants.CENTER);
        frame.add(resultLabel);

        converterDropdown.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateFields();
            }
        });

        frame.setLayout(null);
        frame.setVisible(true);
    }

    private void updateFields() {
        String selectedConverter = converterDropdown.getSelectedItem().toString();

        if (frame.getContentPane() != null) {
            frame.getContentPane().removeAll();
            frame.revalidate();
            frame.repaint();
        }

        switch (selectedConverter) {
            case "Conversor de Moeda":
                addCurrencyConverterFields();
                break;
            case "Conversor de Distâncias":
                addDistanceConverterFields();
                break;
            case "Conversor de Temperaturas":
                addTemperatureConverterFields();
                break;
        }

        frame.add(converterDropdown);
        frame.add(resultLabel);
        frame.revalidate();
        frame.repaint();
    }

    private void addCurrencyConverterFields() {
        String[] currencies = {"BRL", "USD", "EUR", "GBP", "ARS", "CPL"};
        fromDropdown = new JComboBox<>(currencies);
        fromDropdown.setBounds(10, 50, 120, 30);
        frame.add(fromDropdown);

        toDropdown = new JComboBox<>(currencies);
        toDropdown.setBounds(270, 50, 120, 30);
        frame.add(toDropdown);

        valueField = new JTextField();
        valueField.setBounds(140, 50, 120, 30);
        frame.add(valueField);

        convertButton = new JButton("Converter");
        convertButton.setBounds(150, 90, 100, 30);
        frame.add(convertButton);

        convertButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String fromCurrency = fromDropdown.getSelectedItem().toString();
                String toCurrency = toDropdown.getSelectedItem().toString();
                try {
                    double amount = Double.parseDouble(valueField.getText());
                    double result = currencyConverter.convertCurrency(amount, fromCurrency, toCurrency);
                    resultLabel.setText(String.format("%.2f %s = %.2f %s", amount, fromCurrency, result, toCurrency));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Digite um valor válido.");
                }
            }
        });
    }

    private void addDistanceConverterFields() {
        String[] units = {"KM", "Miles"};
        fromDropdown = new JComboBox<>(units);
        fromDropdown.setBounds(10, 50, 120, 30);
        frame.add(fromDropdown);

        toDropdown = new JComboBox<>(units);
        toDropdown.setBounds(270, 50, 120, 30);
        frame.add(toDropdown);

        valueField = new JTextField();
        valueField.setBounds(140, 50, 120, 30);
        frame.add(valueField);

        convertButton = new JButton("Converter");
        convertButton.setBounds(150, 90, 100, 30);
        frame.add(convertButton);

        convertButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String fromUnit = fromDropdown.getSelectedItem().toString();
                String toUnit = toDropdown.getSelectedItem().toString();
                try {
                    double amount = Double.parseDouble(valueField.getText());
                    double result = distanceConverter.convertDistance(amount, fromUnit, toUnit);
                    resultLabel.setText(String.format("%.2f %s = %.2f %s", amount, fromUnit, result, toUnit));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Digite um valor válido.");
                }
            }
        });
    }

    private void addTemperatureConverterFields() {
        String[] units = {"Celsius", "Fahrenheit", "Kelvin"};
        fromDropdown = new JComboBox<>(units);
        fromDropdown.setBounds(10, 50, 120, 30);
        frame.add(fromDropdown);

        toDropdown = new JComboBox<>(units);
        toDropdown.setBounds(270, 50, 120, 30);
        frame.add(toDropdown);

        valueField = new JTextField();
        valueField.setBounds(140, 50, 120, 30);
        frame.add(valueField);

        convertButton = new JButton("Converter");
        convertButton.setBounds(150, 90, 100, 30);
        frame.add(convertButton);

        convertButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String fromUnit = fromDropdown.getSelectedItem().toString();
                String toUnit = toDropdown.getSelectedItem().toString();
                try {
                    double temperature = Double.parseDouble(valueField.getText());
                    double result = temperatureConverter.convertTemperature(temperature, fromUnit, toUnit);
                    resultLabel.setText(String.format("%.2f %s = %.2f %s", temperature, fromUnit, result, toUnit));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Digite um valor válido.");
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ConverterGUI();
            }
        });
    }
}

