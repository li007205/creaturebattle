package LastLab;

public class Player extends GameObject {
	private String name;
	private int score, num;
	
	public Player(String name) {
		this.name = name;
		score = 0;
	}
	public String getName() {
		return name;
	}
	public int score(int score, int num) {
		this.num = num;
		return this.score += score;
		
	}
	public String toString() {
		return name+" Correct answers: "+score + " out of "+num;
	}
}
