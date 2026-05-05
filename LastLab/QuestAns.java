package LastLab;

public class QuestAns {
	private String question="";
	private String answer="";
	public QuestAns(String question, String answer) {
		this.question = question;
		this.answer = answer;
	}
	public void setQuestion(String q) {
		this.question = q;
	}
	public void setAnswer(String a) {
		this.answer = a;
	}
	public String toString() {
		return question+"\n"+answer+"\n";
	}

}
