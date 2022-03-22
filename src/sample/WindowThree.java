package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class WindowThree {

    @FXML
    private Button Page3_Calculate;

    @FXML
    private TextArea constValue;

    @FXML
    private TextArea inputValue;

    @FXML
    private TextArea resultThree;

    @FXML
    void initialize() {

        Page3_Calculate.setOnAction(event -> {

            String lineConst = constValue.getText();
            lineConst = lineConst.replaceAll(" ", "");
            String lineInput = inputValue.getText();
            lineInput = lineInput.replaceAll(" ", "");

            try {
                double valueConst = Double.parseDouble(lineConst);
                double valueInput = Double.parseDouble(lineInput);

                double result = calculationThree(valueInput, valueConst);
                resultThree.setText("Результат: " + result);

            } catch (NumberFormatException ex) {

                String exception = ex.toString();   //

                String substring = "";
                Pattern pattern = Pattern.compile("\\Qjava.lang.NumberFormatException: For input string:\\E");
                Matcher matcher = pattern.matcher(exception);
                if (matcher.find())  substring = exception.substring(50);

                switch (exception){
                    case ("java.lang.NumberFormatException: empty String"):
                        resultThree.setText("Некоректний ввод. Є порожій рядок");
                        break;
                    case ("java.lang.NumberFormatException: multiple points"):
                        resultThree.setText("Некоректний ввод. Присутнній символ багатокрапки");
                        break;
                    default:
                        resultThree.setText("Некоректний ввод у рядку: " + substring);
                }
            }
        });

    }

    private static double calculationThree(double inputValue, double constIncrement) {
        double result = 1;

        if (inputValue == 0) {
            String massage = "Введіть не нульво значення у першому полі";

            return Double.parseDouble(massage);
        }

        for (int i = 0; i < 15; i++) {
            result *= 1 / inputValue;
            inputValue += constIncrement;
        }

        return result;
    }
}