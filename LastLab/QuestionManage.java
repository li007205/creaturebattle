package LastLab;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class QuestionManage {
	private ArrayList<QuestAns> questAnsList;
	private Question question;
	private Answer ans;
	private QuestAns QA;
	private Scanner scan;
	
	public QuestionManage() throws IOException {
		question = new Question();
		ans = new Answer();
		questAnsList = new ArrayList<QuestAns>();
	}

	public void setQuestAns() throws FileNotFoundException {

		for (int i=0;i<question.getMQuestion().size();i++) {
			QA = new QuestAns(question.getMQuestion().get(i), ans.corrMList().get(i));
				System.out.println(QA.toString());
				questAnsList.add(QA);
		}
		for (int i=0;i<question.getTFQuestion().size();i++) {
			QA = new QuestAns(question.getTFQuestion().get(i), ans.tfList().get(i));
				System.out.println(QA.toString());
				questAnsList.add(QA);
		}
	}
	public ArrayList<QuestAns> getList(){
		return questAnsList;
	}
	public String getAnswer() {
		return "";
	}

}
