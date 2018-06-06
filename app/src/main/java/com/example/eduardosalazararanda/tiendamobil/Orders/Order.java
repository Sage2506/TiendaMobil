package com.example.eduardosalazararanda.tiendamobil.Orders;

import com.example.eduardosalazararanda.tiendamobil.Product.Product;
import com.google.gson.annotations.SerializedName;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.TimeZone;

public class Order{
	public Order(Product product, String client) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeZone(TimeZone.getTimeZone("GMT-6"));
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		this.product = product.getCode();
		this.client = client;
		this.descriptionProduct = product.getName();
		this.orderDate = dateFormat.format(calendar.getTime());
		this.productPrice = product.getPrice();
	}

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
	private String productPrice;

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

	public void setProductPrice(String productPrice){
		this.productPrice = productPrice;
	}

	public String getProductPrice(){
		return productPrice;
	}

	public void setLongitude(int longitude){
		this.longitude = longitude;
	}

	public int getLongitude(){
		return longitude;
	}
}