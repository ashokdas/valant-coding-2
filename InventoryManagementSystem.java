package com.valant.ims;

import java.util.Date;

public interface InventoryManagementSystem {  
	/**
	 * 
	 * @param label - label of the item to be added
	 * @param type  - type of the item to be added
	 * @param expiryDate - expiry date of the item to be added, in mm/dd/yyyy format
	 * @return - status message
	 */
	
	String AddItem(String label, String type, String expiryDate);  
	
	/**
	 * 
	 * @param label - label of the item to be taken out
	 * @return - status message 
	 */
	
    String TakeItem(String label);
	
	/**
	 * 
	 * @return - Notification with label of expired items
	 */
	
	String ExpiryNotification();
}
 