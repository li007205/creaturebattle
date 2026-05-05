package LastLab;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main {
	public static void main(String[] args) {
//		Stage stage = new Stage();
//		GameObject obj = new MultiPlayer();
//		obj.play(stage);
		
		try {
			Answer ans = new Answer();
			String [][] arr = ans.setDisplayAnswer();
			for (int i=0;i<arr.length;i++) {
				for(int j=0;j<4;j++) {
					System.out.println(i+": "+arr[i][j]);
				}
				//System.out.println(i+": "+arr[i]);
			}
			
		}
		catch (IOException e) {
			
		}
		
//		Animations anime = new Animations();
		//launch();
		//manage.setQuestAns();
//		for (String i : question.getQuestion()) {
//			System.out.println(i);
//		}
//		System.out.println(question.randomMQuestion());
//		System.out.println(question.randomTFQuestion());
//		for (int i=0; i<4;i++) {
//			
//		}
		
//		Player player1 = new Player("aaaaa");
//		Player player2 = new Player("bbbbb");
//		monManage.addList(stat1);
//		monManage.addList(stat2);
//		monManage.addlist(player1);
//		monManage.addlist(player2);
//		
//		if (stat1.speed()<stat2.speed()) {
//			stat2.hpCalcHigh(stat1.outgoingDmg());
//			System.out.println("aaaaa "+stat1.getHPCalc());
//			System.out.println("bbbbb "+stat2.getHPCalc());
//		}
//		else if (stat1.speed()>stat2.speed()) {
//			stat1.hpCalcHigh(stat2.outgoingDmg());
//			System.out.println("aaaaa "+stat1.getHPCalc());
//			System.out.println("bbbbb "+stat2.getHPCalc());
//		}
//		else {
//			if(rand.nextInt(1)==1) {
//				stat2.hpCalcHigh(stat1.outgoingDmg());
//				System.out.println("aaaaa "+stat1.getHPCalc());
//				System.out.println("bbbbb "+stat2.getHPCalc());
//			}
//			else {
//				stat1.hpCalcHigh(stat2.outgoingDmg());
//				System.out.println("aaaaa "+stat1.getHPCalc());
//				System.out.println("bbbbb "+stat2.getHPCalc());
//			}
//		}
//		ans.setDisplayAnswer();
		//System.out.println(ans.getDisplayAnswer());
//		ans.getDisplayAnswer(2);
//		monManage.displayBoard();
		//board.playerScore();
//		System.out.println();
//		ans.displayAnswer(1);
//		System.out.println();
//		ans.displayAnswer(2);
//		System.out.println();
//		ans.displayAnswer(3);
		
		
		
		
//		System.out.println();
//		for (int i=0;i<question.listSize();i++) {
//			System.out.println(manage.getList().get(i));
//		}
		
		
	}



}
