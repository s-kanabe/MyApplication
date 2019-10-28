package dao;

import model.DrinkEntity;
import java.util.List;
import java.util.ArrayList;

public class DrinkDAO {
	//各レコードとなるDrinkEntityのインスタンスを生成
	DrinkEntity beer = new DrinkEntity();
	DrinkEntity wine = new DrinkEntity();
	
	//セッターでビールレコード・ワインレコードの値を設定
	beer.setId(1);
	beer.setDrinkName("ビール");
	beer.setAlcoholRate(0.03);
	
	wine.setId(2);
	wine.setDrinkName("ワイン");
	wine.setAlcoholrate(0.15);
	
	//Listに各レコードを格納
	List<DrinkEntity> drinkList = new ArrayList<DrinkEntity>();
	drinkList.add(beer);
	drinkList.add(wine);
	
	public List<DrinkEntity> findAll() {
		return drinkList;
	}
	
}
