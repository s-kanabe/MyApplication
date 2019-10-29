package model;
import java.math.BigDecimal;

public class CalculationLogic {
	public double excute(double selectedRecordAlcoholRate, int selectedRecordAmount, int number) { 
		//mustWaterを算出して設定
		
		BigDecimal bdSelectedAlcoholRate = BigDecimal.valueOf(selectedRecordAlcoholRate); 
		BigDecimal bdSelectedAmount = BigDecimal.valueOf(selectedRecordAmount);
		BigDecimal bdNumber = BigDecimal.valueOf(number);
		
		BigDecimal bdAmount = bdSelectedAmount.multiply (bdNumber);
		BigDecimal a = BigDecimal.valueOf(20.83);
		
		//計算：amount*amount*alcoholRate)/20.83-amount
		BigDecimal result = bdAmount.multiply(bdAmount.multiply(bdSelectedAlcoholRate));
		BigDecimal result1 = result.divide(a);
		BigDecimal result2 = result1.subtract(bdAmount);
		
		//値の整理
//		BigDecimal finalResult = result2.setScale(0,BigDecimal.ROUND_HALF_UP);
		
		double mustWater = result2.doubleValue();
		mustWater = Math.round(mustWater);
		
		return mustWater;
	}

}
