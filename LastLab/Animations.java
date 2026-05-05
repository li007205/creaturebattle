package LastLab;

import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;

import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.Group;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.input.KeyEvent;
import javafx.animation.Timeline;

import javafx.event.ActionEvent;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;

import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

public class Animations extends Application {

	private Circle bullet;
	private Stage primaryStage;
	private Group root;
	
	private Rectangle beam;

	static Image imgM1;
	static Image imgM2;

	private ImageView imgVM1;
	private ImageView imgVM2;
	private Label m1L, m2L, hpDisplay1, hpDisplay2, player1Score, player2Score;
	private Button Mselect, Mselect2;
	private Button TFselect, TFselect2;
	private Button submit1, submit2, submit3, submit4;
	private Rectangle box, box2, box3;
	private double height;
	private MonsterManage monManage;
	private MonsterStat stat1, stat2;
	private Player player1, player2;
	private Question question1, question2, question3, question4;
	private RadioButton m1A, m1B, m1C, m1D, t1, f1;
	private RadioButton m2A, m2B, m2C, m2D, t2, f2;
	private Answer ans, ans1, ans2;
	private String[][] ansArray1, ansArray2;
	private Random rand;
	private int p1 = 0, p2 = 1, index1, index2, index3, index4, num1, num2, count1, count2;
	private String hpLabel = "HP: ";
	private ToggleGroup m1Group, m2Group, m3Group, m4Group;
	private Leaderboard board;
	private int size = 0;
	private int scoreX1=305,scoreY1=340,scoreX2=305,scoreY2=390;
	private int margin = 50;

	public void start(Stage stage) {
		primaryStage = stage;
		Image img = new Image("File:image.png", 400, 229, false, false);
		ImageView imgV = new ImageView(img);
		imgV.setTranslateX(100);
		///
		Label label = new Label("Test Your Sustainability Knowledge at");
		label.setTranslateX(imgV.getTranslateX() + 60);
		label.setTranslateY(imgV.getTranslateY() + 250);
		label.setTextFill(Color.BLACK);
		///
		///
		Label l = new Label(" St. Thomas.");
		l.setTranslateX(imgV.getTranslateX() + 265);
		l.setTranslateY(imgV.getTranslateY() + 250);
		l.setTextFill(Color.rgb(133, 183, 8));
		///
		Button animationMode = new Button("2 Player");
        animationMode.setLayoutX(50);
        animationMode.setLayoutY(320);
        animationMode.setPrefWidth(150);
        animationMode.setPrefHeight(30);
        animationMode.setStyle("-fx-background-color: #85B708; -fx-text-fill: white;");
        animationMode.setOnAction(this::player2Mode);

        Button singlePlayerMode = new Button("Single Player");
        singlePlayerMode.setLayoutX(225);
        singlePlayerMode.setLayoutY(320);
        singlePlayerMode.setPrefWidth(150);
        singlePlayerMode.setPrefHeight(30);
        singlePlayerMode.setStyle("-fx-background-color: #85B708; -fx-text-fill: white;");
        singlePlayerMode.setOnAction(this::SinglePlayerMode);

        Button timerGameMode = new Button("Timer Game");
        timerGameMode.setLayoutX(400);
        timerGameMode.setLayoutY(320);
        timerGameMode.setPrefWidth(150);
        timerGameMode.setPrefHeight(30);
        timerGameMode.setStyle("-fx-background-color: #85B708; -fx-text-fill: white;");
        timerGameMode.setOnAction(this::TimerGameMode);
		
		Group root = new Group( imgV, label, l, animationMode, singlePlayerMode,timerGameMode );
		Scene scene = new Scene(root, 600, 400);
		scene.setFill(Color.rgb(244, 244, 244));
	
		stage.setScene(scene);
		stage.show();
		stage.setTitle("Game");
	}

	
	

    private void player2Mode(ActionEvent e) {
    	start1(primaryStage);
    }

    private void SinglePlayerMode(ActionEvent e) {
    	
    	singlePlayer sing = new singlePlayer();
    	
    	Stage singleStage = new Stage();
    	sing.start1(singleStage);
    	
     
    }

    private void TimerGameMode(ActionEvent e) {
    	
    	timerGame tg = new timerGame();
    	
    	Stage tgs = new Stage();
    	tg.start(tgs);
    	
    }
	
	
	
	
	
	
	
	
	
	

