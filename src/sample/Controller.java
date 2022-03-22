package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Controller {

    @FXML
    private TextArea FieldValueG;

    @FXML
    private TextArea FieldValueH;

    @FXML
    private TextArea FieldValueX;

    @FXML
    private TextArea FieldValueY;

    @FXML
    private TextArea FieldValueZ;

    @FXML
    private Button Page1_Calculate;

    @FXML
    private Button Task2Button;

    @FXML
    private Button Task3Button;

    @FXML
    private TextArea resultOne;

    @FXML
    public void initialize() {

        Task3Button.setOnAction(event -> {

            FXMLLoader loaderSecond = new FXMLLoader();
            loaderSecond.setLocation(getClass().getResource("/sample/part3.fxml"));

            try {
                loaderSecond.load();
            } catch (IOException exception) {
                exception.printStackTrace();
            }

            Parent parent2 = loaderSecond.getRoot();
            Stage stage2 = new Stage();
            stage2.setScene(new Scene(parent2));
            stage2.showAndWait();


        });

        Task2Button.setOnAction(event1 -> {

            FXMLLoader loaderFirst = new FXMLLoader();
            loaderFirst.setLocation(getClass().getResource("/sample/part2.fxml"));

            try {
                loaderFirst.load();
            } catch (IOException exception) {
                exception.printStackTrace();
            }
            Parent parent = loaderFirst.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(parent));
            stage.showAndWait();
        });
        Page1_Calculate.setOnAction(event -> {

            String lineX = FieldValueX.getText();
            lineX = lineX.replaceAll(" ", "");
            String lineY = FieldValueY.getText();
            lineY = lineY.replaceAll(" ", "");
            String lineZ = FieldValueZ.getText();
            lineZ = lineZ.replaceAll(" ", "");
            String lineG = FieldValueG.getText();
            lineG = lineG.replaceAll(" ", "");
            String lineH = FieldValueH.getText();
            lineH = lineH.replaceAll(" ", "");

            try {
                double valueX = Double.parseDouble(lineX);
                double valueY = Double.parseDouble(lineY);
                double valueZ = Double.parseDouble(lineZ);
                double valueG = Double.parseDouble(lineG);
                double valueH = Double.parseDouble(lineH);


                double result = calculationPartOne(valueX, valueY, valueZ, valueG, valueH);
                String finalResult = Double.toString(result);
                resultOne.setText("Результат: " + finalResult);
            } catch (NumberFormatException ex) {   //NumberFormatException
                String exception = ex.toString();   //

                String substring = "";      //string where result of REGULAR EXPRESSION PUTS
                Pattern pattern = Pattern.compile("\\Qjava.lang.NumberFormatException: For input string:\\E");
                Matcher matcher = pattern.matcher(exception);
                if (matcher.find())  substring = exception.substring(50);

                switch (exception){
                    case ("java.lang.NumberFormatException: empty String"):
                        resultOne.setText("Некоректний ввод. Є порожій рядок");
                        break;
                    case ("java.lang.NumberFormatException: multiple points"):
                        resultOne.setText("Некоректний ввод. Присутнній символ багатокрапки");
                        break;
                    default:
                        resultOne.setText("Некоректний ввод у рядку: " + substring);
                }
//                resultOne.setText("" + ex);
//                System.out.println("Incorrect input. " + exception);
            }
        });


    }

    private static double calculationPartOne(double x, double y, double z, double g, double h) {

        double result;
//        if (g * h == 0) {
//            String zeroDiv = "Помилка. Ділення на нуль.";
////                System.out.println("Error. Zero division.");
//            return Double.parseDouble(zeroDiv);
//        }

        double pow = g + h;
        double highResult = Math.pow((z + y), pow);
        double lowResult = Math.pow((z + x), pow / (g * h));
        result = highResult / lowResult;
        System.out.println(result);

        return result;
    }

}
