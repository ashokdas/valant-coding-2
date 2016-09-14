package com.valant.ims;

import java.util.Date;

public class Item {
	private String label;
	private String type;
	private Date expiryDate;
	
	
	Item(String label, String type, Date expiryDate) {		
		this.label = label;
		this.type = type;
		this.expiryDate = expiryDate;
	}


	public String getLabel() {
		return label;
	}


	public void setLabel(String label) {
		this.label = label;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public Date getExpiryDate() {
		return expiryDate;
	}


	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}	

}
