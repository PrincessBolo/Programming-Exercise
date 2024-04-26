import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class T505 extends Application {
    @Override
    public void start(Stage stage) {
        // create and configure text fields for user entry
        TextField textField1 = new TextField();
        textField1.setMaxWidth(250);

        TextField textField2 = new TextField();
        textField2.setMaxWidth(250);

        // create and configure a label to display the output
        Label resultLabel = new Label();
        resultLabel.setTextFill(Color.RED);
        resultLabel.setFont(Font.font("Arial", 20));

        // create buttons for operations
        Button addButton = new Button("+");
        addButton.setOnAction(e -> {
            try {
                int num1 = Integer.parseInt(textField1.getText());
                int num2 = Integer.parseInt(textField2.getText());
                int result = num1 + num2;
                resultLabel.setText("Result: " + result);
            } catch (NumberFormatException ex) {
                resultLabel.setText("Invalid input");
            }
        });

        Button subtractButton = new Button("-");
        subtractButton.setOnAction(e -> {
            try {
                int num1 = Integer.parseInt(textField1.getText());
                int num2 = Integer.parseInt(textField2.getText());
                int result = num1 - num2;
                resultLabel.setText("Result: " + result);
            } catch (NumberFormatException ex) {
                resultLabel.setText("Invalid input");
            }
        });

        Button multiplyButton = new Button("x");
        multiplyButton.setOnAction(e -> {
            try {
                int num1 = Integer.parseInt(textField1.getText());
                int num2 = Integer.parseInt(textField2.getText());
                int result = num1 * num2;
                resultLabel.setText("Result: " + result);
            } catch (NumberFormatException ex) {
                resultLabel.setText("Invalid input");
            }
        });

        Button divideButton = new Button("/");
        divideButton.setOnAction(e -> {
            try {
                int num1 = Integer.parseInt(textField1.getText());
                int num2 = Integer.parseInt(textField2.getText());
                if (num2 == 0) {
                    resultLabel.setText("Cannot divide by zero");
                } else {
                    double result = (double) num1 / num2;
                    resultLabel.setText("Result: " + result);
                }
            } catch (NumberFormatException ex) {
                resultLabel.setText("Invalid input");
            }
        });

        // create and configure a VBox to hold our components
        VBox root = new VBox(10); // spacing of 10 pixels
        root.setAlignment(Pos.CENTER);

        // add the components to the VBox
        root.getChildren().addAll(textField1, textField2, addButton, subtractButton, multiplyButton, divideButton, resultLabel);

        // create a new scene
        Scene scene = new Scene(root, 350, 300);

        // add the scene to the stage, then configure the stage and make it visible
        stage.setScene(scene);
        stage.setTitle("Bolo, Princess Nicole T.");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