	public void start1(Stage stage) {
		try {
			board = new Leaderboard();
			hpDisplay1 = new Label("");
			hpDisplay2 = new Label("");
			ans = new Answer();
			ansArray1 = ans.setDisplayAnswer();
			ansArray2 = ans.setDisplayAnswer();
			submit1 = new Button("submit");
			submit2 = new Button("submit");
			submit3 = new Button("submit");
			submit4 = new Button("submit");
			monManage = new MonsterManage();
			height = 80;
			box3 = new Rectangle(250, 300, 500, 200);
			

			imgM1 = new Image("File:Monster1.png", 300, 200, false, false);// file keyword for windows pc

			imgM2 = new Image("File:Monster2.png", 300, 200, false, false);// file keyword for windows pc

			imgVM1 = Monsters.Monster1();

			imgVM2 = Monsters.Monster2();

			root = new Group();
			Mselect = new Button("Multiple Choice");
			TFselect = new Button("True or False");
			box = new Rectangle(50, 400, 400, 500);
			Mselect.setTranslateX(70);
			Mselect.setTranslateY(550);
			TFselect.setTranslateX(200);
			TFselect.setTranslateY(550);

			Mselect2 = new Button("Multiple Choice");
			TFselect2 = new Button("True or False");
			box2 = new Rectangle(500, 400, 400, 500);
			Mselect2.setTranslateX(500);
			Mselect2.setTranslateY(550);
			TFselect2.setTranslateX(630);
			TFselect2.setTranslateY(550);
			
			//box.setStroke(Color.BLACK);
		//	box2.setStroke(Color.BLACK);
			
			box2.setFill(Color.WHITE);
			box.setFill(Color.WHITE);
			Mselect.setOnAction(this::MquestionButton1);
			TFselect.setOnAction(this::TFquestionButton1);
			Mselect2.setOnAction(this::MquestionButton2);
			TFselect2.setOnAction(this::TFquestionButton2);

//  Monster 1 Label -- Question

			m1L = new Label("M1 Question .......");
			m1L.setPrefWidth(400);
			// System.out.println("height "+ m1L.getHeight());
			m1L.setTranslateX(50);
			m1L.setTranslateY(imgVM1.getTranslateY() + imgVM1.getImage().getHeight());

			root.getChildren().add(m1L);

//  Monster 2 Label - Question

			m2L = new Label("M2 Question .......");
			m2L.setPrefWidth(400);
			m2L.setTranslateX(imgVM2.getTranslateX());
			m2L.setTranslateY(imgVM2.getTranslateY() + imgVM2.getImage().getHeight());

			root.getChildren().add(m2L);

//Buttons for Monster1				

			m1A = new RadioButton("A");
			m1B = new RadioButton("B");
			m1C = new RadioButton("C");
			m1D = new RadioButton("D");

			m1Group = new ToggleGroup();
			m1A.setMaxWidth(400);
			m1B.setMaxWidth(400);
			m1C.setMaxWidth(400);
			m1D.setMaxWidth(400);

			m1A.setWrapText(true);
			m1B.setWrapText(true);
			m1C.setWrapText(true);
			m1D.setWrapText(true);

			m1A.setToggleGroup(m1Group);
			m1B.setToggleGroup(m1Group);
			m1C.setToggleGroup(m1Group);
			m1D.setToggleGroup(m1Group);

			//// A
			m1A.setTranslateX(imgVM1.getTranslateX()-margin);
			m1A.setTranslateY(m1L.getTranslateY() + height + 20);

			root.getChildren().add(m1A);
			//// B
			m1B.setTranslateX(imgVM1.getTranslateX()-margin);
			m1B.setTranslateY(m1L.getTranslateY() + height + 60);

			root.getChildren().add(m1B);
			//// C
			m1C.setTranslateX(imgVM1.getTranslateX()-margin);
			m1C.setTranslateY(m1L.getTranslateY() + height + 100);

			root.getChildren().add(m1C);
			//// C
			m1D.setTranslateX(imgVM1.getTranslateX()-margin);
			m1D.setTranslateY(m1L.getTranslateY() + height + 140);

			t1 = new RadioButton();
			f1 = new RadioButton();
			m3Group = new ToggleGroup();
			t1.setToggleGroup(m3Group);
			f1.setToggleGroup(m3Group);
			t1.setTranslateX(imgVM1.getTranslateX()-margin);
			t1.setTranslateY(m1L.getTranslateY() + height + 20);
			f1.setTranslateX(imgVM1.getTranslateX()-margin);
			f1.setTranslateY(m1L.getTranslateY() + height + 60);
			root.getChildren().add(t1);
			root.getChildren().add(f1);
			root.getChildren().add(submit3);

			root.getChildren().add(m1D);
			submit1.setTranslateY(700);
			submit1.setTranslateX(50);
			submit3.setTranslateY(700);
			submit3.setTranslateX(50);
			root.getChildren().add(submit1);

//Buttons for Monster2		
			// if () {

			// }
			m2A = new RadioButton("A");
			m2B = new RadioButton("B");
			m2C = new RadioButton("C");
			m2D = new RadioButton("D");

			m2Group = new ToggleGroup();
			m2A.setMaxWidth(400);
			m2B.setMaxWidth(400);
			m2C.setMaxWidth(400);
			m2D.setMaxWidth(400);
			
			m2A.setWrapText(true);
			m2B.setWrapText(true);
			m2C.setWrapText(true);
			m2D.setWrapText(true);

			m2A.setToggleGroup(m2Group);
			m2B.setToggleGroup(m2Group);
			m2C.setToggleGroup(m2Group);
			m2D.setToggleGroup(m2Group);

			//// A
			m2A.setTranslateX(imgVM2.getTranslateX());
			m2A.setTranslateY(m2L.getTranslateY() + height + 20);

			root.getChildren().add(m2A);
			//// B
			m2B.setTranslateX(imgVM2.getTranslateX());
			m2B.setTranslateY(m2L.getTranslateY() + height + 60);

			root.getChildren().add(m2B);
			//// C
			m2C.setTranslateX(imgVM2.getTranslateX());
			m2C.setTranslateY(m2L.getTranslateY() + height + 100);

			root.getChildren().add(m2C);
			//// C
			m2D.setTranslateX(imgVM2.getTranslateX());
			m2D.setTranslateY(m2L.getTranslateY() + height + 140);

			t2 = new RadioButton();
			f2 = new RadioButton();
			m4Group = new ToggleGroup();
			t2.setToggleGroup(m4Group);
			f2.setToggleGroup(m4Group);
			t2.setTranslateX(imgVM2.getTranslateX());
			t2.setTranslateY(m2L.getTranslateY() + height + 20);
			f2.setTranslateX(imgVM2.getTranslateX());
			f2.setTranslateY(m2L.getTranslateY() + height + 50);
			root.getChildren().add(t2);
			root.getChildren().add(f2);
			root.getChildren().add(submit4);

			root.getChildren().add(m2D);
			submit2.setTranslateY(700);
			submit2.setTranslateX(500);
			submit4.setTranslateY(700);
			submit4.setTranslateX(500);
			root.getChildren().add(submit2);

			root.getChildren().addAll(imgVM1, imgVM2);

			root.getChildren().add(box);
			root.getChildren().add(Mselect);
			root.getChildren().add(TFselect);
			root.getChildren().add(box2);
			root.getChildren().add(Mselect2);
			root.getChildren().add(TFselect2);

			player1 = new Player("P1");
			player2 = new Player("P2");
			stat1 = new MonsterStat("M1", 100, 20, 20, 20);
			stat2 = new MonsterStat("M2", 100, 20, 20, 20);
			monManage.addList(stat1);
			monManage.addList(stat2);
			hpDisplay1.setText(hpLabel + Integer.toString((int) stat1.getHPCalc()));
			hpDisplay2.setText(hpLabel + Integer.toString((int) stat2.getHPCalc()));
			hpDisplay1.setTranslateX(240);
			hpDisplay1.setTranslateY(150);
			hpDisplay2.setTranslateX(640);
			hpDisplay2.setTranslateY(150);
			hpDisplay1.setFont(new Font(20));
			hpDisplay2.setFont(new Font(20));

			root.getChildren().add(hpDisplay1);
			root.getChildren().add(hpDisplay2);

			submit1.setOnAction(this::MsubmitP1);
			submit2.setOnAction(this::MsubmitP2);
			submit3.setOnAction(this::TFsubmitP1);
			submit4.setOnAction(this::TFsubmitP2);
			root.getChildren().add(box3);
			box3.setFill(null);
			player1Score = new Label();
			player2Score = new Label();
			player1Score.setFont(new Font(30));
			player2Score.setFont(new Font(30));

			Scene scene = new Scene(root, 1000, 900);
			stage.setScene(scene);

			// scene.setOnKeyPressed(this::pressed);

			stage.show();
			stage.setTitle("Attack one");
		} catch (FileNotFoundException e) {

		}

	}

