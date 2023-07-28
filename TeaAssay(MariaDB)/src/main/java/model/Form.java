package model;

import java.io.Serializable;

public class Form implements Serializable{
	private String name,email,title,textarea;
	
	public Form(){
		this.name = "";
		this.email = "";
		this.title = "";
		this.textarea = "";
	}
	
	public Form(String name,String email,String title,String textarea){
		this.name = name;
		this.email = email;
		this.title = title;
		this.textarea = textarea;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getTextArea() {
		return textarea;
	}
	
	public void setTextArea(String textarea) {
		this.textarea = textarea;
	}

}
