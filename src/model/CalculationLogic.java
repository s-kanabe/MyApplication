package model;
import java.util.List;

public class CalculationLogic {
	public void excute(List<DrinkEntity> drinkList, List<GlassEntity> glassList) { 
		//mustWaterを算出して設定
		double alcoholRate = drinkList.get(0).getAlcoholRate();
		int amount = glassList.get(0).getAmount();
		double mustWater = (amount*amount*alcoholRate)/20.83-amount;
	}

}
