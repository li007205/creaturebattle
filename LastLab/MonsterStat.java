package LastLab;

import java.util.ArrayList;

public class MonsterStat {
	//private ArrayList<MonsterStat> monster;
//	private String mon1 = "mon1";
//	private String mon2 = "mon2";
	private String name;
	private int hp;
	private int atk;
	private int def;
	private int spd;
	
	public MonsterStat(String name, int hp, int atk, int def, int spd) {
		this.name = name;
		this.hp = hp;
		this.atk =atk;
		this.def= def;
		this.spd=spd;
	}
	public double hpCalcHigh(int dmg) {
		return hp = hp-(dmg*(1-(def/100)));
	}
	public double getHPCalc() {
		if (this.hp <=0) {
			this.hp = 0;
		}
		return hp;
	}
	public int outgoingDmg() {
		return atk;
	}
	public double hpCalcLow(int dmg) {
		return hp = hp-((dmg/2)*(1-(def/100)));
	}
	public int speed() {
		return spd;
	}
	
//	public void choose(int i) {
//		this(mon1, 10, 10, 50, 10);
//	}

}
