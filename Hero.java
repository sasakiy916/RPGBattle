import java.util.*;
public class Hero{
	Random r = new Random();
	//フィールド
	String name;
	int hp = 50;
	int power = 15;
	//コンストラクタ
	Hero(String name){
		this.name = name;
		System.out.printf("%sが生まれた%n",this.name);
	}
	//メソッド
	public void attack(Monster m){
		int damage = power + r.nextInt(10)+1;
		m.hp -= damage;
		System.out.printf("%sは%sに%dダメージ与えた!%n",this.name,m.name,damage);
	}
}