	public void MquestionButton1(ActionEvent e) {
		try {
			
			
			root.getChildren().remove(t1);
			root.getChildren().remove(f1);
			question1 = new Question();
			index1 = question1.listIndex();
			ansArray1 = ans.setDisplayAnswer();
			System.out.println(ans.corrMList().get(index1));
			m1L.setText(question1.randomMQuestion());
			m1L.setWrapText(true);
			root.getChildren().remove(box);
			root.getChildren().remove(Mselect);
			root.getChildren().remove(TFselect);
			m1A.setText(ansArray1[index1][0]);
			m1B.setText(ansArray1[index1][1]);
			m1C.setText(ansArray1[index1][2]);
			m1D.setText(ansArray1[index1][3]);
		} catch (IOException l) {

		}
	}

	public void TFquestionButton1(ActionEvent e) {
		try {
			
			
			root.getChildren().remove(submit1);
			root.getChildren().remove(m1A);
			root.getChildren().remove(m1B);
			root.getChildren().remove(m1C);
			root.getChildren().remove(m1D);
			question1 = new Question();
			index3 = question1.listIndex();
			System.out.println(ans.tfList().get(index1));
			m1L.setText(question1.randomTFQuestion());
			m1L.setWrapText(true);
			root.getChildren().remove(box);
			root.getChildren().remove(Mselect);
			root.getChildren().remove(TFselect);
//			root.getChildren().add(t1);
//			root.getChildren().add(f1);
//			root.getChildren().add(submit3);
			t1.setText("True");
			f1.setText("False");

		} catch (IOException l) {

		}
	}

