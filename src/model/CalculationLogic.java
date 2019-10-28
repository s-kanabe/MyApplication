package model;

public class CalculationLogic {
	public double excute(double selectedRecordAlcoholRate, int selectedRecordAmount, int number) { 
		//mustWaterを算出して設定
		double alcoholRate = selectedRecordAlcoholRate;
		int amount = selectedRecordAmount * number;
		double mustWater = (amount*amount*alcoholRate)/20.83-amount;
		return mustWater;
	}

}
