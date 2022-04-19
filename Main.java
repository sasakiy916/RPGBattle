import java.util.*;
public class Main{
	public static void main(String[] args){
		//ここの処理を書く
	}
	//現在のHp表示メソッド(ご自由に使用してください)
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
