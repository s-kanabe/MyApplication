package model;

public class GlassEntity{
	//フィールド（ID / グラスの名前 / 量）
	private int id;
	private String glassName;
	private int amount;
	
	//ゲッター
	public int getId() { return id;}
	public String getGlassName() { return glassName;}
	public int getAmount() { return amount;}
	
	//セッター
	public void setId(int id) {
		this.id = id;
	}
	public void setGlassName(String glassName) {
		this.glassName = glassName;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
}
