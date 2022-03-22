package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WindowTwo {

    @FXML
    private Button Page2_Calculate;

    @FXML
    private TextArea ValueB;

    @FXML
    private TextArea ValueG;

    @FXML
    private TextArea ValueS;

    @FXML
    private TextArea ValueT;

    @FXML
    private TextArea ValueV;

    @FXML
    private TextArea ValueY;

    @FXML
    private TextArea resultTwo;

    @FXML
    void initialize() {

        Page2_Calculate.setOnAction(event -> {

            String lineV = ValueV.getText();
            lineV = lineV.replaceAll(" ", "");
            String lineB = ValueB.getText();
            lineB = lineB.replace(" ", "");
            String lineG = ValueG.getText();
            lineG = lineG.replaceAll(" ", "");
            String lineS = ValueS.getText();
            lineS = lineS.replaceAll(" ", "");
            String lineY = ValueY.getText();
            lineY = lineY.replaceAll(" ", "");
            String lineT = ValueT.getText();
            lineT = lineT.replaceAll(" ", "");


            try {
                double valueV = Double.parseDouble(lineV);
                double valueB = Double.parseDouble(lineB);
                double valueG = Double.parseDouble(lineG);
                double valueS = Double.parseDouble(lineS);
                double valueY = Double.parseDouble(lineY);
                double valueT = Double.parseDouble(lineT);

                double result = calculationSecond(valueV, valueB, valueG, valueS, valueY, valueT);
                resultTwo.setText("Результат: " + result);
            } catch (NumberFormatException ex) {
                String exception = ex.toString();   //

                String substring = "";
                Pattern pattern = Pattern.compile("\\Qjava.lang.NumberFormatException: For input string:\\E");
                Matcher matcher = pattern.matcher(exception);
                if (matcher.find())  substring = exception.substring(50);

                switch (exception){
                    case ("java.lang.NumberFormatException: empty String"):
                        resultTwo.setText("Некоректний ввод. Є порожій рядок");
                        break;
                    case ("java.lang.NumberFormatException: multiple points"):
                        resultTwo.setText("Некоректний ввод. Присутнній символ багатокрапки");
                        break;
                    default:
                        resultTwo.setText("Некоректний ввод у рядку: " + substring);
                }

            }
        });
    }

    private static double calculationSecond(double v, double b, double g, double s, double y, double t) {
        double result;

        if (v * b == 0) {
            String massage = "НЕ ВИКОНУЄТЬСЯ УМОВА: v * b = 0 ";

//        result = Double.parseDouble(massage);
            return Double.parseDouble(massage);
        }

        double yt = y * t;
        double vb = v * b;
        double firstPart = 24 * g - s * b;
        result = Math.sqrt(firstPart - yt/vb);
        return result;
    }
}