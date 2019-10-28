package dao;  

import java.util.ArrayList;
import java.util.List;

import model.DrinkEntity;
public class DrinkDAO {

	
	public List<DrinkEntity> findAll() {
		//各レコードとなるDrinkEntityのインスタンスを生成 
		DrinkEntity beer = new DrinkEntity();
		DrinkEntity wine = new DrinkEntity();
		
		//セッターでビールレコード・ワインレコードの値を設定
		beer.setId(1);
		beer.setDrinkName("ビール");
		beer.setAlcoholRate(0.03);
		
		wine.setId(2);
		wine.setDrinkName("ワイン");
		wine.setAlcoholRate(0.15);
		
		//Listに各レコードを格納
		List<DrinkEntity> drinkList = new ArrayList<DrinkEntity>();
		drinkList.add(beer);
		drinkList.add(wine);
		
		return drinkList;
	}
	
}
