package com.example.eduardosalazararanda.tiendamobil.Models;

import com.google.gson.annotations.SerializedName;

public class Category{

	@SerializedName("image")
	private String image;

	@SerializedName("code")
	private String code;

	@SerializedName("newImage")
	private Object newImage;

	@SerializedName("name")
	private String name;

	@SerializedName("description")
	private String description;

	@SerializedName("status")
	private boolean status;

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

	public void setNewImage(Object newImage){
		this.newImage = newImage;
	}

	public Object getNewImage(){
		return newImage;
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

	public void setStatus(boolean status){
		this.status = status;
	}

	public boolean isStatus(){
		return status;
	}
}