	public void MquestionButton2(ActionEvent e) {
		try {
			
			
			root.getChildren().remove(t2);
			root.getChildren().remove(f2);
			question2 = new Question();
			index2 = question2.listIndex();
			ansArray1 = ans.setDisplayAnswer();
			System.out.println(ans.corrMList().get(index2));
			m2L.setText(question2.randomMQuestion());
			m2L.setWrapText(true);
			root.getChildren().remove(box2);
			root.getChildren().remove(Mselect2);
			root.getChildren().remove(TFselect2);
			m2A.setText(ansArray2[index2][0]);
			m2B.setText(ansArray2[index2][1]);
			m2C.setText(ansArray2[index2][2]);
			m2D.setText(ansArray2[index2][3]);
		} catch (IOException l) {

		}
	}

	public void TFquestionButton2(ActionEvent e) {
		try {
			
			
			root.getChildren().remove(submit2);
			root.getChildren().remove(m2A);
			root.getChildren().remove(m2B);
			root.getChildren().remove(m2C);
			root.getChildren().remove(m2D);
			question2 = new Question();
			index4 = question2.listIndex();
			System.out.println(ans.tfList().get(index2));
			m2L.setText(question2.randomTFQuestion());
			m2L.setWrapText(true);
			root.getChildren().remove(box2);
			root.getChildren().remove(Mselect2);
			root.getChildren().remove(TFselect2);
//			root.getChildren().add(t2);
//			root.getChildren().add(f2);
//			root.getChildren().add(submit4);
			t2.setText("True");
			f2.setText("False");

		} catch (IOException l) {

		}
	}

