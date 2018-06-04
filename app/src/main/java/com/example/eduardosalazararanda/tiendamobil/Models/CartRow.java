package com.example.eduardosalazararanda.tiendamobil.Models;

import com.google.gson.annotations.SerializedName;

public class CartRow{

	@SerializedName("code")
	private String code;

	@SerializedName("quantity")
	private int quantity;

	@SerializedName("partitionKey")
	private String partitionKey;

	@SerializedName("price")
	private String price;

	@SerializedName("description")
	private String description;

	@SerializedName("rowKey")
	private String rowKey;

	@SerializedName("productName")
	private String productName;

	public void setCode(String code){
		this.code = code;
	}

	public String getCode(){
		return code;
	}

	public void setQuantity(int quantity){
		this.quantity = quantity;
	}

	public int getQuantity(){
		return quantity;
	}

	public void setPartitionKey(String partitionKey){
		this.partitionKey = partitionKey;
	}

	public String getPartitionKey(){
		return partitionKey;
	}

	public void setPrice(String price){
		this.price = price;
	}

	public String getPrice(){
		return price;
	}

	public void setDescription(String description){
		this.description = description;
	}

	public String getDescription(){
		return description;
	}

	public void setRowKey(String rowKey){
		this.rowKey = rowKey;
	}

	public String getRowKey(){
		return rowKey;
	}

	public void setProductName(String productName){
		this.productName = productName;
	}

	public String getProductName(){
		return productName;
	}
}