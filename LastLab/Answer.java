package LastLab;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Answer {
	private ArrayList<String> multiAnsList;
	private ArrayList<String> trueFalseList;
	private ArrayList<String> correctMList;
	private String[][] mList = new String[11][4];
	private Scanner scan;
	private int multsize;
	private int TFsize;
	private int correctMSize;
	
	public Answer() throws FileNotFoundException {
		multiAnsList = new ArrayList<String>();
		scan = new Scanner(new FileReader("mulitpleChoice.txt"));
		while (scan.hasNextLine()) {
			String str;
			str = scan.nextLine();
			multiAnsList.add(str);
		}
		multsize = multiAnsList.size();
		
		
		trueFalseList = new ArrayList<String>();
		scan = new Scanner(new FileReader("trueORfalse.txt"));
		while (scan.hasNextLine()) {
			String str;
			str = scan.nextLine();
			trueFalseList.add(str);
		}
		TFsize = trueFalseList.size();
		
		correctMList = new ArrayList<String>();
		scan = new Scanner(new FileReader("correctAns.txt"));
		while (scan.hasNextLine()) {
			String str;
			str = scan.nextLine();
			correctMList.add(str);
		}
		correctMSize = correctMList.size();
		
	}
	
	public ArrayList<String> mlist(){
		return multiAnsList;
	}
	public ArrayList<String> tfList(){
		return trueFalseList;
	}
	public ArrayList<String> corrMList(){
		return correctMList;
	}
	public String[][] setDisplayAnswer() {
		
		int count=0;
		for (int i=0; i<mList.length;i++) {
			
			for (int j=0; j<mList[i].length;j++) {
				mList[i][j]=multiAnsList.get(count);
				//System.out.println(i+": "+mList[i][j]);
				count++;
			}
		}
		return mList;
	}
	public void getDisplayAnswer(int index) {
		for (int i=index;i<index+1;i++) {
			for (int j=0;j<4;j++) {
				System.out.println(mList[i][j]);
			}
		}
	}
	public String getMList(int i, int j){
		return mList[i][j];
	}
}
