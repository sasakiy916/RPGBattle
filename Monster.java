import java.util.*;
public class Monster{
	Random r = new Random();
	//フィールド
	String name;
	int hp = 20;
	int power = 10;
	//コンストラクタ
	Monster(String name){
		this.name = name;
		System.out.printf("%sが現れた！%n",this.name);
	}
	//メソッド
	public void attack(Hero h){
		int damage = power + r.nextInt(10)+1;
		h.hp -= damage;
		System.out.printf("%sは%sに%dダメージ与えた!%n",this.name,h.name,damage);
	}
}
