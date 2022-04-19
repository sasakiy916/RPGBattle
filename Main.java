import java.util.*;
public class Main{
	public static void main(String[] args){
		Random r = new Random();
		//勇者のインスタンス
		Hero hero = new Hero("勇者");
		//モンスターの群れ(モンスターのインスタンス)
		Monster[] monsters = {
			new Monster("スライム"),
			new Monster("ヅライム"),
		};
		int monstersNum = monsters.length;//モンスターの残り匹数
		System.out.println();
		//戦闘開始
		showHp(hero,monsters);
		while(true){
			//勇者のターン
			//どっちのモンスターを攻撃するか
			int target = r.nextInt(2);
			Monster monster;
			if(monsters[target].hp > 0){
				//HPがあれば攻撃
				monster = monsters[target];
			}else{
				//targetのHPが無ければもう片方を攻撃
				monster = monsters[Math.abs(target-1)];
			}
			//勇者の攻撃
			hero.attack(monster);
			showHp(hero,monsters);
			//モンスターを倒したかどうか確認
			if(monster.hp <= 0){
				System.out.printf("%sをたおした！%n%n",monster.name);
				monstersNum--;
				//モンスターの群れ全滅
				if(monstersNum == 0){
					System.out.println();
					System.out.println("モンスターをすべてたおした！");
					return;
				}
			}
			//モンスターのターン
			//モンスターの攻撃
			for(int i=0;i<monsters.length;i++){
				//モンスターが生きてれば攻撃
				if(monsters[i].hp > 0){
					monsters[i].attack(hero);
					//勇者がやられたか確認
					if(hero.hp < 0){
						showHp(hero,monsters);
						System.out.printf("%sはやられてしまった・・・%n",hero.name);
						return;
					}
					showHp(hero,monsters);
				}
			}
		}
	}
	//現在のHp表示メソッド
	public static void showHp(Hero h,Monster[] monsters){
		String line = "---------------";
		System.out.println(line);
		if(h.hp < 0){
			h.hp = 0;
		}
		System.out.printf("%sのHP:%d%n",h.name,h.hp);
		for(Monster m:monsters){
			if(m.hp < 0){
				m.hp = 0;
			}
			System.out.printf("%sのHP:%d%n",m.name,m.hp);
		}
		System.out.println(line);
		System.out.println();
	}
}
