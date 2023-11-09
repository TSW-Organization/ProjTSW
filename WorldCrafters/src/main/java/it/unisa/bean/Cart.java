package it.unisa.bean;

import java.io.Serializable;

public class Cart extends Product implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private int id;
	private int userId;
	
	@Override
	public int getId() {
		return id;
	}
	
	@Override
	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	
}
