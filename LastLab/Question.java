package LastLab;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Question {
	private String question;
	private ArrayList<String> mList;
	private ArrayList<String> tfList;
	private ArrayList<String> repeat1;
	private ArrayList<String> repeat2;
	private Scanner scan;
	private Random rand;
	private int size;
	private int qTypeM;
	private int qTypeTF;
	private int index;
	
	public Question() throws IOException {
		rand = new Random();
		mList = new ArrayList<String>();
		repeat1 = new ArrayList<String>();
		scan = new Scanner(new FileReader("multiQuestion.txt"));
		while (scan.hasNextLine()) {
			String str;
			str = scan.nextLine();
			mList.add(str);
		}
		size = mList.size();
		repeat2 = new ArrayList<String>() ;
		tfList = new ArrayList<String>();
		scan = new Scanner(new FileReader("tfquestion.txt"));
		while (scan.hasNextLine()) {
			String str;
			str = scan.nextLine();
			tfList.add(str);
		}
		
		
	}
	public ArrayList<String> getMQuestion(){
		return mList;
	}
	public ArrayList<String> getTFQuestion(){
		return tfList;
	}
	public int listSize() {
		return size;
	}
	public String randomMQuestion() {
		this.index = rand.nextInt(size);
		String indexStr =Integer.toString(index);
		boolean start=true;repeat1.add(indexStr);
		while (start) {
			for (int i = 0; i < repeat1.size(); i++) {
				for (int j = 0; j < mList.size(); j++) {
					if (repeat1.get(i) == mList.get(j)) {
						indexStr = Integer.toString(size);
						repeat1.set(i, indexStr);
					} 
					else {
						question = mList.get(index);
						start=false;
					}
				}
			}
		}
		return question;
	}
	public String randomTFQuestion() {
		this.index = rand.nextInt(size);
		String indexStr =Integer.toString(index);
		boolean start=true;repeat2.add(indexStr);
		while (start) {
			for (int i = 0; i < repeat2.size(); i++) {
				for (int j = 0; j < tfList.size(); j++) {
					if (repeat2.get(i) == tfList.get(j)) {
						indexStr = Integer.toString(size);
						repeat2.set(i, indexStr);
					} 
					else {
						question = tfList.get(index);
						start=false;
					}
				}
			}
		}
		return question;
	}
	public String getQuestion(int i){
		return mList.get(i);
	}
	public int listIndex() {
		return index;
	}

}
