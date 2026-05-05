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

public class singlePlayer extends Application {

    private Circle bullet;
    private Stage primaryStage;
    private Group root;
    private Rectangle beam;

    static Image imgM1;
    private ImageView imgVM1;
    private Label m1L, hpDisplay1, player1Score;
    private Button Mselect, TFselect, submit1, submit3;
    private Rectangle box, box3;
    private double height;
    private MonsterManage monManage;
    private MonsterStat stat1;
    private Player player1;
    private Question question1, question3;
    private RadioButton m1A, m1B, m1C, m1D, t1, f1;
    private Answer ans;
    private String[][] ansArray1;
    private Random rand;
    private int p1 = 0, p2 = 1, index1, index3, num1, count1;
    private String hpLabel = "HP: ";
    private ToggleGroup m1Group, m3Group;
    private Leaderboard board;
    private int size = 0;
    private int scoreX1 = 305, scoreY1 = 340;
    private int margin = 50;

    public void start1(Stage stage) {
        try {
            board = new Leaderboard();
            hpDisplay1 = new Label("");
            ans = new Answer();
            ansArray1 = ans.setDisplayAnswer();
            submit1 = new Button("submit");
            submit3 = new Button("submit");
            monManage = new MonsterManage();
            height = 80;
            box3 = new Rectangle(250, 300, 500, 200);

            imgM1 = new Image("File:Monster1.png", 300, 200, false, false);

            imgVM1 = Monsters.Monster1();

            root = new Group();
            Mselect = new Button("Multiple Choice");
            TFselect = new Button("True or False");
            box = new Rectangle(50, 400, 400, 500);
            Mselect.setTranslateX(70);
            Mselect.setTranslateY(550);
            TFselect.setTranslateX(200);
            TFselect.setTranslateY(550);

          //  box.setStroke(Color.BLACK);
            box.setFill(Color.WHITE);
            Mselect.setOnAction(this::MquestionButton1);
            TFselect.setOnAction(this::TFquestionButton1);

            m1L = new Label("M1 Question .......");
            m1L.setPrefWidth(400);
            m1L.setTranslateX(50);
            m1L.setTranslateY(imgVM1.getTranslateY() + imgVM1.getImage().getHeight());
            root.getChildren().add(m1L);

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

            m1A.setTranslateX(imgVM1.getTranslateX() - margin);
            m1A.setTranslateY(m1L.getTranslateY() + height + 20);
            root.getChildren().add(m1A);

            m1B.setTranslateX(imgVM1.getTranslateX() - margin);
            m1B.setTranslateY(m1L.getTranslateY() + height + 60);
            root.getChildren().add(m1B);

            m1C.setTranslateX(imgVM1.getTranslateX() - margin);
            m1C.setTranslateY(m1L.getTranslateY() + height + 100);
            root.getChildren().add(m1C);

            m1D.setTranslateX(imgVM1.getTranslateX() - margin);
            m1D.setTranslateY(m1L.getTranslateY() + height + 140);
            root.getChildren().add(m1D);

            root.getChildren().add(submit1);
            submit1.setTranslateY(700);
            submit1.setTranslateX(50);

            t1 = new RadioButton();
            f1 = new RadioButton();
            m3Group = new ToggleGroup();
            t1.setToggleGroup(m3Group);
            f1.setToggleGroup(m3Group);
            t1.setTranslateX(imgVM1.getTranslateX() - margin);
            t1.setTranslateY(m1L.getTranslateY() + height + 20);
            f1.setTranslateX(imgVM1.getTranslateX() - margin);
            f1.setTranslateY(m1L.getTranslateY() + height + 60);
            root.getChildren().add(t1);
            root.getChildren().add(f1);
            root.getChildren().add(submit3);
            submit3.setTranslateY(700);
            submit3.setTranslateX(50);

            root.getChildren().addAll(imgVM1, box, Mselect, TFselect);

            player1 = new Player("P1");
            stat1 = new MonsterStat("M1", 100, 20, 20, 20);
            monManage.addList(stat1);
            hpDisplay1.setText(hpLabel + Integer.toString((int) stat1.getHPCalc()));
            hpDisplay1.setTranslateX(240);
            hpDisplay1.setTranslateY(150);
            hpDisplay1.setFont(new Font(20));
            root.getChildren().add(hpDisplay1);

            submit1.setOnAction(this::MsubmitP1);
            submit3.setOnAction(this::TFsubmitP1);
            root.getChildren().add(box3);
            box3.setFill(null);
            player1Score = new Label();
            player1Score.setFont(new Font(30));

            Scene scene = new Scene(root, 500, 800);
            stage.setScene(scene);
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
            m1L.setText(question1.randomTFQuestion());
            m1L.setWrapText(true);
            root.getChildren().remove(box);
            root.getChildren().remove(Mselect);
            root.getChildren().remove(TFselect);
            t1.setText("True");
            f1.setText("False");
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

            if (m1D.isSelected() && m1D.getText().substring(0, 1).equalsIgnoreCase(ans.corrMList().get(index1).substring(0, 1))) {
                monManage.getMons(p1).hpCalcHigh(stat1.outgoingDmg());
                bullet = new Circle(300, 300, 5, Color.BLACK);
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

            if (stat1.getHPCalc() <= 0) {
                box3.setFill(Color.ALICEBLUE);
                player1.score(num1, count1);
                player1Score.setText(player1.toString());
                player1Score.setTranslateX(scoreX1);
                player1Score.setTranslateY(scoreY1);
                root.getChildren().add(player1Score);
            }

            count1++;
            m1Group.selectToggle(null);
            String q1 = question1.randomMQuestion();
            index1 = question1.listIndex();
            m1L.setText(q1);
            m1L.setWrapText(true);
            root.getChildren().remove(box);
            root.getChildren().remove(Mselect);
            root.getChildren().remove(TFselect);
            System.out.println(ansArray1[index1][0]);
            System.out.println(ansArray1[index1][1]);
            System.out.println(ansArray1[index1][2]);
            System.out.println(ansArray1[index1][3]);
            m1A.setText(ansArray1[index1][0]);
            m1B.setText(ansArray1[index1][1]);
            m1C.setText(ansArray1[index1][2]);
            m1D.setText(ansArray1[index1][3]);

        } catch (IOException l) {
        }
    }

    public void TFsubmitP1(ActionEvent e) {
        try {
            question3 = new Question();
            if (t1.isSelected() && t1.getText().substring(0, 1).equalsIgnoreCase(ans.tfList().get(index3).substring(8, 9))) {
                monManage.getMons(p1).hpCalcHigh(stat1.outgoingDmg());
                bullet = new Circle(300, 300, 5, Color.BLACK);
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

            if (stat1.getHPCalc() <= 0) {
                box3.setFill(Color.ALICEBLUE);
                player1.score(num1, count1);
                player1Score.setText(player1.toString());
                player1Score.setTranslateX(scoreX1);
                player1Score.setTranslateY(scoreY1);
                root.getChildren().add(player1Score);
            }

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

    public void moveBullet(ActionEvent event) {
        bullet.setTranslateX((bullet.getTranslateX() + 5));

        if (bullet.getBoundsInParent().intersects(imgVM1.getBoundsInParent())) {
            RotateTransition transition = new RotateTransition(Duration.seconds(5), imgVM1);
            transition.setRate(10);
            transition.setFromAngle(0);
            transition.setToAngle(360);
            transition.setInterpolator(Interpolator.EASE_IN);
            transition.play();
            root.getChildren().remove(bullet);
        }
    }

    static class Monsters extends ImageView {
        public static ImageView Monster1() {
            Image img = singlePlayer.imgM1;
            ImageView imgV = new ImageView(img);
            imgV.setTranslateX(100);
            imgV.setTranslateY(200);
            return imgV;
        }
    }

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
	}
}
