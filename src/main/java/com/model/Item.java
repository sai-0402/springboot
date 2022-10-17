package com.model;

import javax.persistence.*;
@Entity
public class Item {
	@Id
	@GeneratedValue
    private int itemId;
    private String itemName;
    private float price;
    private int quant;
	public Item() {
		super();
	}
	
	public Item(int itemId, String itemName, float price, int quant) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.price = price;
		this.quant = quant;
	}

	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getQuant() {
		return quant;
	}
	public void setQuant(int quant) {
		this.quant = quant;
	}
    
    
    
}
