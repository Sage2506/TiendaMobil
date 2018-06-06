package com.example.eduardosalazararanda.tiendamobil.Orders;

import com.example.eduardosalazararanda.tiendamobil.Product.Product;
import com.google.gson.annotations.SerializedName;

import java.util.Calendar;


public class OrderToPost{

	public OrderToPost(Product product, String client) {
		this.product = product.getCode();
		this.client = client;
		this.descriptionProduct = product.getName();
		this.orderDate = null;
		this.productPrice = product.getPrice();
	}
	@SerializedName("DescriptionProduct")
	private String descriptionProduct;

	@SerializedName("product")
	private String product;

	@SerializedName("Phone")
	private String phone;

	@SerializedName("State")
	private String state;

	@SerializedName("ProductPrice")
	private String productPrice;

	@SerializedName("Client")
	private String client;

	@SerializedName("OrderDate")
	private String orderDate;

	public void setDescriptionProduct(String descriptionProduct){
		this.descriptionProduct = descriptionProduct;
	}

	public String getDescriptionProduct(){
		return descriptionProduct;
	}

	public void setProduct(String product){
		this.product = product;
	}

	public String getProduct(){
		return product;
	}

	public void setPhone(String phone){
		this.phone = phone;
	}

	public String getPhone(){
		return phone;
	}

	public void setState(String state){
		this.state = state;
	}

	public String getState(){
		return state;
	}

	public void setProductPrice(String productPrice){
		this.productPrice = productPrice;
	}

	public String getProductPrice(){
		return productPrice;
	}

	public void setClient(String client){
		this.client = client;
	}

	public String getClient(){
		return client;
	}

	public void setOrderDate(String orderDate){
		this.orderDate = orderDate;
	}

	public String getOrderDate(){
		return orderDate;
	}
}