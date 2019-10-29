package model;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class CalculationLogic {
	public double excute(double selectedRecordAlcoholRate, int selectedRecordAmount, int number) { 
		//mustWaterを算出して設定
		
		BigDecimal bdSelectedAlcoholRate = BigDecimal.valueOf(selectedRecordAlcoholRate); 
		BigDecimal bdSelectedAmount = BigDecimal.valueOf(selectedRecordAmount);
		BigDecimal bdNumber = BigDecimal.valueOf(number);
		
		BigDecimal bdAmount = bdSelectedAmount.multiply (bdNumber);
		BigDecimal a = BigDecimal.valueOf(20.83);
		
		//計算：(amount*amount*alcoholRate)/20.83-amount
		BigDecimal result = bdAmount.multiply(bdAmount.multiply(bdSelectedAlcoholRate));
		BigDecimal result1 = result.divide(a,2,RoundingMode.HALF_UP);
		BigDecimal result2 = result1.subtract(bdAmount);

		
		double mustWater = result2.doubleValue();
		
		if(mustWater <0 ) {
			mustWater = 0;
		}
		
		//
		
		return mustWater;
	}

}
