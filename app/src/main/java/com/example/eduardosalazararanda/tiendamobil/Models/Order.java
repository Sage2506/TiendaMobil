package com.example.eduardosalazararanda.tiendamobil.Models;

import com.google.gson.annotations.SerializedName;

public class Order{

	@SerializedName("product")
	private String product;

	@SerializedName("precition")
	private Object precition;

	@SerializedName("orderId")
	private String orderId;

	@SerializedName("latitude")
	private int latitude;

	@SerializedName("pay")
	private Object pay;

	@SerializedName("phone")
	private String phone;

	@SerializedName("client")
	private String client;

	@SerializedName("payment")
	private String payment;

	@SerializedName("state")
	private String state;

	@SerializedName("descriptionProduct")
	private String descriptionProduct;

	@SerializedName("orderDate")
	private String orderDate;

	@SerializedName("productPrice")
	private int productPrice;

	@SerializedName("longitude")
	private int longitude;

	public void setProduct(String product){
		this.product = product;
	}

	public String getProduct(){
		return product;
	}

	public void setPrecition(Object precition){
		this.precition = precition;
	}

	public Object getPrecition(){
		return precition;
	}

	public void setOrderId(String orderId){
		this.orderId = orderId;
	}

	public String getOrderId(){
		return orderId;
	}

	public void setLatitude(int latitude){
		this.latitude = latitude;
	}

	public int getLatitude(){
		return latitude;
	}

	public void setPay(Object pay){
		this.pay = pay;
	}

	public Object getPay(){
		return pay;
	}

	public void setPhone(String phone){
		this.phone = phone;
	}

	public String getPhone(){
		return phone;
	}

	public void setClient(String client){
		this.client = client;
	}

	public String getClient(){
		return client;
	}

	public void setPayment(String payment){
		this.payment = payment;
	}

	public String getPayment(){
		return payment;
	}

	public void setState(String state){
		this.state = state;
	}

	public String getState(){
		return state;
	}

	public void setDescriptionProduct(String descriptionProduct){
		this.descriptionProduct = descriptionProduct;
	}

	public String getDescriptionProduct(){
		return descriptionProduct;
	}

	public void setOrderDate(String orderDate){
		this.orderDate = orderDate;
	}

	public String getOrderDate(){
		return orderDate;
	}

	public void setProductPrice(int productPrice){
		this.productPrice = productPrice;
	}

	public int getProductPrice(){
		return productPrice;
	}

	public void setLongitude(int longitude){
		this.longitude = longitude;
	}

	public int getLongitude(){
		return longitude;
	}
}