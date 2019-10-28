package dao;

import java.util.ArrayList;
import java.util.List;

import model.GlassEntity;

public class GlassDAO {	
	
	public List<GlassEntity> findAll() {
		//各レコードとなるGlassEntityのインスタンスを生成
		GlassEntity middleGlass = new GlassEntity();
		GlassEntity wineGlass = new GlassEntity();
		
		//セッターで中ジョッキレコード・ワイングラスレコードの値を設定 
		middleGlass.setId(1);  
		middleGlass.setGlassName("中ジョッキ");
		middleGlass.setAmount(300);

		wineGlass.setId(2);  
		wineGlass.setGlassName("ワイングラス");
		wineGlass.setAmount(100);

		//Listに各レコードを格納
		List<GlassEntity> glassList = new ArrayList<GlassEntity>();
		glassList.add(middleGlass);
		glassList.add(wineGlass);
		
		return glassList;
	}
		
}
