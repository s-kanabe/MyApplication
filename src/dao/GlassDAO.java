package dao;

import model.GlassEntity;
import java.util.List;
import java.util.ArrayList;

public class GlassDAO {	
	//各レコードとなるGlassEntityのインスタンスを生成
	GlassEntity middleGlass = new GlassEntity();
	GlassEntity wineGlass = new GlassEntity();
	
	//セッターで中ジョッキレコード・ワイングラスレコードの値を設定
	middleGlass.setId(1);  
	middleGlass.setGlassname("中ジョッキ");
	middleGlass.setAmount(300);

	wineGlass.setId(2);  
	wineGlass.setGlassname("ワイングラス");
	wineGlass.setAmount(100);

	//Listに各レコードを格納
	List<GlassEntity> glassList = new ArrayList<GlassEntity>();
	glassList.add(middleGlass);
	glassList.add(wineGlass);
	
	public List<GlassEntity> findAll() {
		return glassList;
	}
		
}
