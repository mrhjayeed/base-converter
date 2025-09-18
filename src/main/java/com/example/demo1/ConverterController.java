package com.example.demo1;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class ConverterController implements Initializable {
    @FXML
    private TextField inputField;

    @FXML
    private Text outputText;

    @FXML
    private ComboBox<String> colorComboBox;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Initialize ComboBox with color options
        colorComboBox.getItems().addAll("Red", "Green", "Blue");
//        colorComboBox.setValue("Red"); // Set default value
//        outputText.setFill(Color.RED); // Set default text color
    }

    @FXML
    protected void convertToBinary() {
        try {
            String input = inputField.getText().trim();
            if (input.isEmpty()) {
                outputText.setText("Please enter a decimal number");
                return;
            }

            int decimal = Integer.parseInt(input);
            String binary = Integer.toBinaryString(decimal);
            outputText.setText("Binary: " + binary);
        } catch (NumberFormatException e) {
            outputText.setText("Invalid input! Please enter a valid decimal number.");
        }
    }

    @FXML
    protected void convertToOctal() {
        try {
            String input = inputField.getText().trim();
            if (input.isEmpty()) {
                outputText.setText("Please enter a decimal number");
                return;
            }

            int decimal = Integer.parseInt(input);
            String octal = Integer.toOctalString(decimal);
            outputText.setText("Octal: " + octal);
        } catch (NumberFormatException e) {
            outputText.setText("Invalid input! Please enter a valid decimal number.");
        }
    }

    @FXML
    protected void convertToHex() {
        try {
            String input = inputField.getText().trim();
            if (input.isEmpty()) {
                outputText.setText("Please enter a decimal number");
                return;
            }

            int decimal = Integer.parseInt(input);
            String hex = Integer.toHexString(decimal).toUpperCase();
            outputText.setText("Hexadecimal: " + hex);
        } catch (NumberFormatException e) {
            outputText.setText("Invalid input! Please enter a valid decimal number.");
        }
    }

    @FXML
    protected void clearFields() {
        inputField.clear();
        outputText.setText("");
    }

    @FXML
    protected void changeTextColor() {
        String selectedColor = colorComboBox.getValue();
        if (selectedColor != null) {
            switch (selectedColor) {
                case "Red":
                    outputText.setFill(Color.RED);
                    break;
                case "Green":
                    outputText.setFill(Color.GREEN);
                    break;
                case "Blue":
                    outputText.setFill(Color.BLUE);
                    break;
            }
        }
    }
}