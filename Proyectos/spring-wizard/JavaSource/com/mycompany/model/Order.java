package com.mycompany.model;

public class Order {

	private String name;
	private String email;
	private String drink;
	private String comments;
	
	public Order(String name, String email, String drink, String comments) {
		super();
		this.name = name;
		this.email = email;
		this.drink = drink;
		this.comments = comments;
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

	public String getDrink() {
		return drink;
	}

	public void setDrink(String drink) {
		this.drink = drink;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	@Override
	public String toString() {
		return "Order [name=" + name + ", email=" + email + ", drink=" + drink
				+ ", comments=" + comments + "]";
	}
	
	
	

}
