package model;

public class DrinkEntity {
	//フィールド（ID / 酒の名前 / アルコール濃度）
	private int id;
	private String drinkName;
	private double alcoholRate;

	//ゲッター
	public int getId() { return id;}
	public String getDrinkName() { return drinkName;}
	public double getAlcoholRate() { return alcoholRate;}
	
	//セッター
	public void setId(int id) {
		this.id = id;
	}
	public void setDrinkName(String drinkName) {
		this.drinkName = drinkName;
	}
	public void setAlcoholRate(double alcoholRate) {
		this.alcoholRate = alcoholRate;
	}
}
