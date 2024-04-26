import java.util.Random;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class T504 extends Application {

    TextField guessField = new TextField();
    Label hintLabel = new Label();
    Label attemptsLabel = new Label();
    int counter = 0;
    int numberToGuess = -1;    

    @Override
    public void start(Stage primaryStage) {            

        guessField.setPromptText("Press New Game Button!");

        Button btnNewGame = new Button("New Game");        
        btnNewGame.setOnAction(actionEvent -> {gameSetup();});

        Button btnGuess = new Button("Guess");
        btnGuess.setOnAction(actionEvent -> {gamePlay();});

        VBox root = new VBox();
        root.getChildren().addAll(guessField, btnNewGame, btnGuess, hintLabel, attemptsLabel);
        root.setSpacing(5);
        root.setAlignment(Pos.CENTER);

        Scene scene = new Scene(root, 300, 250);

        primaryStage.setTitle("Bolo, Princess Nicole T.");
        primaryStage.setScene(scene);
        primaryStage.show();

        btnNewGame.requestFocus();
    }    

    public static void main(String[] args) {
        launch(args);
    }


    public void gameSetup()
    {
        guessField.setPromptText("Enter your guess");
        counter = 0;

        Random random = new Random();
        numberToGuess = random.nextInt(100) + 1;
        System.out.println("Number to guess: " + numberToGuess);
        hintLabel.setText("");
        attemptsLabel.setText("");
    }

    public void gamePlay()
    {
        int guess = Integer.parseInt(guessField.getText());

        counter++;

        if(counter == 7)
        {
            guessField.setPromptText("Game over! You lose!");
            guessField.setText("");
        }
        else{
            if(guess == numberToGuess)
            {
                guessField.setPromptText("Congratulations! " + guess + " is correct!");
                guessField.setText("");
            }
            else if(guess < numberToGuess)
            {
                hintLabel.setText("Try a higher number.");
                guessField.setText("");
            }
            else
            {
                hintLabel.setText("Try a lower number.");
                guessField.setText("");
            }        
        }  

        attemptsLabel.setText("Attempts: " + counter);      
    }
}