	public void MsubmitP1(ActionEvent e) {
		try {
			count1++;
			root.getChildren().remove(t1);
			root.getChildren().remove(f1);
			
			question1 = new Question();
			ansArray1 = ans.setDisplayAnswer();
			//System.out.println("m1d " + m1D.getText());
//			System.out.println("ans " + ansArray[index1][3]);
//			System.out.println("ans " + ansArray[index1][3]);
			System.out.println("ans1 " + ans.corrMList().get(index1));

			if (m1D.isSelected() && m1D.getText().substring(0,1).equalsIgnoreCase(ans.corrMList().get(index1).substring(0,1))) {
				monManage.getMons(p2).hpCalcHigh(stat1.outgoingDmg());
				hpDisplay2.setText(hpLabel + Integer.toString((int) monManage.getMons(p2).getHPCalc()));
				System.out.println("hp " + monManage.getMons(p2).getHPCalc());
				bullet = new Circle(300, 300, 5, Color.BLACK);
				// add to root
				root.getChildren().add(bullet);
				Timeline timeline = new Timeline();
				KeyFrame kf = new KeyFrame(Duration.millis(10), this::moveBullet);
				timeline.getKeyFrames().add(kf);
				timeline.setCycleCount((Timeline.INDEFINITE));
				timeline.play();
				num1++;
			} else if (m1A.isSelected() && m1A.getText().substring(0,1).equalsIgnoreCase(ans.corrMList().get(index1).substring(0,1))) {
				monManage.getMons(p2).hpCalcHigh(stat1.outgoingDmg());
				hpDisplay2.setText(hpLabel + Integer.toString((int) monManage.getMons(p2).getHPCalc()));
				System.out.println("hp " + monManage.getMons(p2).getHPCalc());
				bullet = new Circle(300, 300, 5, Color.BLACK);
				// add to root
				root.getChildren().add(bullet);
				Timeline timeline = new Timeline();
				KeyFrame kf = new KeyFrame(Duration.millis(10), this::moveBullet);
				timeline.getKeyFrames().add(kf);
				timeline.setCycleCount((Timeline.INDEFINITE));
				timeline.play();
				num1++;
			} else if (m1B.isSelected() && m1B.getText().substring(0,1).equalsIgnoreCase(ans.corrMList().get(index1).substring(0,1))) {
				monManage.getMons(p2).hpCalcHigh(stat1.outgoingDmg());
				hpDisplay2.setText(hpLabel + Integer.toString((int) monManage.getMons(p2).getHPCalc()));
				System.out.println("hp " + monManage.getMons(p2).getHPCalc());
				bullet = new Circle(300, 300, 5, Color.BLACK);
				// add to root
				root.getChildren().add(bullet);
				Timeline timeline = new Timeline();
				KeyFrame kf = new KeyFrame(Duration.millis(10), this::moveBullet);
				timeline.getKeyFrames().add(kf);
				timeline.setCycleCount((Timeline.INDEFINITE));
				timeline.play();
				num1++;
			} else if (m1C.isSelected() && m1C.getText().substring(0,1).equalsIgnoreCase(ans.corrMList().get(index1).substring(0,1))) {
				monManage.getMons(p2).hpCalcHigh(stat1.outgoingDmg());
				hpDisplay2.setText(hpLabel + Integer.toString((int) monManage.getMons(p2).getHPCalc()));
				System.out.println("hp " + monManage.getMons(p2).getHPCalc());
				bullet = new Circle(300, 300, 5, Color.BLACK);
				// add to root
				root.getChildren().add(bullet);
				Timeline timeline = new Timeline();
				KeyFrame kf = new KeyFrame(Duration.millis(10), this::moveBullet);
				timeline.getKeyFrames().add(kf);
				timeline.setCycleCount((Timeline.INDEFINITE));
				timeline.play();
				num1++;
			} else {
				System.out.println("wrong");
			}
			if (stat1.getHPCalc() <= 0||stat2.getHPCalc() <= 0) {
				box3.setFill(Color.ALICEBLUE);
				
				player1.score(num1,count1);
				player1Score.setText(player1.toString());;
				player1Score.setTranslateX(scoreX1);
				player1Score.setTranslateY(scoreY1);
				root.getChildren().add(player1Score);
				
				player2.score(num2,count2);
				player2Score.setText(player2.toString());
				player2Score.setTranslateX(scoreX2);
				player2Score.setTranslateY(scoreY2);
				root.getChildren().add(player2Score);

			} 
//			else if (stat2.getHPCalc() <= 0) {
//				box3.setFill(Color.ALICEBLUE);
//				root.getChildren().add(box3);
//				board.score(num2,count2);
//				player1Score = new Label(board.toString());
//				player1Score.setTranslateX(scoreX1);
//				player1Score.setTranslateY(scoreY1);
//				root.getChildren().add(player1Score);
//				
//
//			}
			count1++;
			m1Group.selectToggle(null);
			String q1 = question1.randomMQuestion();
			index1 = question1.listIndex();
			System.out.println(index1);
			System.out.println(ans.corrMList().get(index1));
			m1L.setText(q1);
			m1L.setWrapText(true);
			root.getChildren().remove(box);
			root.getChildren().remove(Mselect);
			root.getChildren().remove(TFselect);
//			if (size==a) {
//				
//			}
			m1A.setText(ansArray1[index1][0]);
			m1B.setText(ansArray1[index1][1]);
			m1C.setText(ansArray1[index1][2]);
			m1D.setText(ansArray1[index1][3]);

		} catch (IOException l) {
		}
	}

