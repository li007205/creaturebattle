package LastLab;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class timerGame extends Application {

    private Group root;
    private ToggleGroup questionGroup;
    private Label timerLabel;
    private Timeline timer;
    private int remainingTime;
    private Question questionManager;
    private Answer answerManager;
    private Rectangle questionBox;
    private Label questionLabel;
    private Button nextButton;
    private Button submitButton;
    private Label feedbackLabel;
    private int correctCount = 0;
    private int totalQuestions = 10; 
    private int currentQuestion = 0;
    private String correctAnswer; 
  

  
    public void start(Stage stage) {
        StartScreen(stage);
    }

    private void StartScreen(Stage stage) {
  
        Group startRoot = new Group();
        Button startButton = new Button("Start Game");
        startButton.setTranslateX(350);
        startButton.setTranslateY(400);
        startButton.setStyle("-fx-background-color: #85B708; -fx-text-fill: white; -fx-font-size: 16px;");
        startButton.setOnAction(this::handleStartGame);

        Label title = new Label("Welcome to Timer Game");
        title.setTranslateX(280);
        title.setTranslateY(300);
        title.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");

        startRoot.getChildren().addAll(startButton, title);
        Scene startScene = new Scene(startRoot, 800, 800);
        stage.setScene(startScene);
        stage.setTitle("Timer Game");
        stage.show();
    }

    private void handleStartGame(ActionEvent event) {
        Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        showGameScreen(stage);
    }

    private void showGameScreen(Stage stage) {
        root = new Group();
        questionGroup = new ToggleGroup();

        try {
            questionManager = new Question();
            answerManager = new Answer();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        // Timer label
        timerLabel = new Label("Remaining Time: 20");
        timerLabel.setTranslateX(50);
        timerLabel.setTranslateY(50);
        root.getChildren().add(timerLabel);

        // Question box
        questionBox = new Rectangle(50, 100, 700, 200);
        questionBox.setFill(Color.TRANSPARENT);
        root.getChildren().add(questionBox);

        // Question label
        questionLabel = new Label();
        questionLabel.setWrapText(true);
        questionLabel.setMaxWidth(680);
        questionLabel.setTranslateX(60);
        questionLabel.setTranslateY(120);
        root.getChildren().add(questionLabel);

        // Next button
        nextButton = new Button("Next Question");
        nextButton.setTranslateX(350);
        nextButton.setTranslateY(600);
        nextButton.setOnAction(this::handleNextQuestion);
        root.getChildren().add(nextButton);

        // Submit button
        submitButton = new Button("Submit");
        submitButton.setTranslateX(450);
        submitButton.setTranslateY(600);
        submitButton.setOnAction(this::handleSubmit);
        root.getChildren().add(submitButton);

        // Feedback label
        feedbackLabel = new Label();
        feedbackLabel.setTranslateX(350);
        feedbackLabel.setTranslateY(650);
        feedbackLabel.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");
        root.getChildren().add(feedbackLabel);

        // Initialize timer
        initializeTimer();

        // Display the first question
        displayRandomQuestion();

        Scene gameScene = new Scene(root, 800, 800);
      
        stage.setScene(gameScene);
    }

    private void initializeTimer() {
        remainingTime = 20;
        timer = new Timeline(new KeyFrame(Duration.seconds(1), this::handleTimer));
        timer.setCycleCount(Timeline.INDEFINITE);
        timer.play();
    }

    private void handleTimer(ActionEvent event) {
        remainingTime--;
        timerLabel.setText("Remaining Time: " + remainingTime);
        if (remainingTime <= 0) {
            timer.stop();
            timeUp();
        }
    }

    private void displayRandomQuestion() {
        // Manually remove existing RadioButtons
        for (int i = root.getChildren().size() - 1; i >= 0; i--) {
            if (root.getChildren().get(i) instanceof RadioButton) {
                root.getChildren().remove(i);
            }
        }

        feedbackLabel.setText("");
        currentQuestion++;

        if (currentQuestion > totalQuestions) {
            endGame();
            return;
        }

        Random random = new Random();
        int questionType = random.nextInt(0,2); 

        if (questionType == 0) {
            setupMultipleChoice();
        } else {
            setupTrueFalse();
        }
    }

    private void setupMultipleChoice() {
        resetTimer();

        String questionText = questionManager.randomMQuestion();
        int index = questionManager.listIndex();
        correctAnswer = answerManager.getMList(index, 0);


        // random incorrect answers
        ArrayList<String> incorrectAnswers = new ArrayList<>();
        for (int i = 0; i < answerManager.mlist().size(); i++) {
            String possibleAnswer = answerManager.getMList(i, 0);
            if (possibleAnswer != null && !possibleAnswer.equals(correctAnswer)) {
                incorrectAnswers.add(possibleAnswer);
            }
        }

   

        // select options
        Collections.shuffle(incorrectAnswers);
        ArrayList<String> options = new ArrayList<>();
        options.add(correctAnswer);
        options.addAll(incorrectAnswers.subList(0, 3));
        Collections.shuffle(options);

        questionLabel.setText("Multiple Choice: " + questionText);

        RadioButton optionA = new RadioButton("A. " + options.get(0));
        RadioButton optionB = new RadioButton("B. " + options.get(1));
        RadioButton optionC = new RadioButton("C. " + options.get(2));
        RadioButton optionD = new RadioButton("D. " + options.get(3));

        optionA.setToggleGroup(questionGroup);
        optionB.setToggleGroup(questionGroup);
        optionC.setToggleGroup(questionGroup);
        optionD.setToggleGroup(questionGroup);

        positionOptions(optionA, 100, 350);
        positionOptions(optionB, 100, 400);
        positionOptions(optionC, 100, 450);
        positionOptions(optionD, 100, 500);

        root.getChildren().addAll(optionA, optionB, optionC, optionD);
    }

    private void setupTrueFalse() {
        resetTimer();

        String questionText = questionManager.randomTFQuestion();
        correctAnswer = "True";

        questionLabel.setText("True/False: " + questionText);

        RadioButton trueOption = new RadioButton("True");
        RadioButton falseOption = new RadioButton("False");

        trueOption.setToggleGroup(questionGroup);
        falseOption.setToggleGroup(questionGroup);

        positionOptions(trueOption, 100, 350);
        positionOptions(falseOption, 100, 400);

        root.getChildren().addAll(trueOption, falseOption);
    }

    private void positionOptions(RadioButton option, int x, int y) {
        option.setTranslateX(x);
        option.setTranslateY(y);
    }

    private void handleSubmit(ActionEvent event) {
        RadioButton selectedOption = (RadioButton) questionGroup.getSelectedToggle();
        if (selectedOption != null) {
            String selectedText = selectedOption.getText();
            if (selectedText.contains(correctAnswer)) {
                feedbackLabel.setText("Correct!");
                feedbackLabel.setTextFill(Color.GREEN);
                correctCount++;
            } else {
                feedbackLabel.setText("Wrong!");
                feedbackLabel.setTextFill(Color.RED);
            }
        } else {
            feedbackLabel.setText("Please select an answer.");
            feedbackLabel.setTextFill(Color.ORANGE);
        }
    }

    private void handleNextQuestion(ActionEvent event) {
        displayRandomQuestion();
    }

    private void endGame() {
        root.getChildren().clear();
        Label resultLabel = new Label("Game Over! Correct Answers: " + correctCount + "/" + totalQuestions);
        resultLabel.setTranslateX(200);
        resultLabel.setTranslateY(300);
        resultLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");
        root.getChildren().add(resultLabel);

        Rectangle resultBox = new Rectangle(150, 250, 500, 200);
        resultBox.setFill(Color.TRANSPARENT);
        
        root.getChildren().add(resultBox);
        resultLabel.toFront();
       
    }

    private void timeUp() {
        Label timeUpLabel = new Label("Time's up!");
        timeUpLabel.setTranslateX(400);
        timeUpLabel.setTranslateY(400);
        root.getChildren().add(timeUpLabel);
    }

    private void resetTimer() {
        if (timer != null) {
            timer.stop();
            remainingTime = 20;
            timer.playFromStart();
        }
    }
}
