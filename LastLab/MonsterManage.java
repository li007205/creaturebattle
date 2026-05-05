package LastLab;

import java.util.ArrayList;

public class MonsterManage {
	private ArrayList<MonsterStat> statList;
	private ArrayList<Player> playerList;
	
	
	public MonsterManage() {
		statList = new ArrayList<MonsterStat>();
		playerList = new ArrayList<Player>();
	}
	public void addList(MonsterStat stat) {
		statList.add(stat);
	}
	public MonsterStat getMons(int i) {
		return statList.get(i);
	}
	public void addlist(Player player) {
		playerList.add(player);
	}
	public void displayBoard() {
		if (statList.get(0).getHPCalc()<statList.get(1).getHPCalc()) {
			System.out.println(playerList.get(1).getName());
		}
		else if (statList.get(0).getHPCalc()>statList.get(1).getHPCalc()) {
			System.out.println(playerList.get(0).getName());
		}
		else {
			System.out.println("Draw");
		}
	}

}