	public void MsubmitP2(ActionEvent e) {
		try {
			count2++;
			root.getChildren().remove(t2);
			root.getChildren().remove(f2);
			question2 = new Question();
			ansArray2 = ans.setDisplayAnswer();
			//System.out.println("m2d " + m2D.getText());
			System.out.println("ans2 " + ans.corrMList().get(index2));

			if (m2D.isSelected() && m2D.getText().substring(0,1).equalsIgnoreCase(ans.corrMList().get(index2).substring(0,1))) {

				monManage.getMons(p1).hpCalcHigh(stat2.outgoingDmg());
				hpDisplay1.setText(hpLabel + Integer.toString((int) monManage.getMons(p1).getHPCalc()));
				System.out.println("hp " + monManage.getMons(p1).getHPCalc());
				bullet = new Circle(300, 300, 5, Color.BLACK);
				// add to root
				root.getChildren().add(bullet);
				Timeline timeline = new Timeline();
				KeyFrame kf = new KeyFrame(Duration.millis(10), this::moveBullet1);
				timeline.getKeyFrames().add(kf);
				timeline.setCycleCount((Timeline.INDEFINITE));
				timeline.play();
				num2++;
			} else if (m2A.isSelected() && m2A.getText().substring(0,1).equalsIgnoreCase(ans.corrMList().get(index2).substring(0,1))) {

				monManage.getMons(p1).hpCalcHigh(stat2.outgoingDmg());
				hpDisplay1.setText(hpLabel + Integer.toString((int) monManage.getMons(p1).getHPCalc()));
				System.out.println("hp " + monManage.getMons(p1).getHPCalc());
				bullet = new Circle(300, 300, 5, Color.BLACK);
				// add to root
				root.getChildren().add(bullet);
				Timeline timeline = new Timeline();
				KeyFrame kf = new KeyFrame(Duration.millis(10), this::moveBullet1);
				timeline.getKeyFrames().add(kf);
				timeline.setCycleCount((Timeline.INDEFINITE));
				timeline.play();
				num2++;
			} else if (m2B.isSelected() && m2B.getText().substring(0,1).equalsIgnoreCase(ans.corrMList().get(index2).substring(0,1))) {

				monManage.getMons(p1).hpCalcHigh(stat2.outgoingDmg());
				hpDisplay1.setText(hpLabel + Integer.toString((int) monManage.getMons(p1).getHPCalc()));
				System.out.println("hp " + monManage.getMons(p1).getHPCalc());
				bullet = new Circle(300, 300, 5, Color.BLACK);
				// add to root
				root.getChildren().add(bullet);
				Timeline timeline = new Timeline();
				KeyFrame kf = new KeyFrame(Duration.millis(10), this::moveBullet1);
				timeline.getKeyFrames().add(kf);
				timeline.setCycleCount((Timeline.INDEFINITE));
				timeline.play();
				num2++;

			} else if (m2C.isSelected() && m2C.getText().substring(0,1).equalsIgnoreCase(ans.corrMList().get(index2).substring(0,1))) {

				monManage.getMons(p1).hpCalcHigh(stat2.outgoingDmg());
				hpDisplay1.setText(hpLabel + Integer.toString((int) monManage.getMons(p1).getHPCalc()));
				//System.out.println("hp " + monManage.getMons(p1).getHPCalc());
				bullet = new Circle(300, 300, 5, Color.BLACK);
				// add to root
				root.getChildren().add(bullet);
				Timeline timeline = new Timeline();
				KeyFrame kf = new KeyFrame(Duration.millis(10), this::moveBullet1);
				timeline.getKeyFrames().add(kf);
				timeline.setCycleCount((Timeline.INDEFINITE));
				timeline.play();
				num2++;

			} else {
				System.out.println("wrong");
			}

			if (stat1.getHPCalc() <= 0||stat2.getHPCalc() <= 0) {
				box3.setFill(Color.ALICEBLUE);
				
				player1.score(num1,count1);
				player1Score.setText(player1.toString());;
				player1Score.setTranslateX(scoreX1);
				player1Score.setTranslateY(scoreY1);
				root.getChildren().add(player1Score);
				
				player2.score(num2,count2);
				player2Score.setText(player2.toString());;
				player2Score.setTranslateX(scoreX2);
				player2Score.setTranslateY(scoreY2);
				root.getChildren().add(player2Score);
				
			} 
//			else if (stat2.getHPCalc() < 0) {
//				box3.setFill(Color.ALICEBLUE);
//				root.getChildren().add(box3);
//				board.score(num2,count2);
//				player2Score = new Label(board.toString());
//				player2Score.setTranslateX(scoreX2);
//				player2Score.setTranslateY(scoreY2);
//				root.getChildren().add(player2Score);
//			}
			count2++;
			m2Group.selectToggle(null);
			String q2 = question2.randomMQuestion();

			index2 = question2.listIndex();
			//System.out.println(index2);
			// System.out.println(ansArray[i][0]);
			//System.out.println(ans.corrMList().get(index2));
			m2L.setText(q2);
			m2L.setWrapText(true);
			root.getChildren().remove(box2);
			root.getChildren().remove(Mselect2);
			root.getChildren().remove(TFselect2);
			m2A.setText(ansArray2[index2][0]);
			m2B.setText(ansArray2[index2][1]);
			m2C.setText(ansArray2[index2][2]);
			m2D.setText(ansArray2[index2][3]);

		} catch (IOException l) {

		}
	}

	
	public void TFsubmitP1(ActionEvent e) {
		try {

			question3 = new Question();
			System.out.println(ans.tfList().get(index3).substring(8, 9));
			// System.out.println(ans.tfList().get(index3).substring(8,13));
			if (t1.isSelected() && t1.getText().substring(0,1).equalsIgnoreCase(ans.tfList().get(index3).substring(8, 9))) {
				monManage.getMons(p2).hpCalcHigh(stat1.outgoingDmg());
				hpDisplay2.setText(hpLabel + Integer.toString((int) monManage.getMons(p2).getHPCalc()));
				//System.out.println("hp " + monManage.getMons(p2).getHPCalc());
				bullet = new Circle(300, 300, 5, Color.BLACK);
				// add to root
				root.getChildren().add(bullet);
				Timeline timeline = new Timeline();
				KeyFrame kf = new KeyFrame(Duration.millis(10), this::moveBullet);
				timeline.getKeyFrames().add(kf);
				timeline.setCycleCount((Timeline.INDEFINITE));
				timeline.play();
				num1++;

			} else if (f1.isSelected() && f1.getText().substring(0,1).equalsIgnoreCase(ans.tfList().get(index3).substring(8, 9))) {
				monManage.getMons(p2).hpCalcHigh(stat1.outgoingDmg());
				hpDisplay2.setText(hpLabel + Integer.toString((int) monManage.getMons(p2).getHPCalc()));
				//System.out.println("hp " + monManage.getMons(p2).getHPCalc());
				bullet = new Circle(300, 300, 5, Color.BLACK);
				// add to root
				root.getChildren().add(bullet);
				Timeline timeline = new Timeline();
				KeyFrame kf = new KeyFrame(Duration.millis(10), this::moveBullet);
				timeline.getKeyFrames().add(kf);
				timeline.setCycleCount((Timeline.INDEFINITE));
				timeline.play();
				num1++;
			} else {
				System.out.println("wrong");
			}
			if (stat1.getHPCalc() <= 0||stat2.getHPCalc() <= 0) {
				box3.setFill(Color.ALICEBLUE);
				
				player1.score(num1,count1);
				player1Score.setText(player1.toString());;
				player1Score.setTranslateX(scoreX1);
				player1Score.setTranslateY(scoreY1);
				root.getChildren().add(player1Score);
				player2.score(num2,count2);
				player2Score.setText(player2.toString());;
				player2Score.setTranslateX(scoreX2);
				player2Score.setTranslateY(scoreY2);
				root.getChildren().add(player2Score);

			} 
//			else if (stat2.getHPCalc() <= 0) {
//				box3.setFill(Color.ALICEBLUE);
//				root.getChildren().add(box3);
//				board.score(num1,count1);
//				player1Score = new Label(board.toString());
//				player1Score.setTranslateX(scoreX1);
//				player1Score.setTranslateY(scoreY1);
//				root.getChildren().add(player1Score);
//			}
			count1++;

			m3Group.selectToggle(null);

			m1L.setText(question3.randomTFQuestion());
			index3 = question3.listIndex();
			root.getChildren().remove(box);
			root.getChildren().remove(Mselect);
			root.getChildren().remove(TFselect);
			t1.setText("True");
			f1.setText("False");

		} catch (IOException l) {

		}
	}

