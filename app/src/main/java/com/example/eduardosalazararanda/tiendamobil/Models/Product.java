package com.example.eduardosalazararanda.tiendamobil.Models;


import com.google.gson.annotations.SerializedName;


public class Product{

	@SerializedName("image")
	private String image;

	@SerializedName("code")
	private String code;

	@SerializedName("price")
	private int price;

	@SerializedName("name")
	private String name;

	@SerializedName("description")
	private String description;

	@SerializedName("category")
	private String category;

	@SerializedName("status")
	private Object status;

	public void setImage(String image){
		this.image = image;
	}

	public String getImage(){
		return image;
	}

	public void setCode(String code){
		this.code = code;
	}

	public String getCode(){
		return code;
	}

	public void setPrice(int price){
		this.price = price;
	}

	public int getPrice(){
		return price;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setDescription(String description){
		this.description = description;
	}

	public String getDescription(){
		return description;
	}

	public void setCategory(String category){
		this.category = category;
	}

	public String getCategory(){
		return category;
	}

	public void setStatus(Object status){
		this.status = status;
	}

	public Object getStatus(){
		return status;
	}

	@Override
 	public String toString(){
		return 
			"ProductsResponse{" + 
			"image = '" + image + '\'' + 
			",code = '" + code + '\'' + 
			",price = '" + price + '\'' + 
			",name = '" + name + '\'' + 
			",description = '" + description + '\'' + 
			",category = '" + category + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}