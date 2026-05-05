package LastLab;

import java.util.ArrayList;

import Lab10.Player;

public class Leaderboard extends GameObject{
	private MonsterManage manage;
	private int score, num;
	
	public Leaderboard() {
		manage = new MonsterManage();
	}
	public void playerScore() {
		manage.displayBoard();
	}
	

}