	public void TFsubmitP2(ActionEvent e) {
		try {
			question4 = new Question();
			System.out.println(ans.tfList().get(index4).substring(8, 9));
			// System.out.println(ans.tfList().get(index4).substring(8,13));
			if (t2.isSelected() && t2.getText().substring(0,1).equalsIgnoreCase(ans.tfList().get(index4).substring(8,9))) {
				monManage.getMons(p1).hpCalcHigh(stat2.outgoingDmg());
				hpDisplay1.setText(hpLabel + Integer.toString((int) monManage.getMons(p1).getHPCalc()));
				System.out.println("hp " + monManage.getMons(p1).getHPCalc());
				bullet = new Circle(300, 300, 5, Color.BLACK);
				// add to root
				root.getChildren().add(bullet);
				Timeline timeline = new Timeline();
				KeyFrame kf = new KeyFrame(Duration.millis(10), this::moveBullet1);
				timeline.getKeyFrames().add(kf);
				timeline.setCycleCount((Timeline.INDEFINITE));
				timeline.play();
				num2++;

			} else if (f2.isSelected() && f2.getText().substring(0,1).equalsIgnoreCase(ans.tfList().get(index4).substring(8,9))) {
				monManage.getMons(p1).hpCalcHigh(stat2.outgoingDmg());
				hpDisplay1.setText(hpLabel + Integer.toString((int) monManage.getMons(p1).getHPCalc()));
				System.out.println("hp " + monManage.getMons(p1).getHPCalc());
				bullet = new Circle(300, 300, 5, Color.BLACK);
				// add to root
				root.getChildren().add(bullet);
				Timeline timeline = new Timeline();
				KeyFrame kf = new KeyFrame(Duration.millis(10), this::moveBullet1);
				timeline.getKeyFrames().add(kf);
				timeline.setCycleCount((Timeline.INDEFINITE));
				timeline.play();
				num2++;
			} else {
				System.out.println("wrong");
			}
			if (stat1.getHPCalc() <= 0||stat2.getHPCalc() <= 0) {
				box3.setFill(Color.ALICEBLUE);
				
				player1.score(num1,count1);
				player1Score.setText(player1.toString());;
				player1Score.setTranslateX(scoreX1);
				player1Score.setTranslateY(scoreY1);
				root.getChildren().add(player1Score);
				player2.score(num2,count2);
				player2Score.setText(player2.toString());;
				player2Score.setTranslateX(scoreX2);
				player2Score.setTranslateY(scoreY2);
				root.getChildren().add(player2Score);

			} 
//			else if (stat2.getHPCalc() <= 0) {
//				box3.setFill(Color.ALICEBLUE);
//				root.getChildren().add(box3);
//				board.score(num2,count2);
//				player2Score = new Label(board.toString());
//				player2Score.setTranslateX(scoreX2);
//				player2Score.setTranslateY(scoreY2);
//				root.getChildren().add(player2Score);
//			}
			count2++;
			m4Group.selectToggle(null);
			m2L.setText(question4.randomTFQuestion());
			index4 = question4.listIndex();
			root.getChildren().remove(box2);
			root.getChildren().remove(Mselect2);
			root.getChildren().remove(TFselect2);
			t2.setText("True");
			f2.setText("False");
		} catch (IOException l) {

		}
	}
	
	

