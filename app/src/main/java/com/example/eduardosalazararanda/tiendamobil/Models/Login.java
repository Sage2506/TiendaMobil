package com.example.eduardosalazararanda.tiendamobil.Models;

import com.google.gson.annotations.SerializedName;

public class Login{

	@SerializedName("Email")
	private String email;

	@SerializedName("RememberMe")
	private String rememberMe;

	@SerializedName("Password")
	private String password;

	public void setEmail(String email){
		this.email = email;
	}

	public String getEmail(){
		return email;
	}

	public void setRememberMe(String rememberMe){
		this.rememberMe = rememberMe;
	}

	public String getRememberMe(){
		return rememberMe;
	}

	public void setPassword(String password){
		this.password = password;
	}

	public String getPassword(){
		return password;
	}
}