	public void pressed(ActionEvent event) {

		Random gen = new Random();

		int randomAttack = gen.nextInt(1, 3);

		bullet = new Circle(300, 300, 5, Color.BLACK);

		// add to root
		root.getChildren().add(bullet);

		Timeline timeline = new Timeline();

		KeyFrame kf = new KeyFrame(Duration.millis(50), this::moveBullet);

		timeline.getKeyFrames().add(kf);

		timeline.setCycleCount((Timeline.INDEFINITE));

		timeline.play();

//		switch (event.getCode()) {
//
//		case A:
//
//			if (randomAttack == 1) {
//				// Bullet
//
//				bullet = new Circle(300, 300, 5, Color.BLACK);
//
//				// add to root
//				root.getChildren().add(bullet);
//
//				Timeline timeline = new Timeline();
//
//				KeyFrame kf = new KeyFrame(Duration.millis(10), this::moveBullet);
//
//				timeline.getKeyFrames().add(kf);
//
//				timeline.setCycleCount((Timeline.INDEFINITE));
//
//				timeline.play();
//
//				break;
//
//			} else {
//
//				// Beam
//
//				beam = new Rectangle(300, 300, 50, 2);
//
//				beam.setFill(Color.RED);
//
//				root.getChildren().add(beam);
//
//				Timeline beamTimeline = new Timeline();
//
//				KeyFrame beamKF = new KeyFrame(Duration.millis(10), this::moveBeam);
//
//				beamTimeline.getKeyFrames().add(beamKF);
//
//				beamTimeline.setCycleCount(Timeline.INDEFINITE);
//				beamTimeline.play();
//
//				break;
//
//			}
//
//		}

	}

	public void moveBullet(ActionEvent event) {

		bullet.setTranslateX((bullet.getTranslateX() + 5));

		if (bullet.getBoundsInParent().intersects(imgVM2.getBoundsInParent())) {

			///// Making it rotate once an attack is hit on them
			RotateTransition transition = new RotateTransition(Duration.seconds(5), imgVM2);

			transition.setRate(10);
			transition.setFromAngle(0);
			transition.setToAngle(360);

			transition.setInterpolator(Interpolator.EASE_IN);

			transition.play();

			root.getChildren().remove(bullet);
		}

	}

	public void moveBullet1(ActionEvent event) {

		bullet.setTranslateX((bullet.getTranslateX() + 5));

		if (bullet.getBoundsInParent().intersects(imgVM1.getBoundsInParent())) {

			///// Making it rotate once an attack is hit on them
			RotateTransition transition = new RotateTransition(Duration.seconds(5), imgVM1);

			transition.setRate(10);
			transition.setFromAngle(0);
			transition.setToAngle(360);

			transition.setInterpolator(Interpolator.EASE_IN);

			transition.play();

			root.getChildren().remove(bullet);
		}

	}

	///////

	// Move the beam
	public void moveBeam(ActionEvent event) {

		beam.setTranslateX(beam.getTranslateX() + 10);

		if (beam.getBoundsInParent().intersects(imgVM2.getBoundsInParent())) {

			ScaleTransition transition = new ScaleTransition(Duration.seconds(5), imgVM2);

			transition.setToX(0.5);
			transition.setToY(0.5);

			transition.setInterpolator(Interpolator.LINEAR);

			transition.play();

			////

			root.getChildren().remove(beam);
		}

	}

///////

	public void profileWindow(ActionEvent event) throws FileNotFoundException {
		start(primaryStage);
	}

	static class Monsters extends ImageView {

		public static ImageView Monster1() {

			Image img = Animations.imgM1;

			ImageView imgV = new ImageView(img);

			imgV.setTranslateX(100);
			imgV.setTranslateY(200);

			return imgV;

		}

		public static ImageView Monster2() {

			Image img2 = Animations.imgM2;

			ImageView imgV = new ImageView(img2);

			imgV.setTranslateX(500);
			imgV.setTranslateY(200);

			return imgV;

		}

	}
}
