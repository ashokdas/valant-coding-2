package com.valant.ims;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class IMSImpl implements InventoryManagementSystem, Runnable {

	private static HashMap<String, Item> inventory = new HashMap<String, Item>();

	public String AddItem(String label, String type, String expiryDate) {

		String response;

		synchronized (this) {
			if (inventory.containsKey(label)) {
				response = StatusMessages.ITEM_EXISTS;
				return response;

			} else {
				Date expiryDateConverted = null;
				DateFormat df = new SimpleDateFormat("mm/dd/yyyy");
				try {
					 expiryDateConverted = df.parse(expiryDate);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					response = StatusMessages.DATE_FORMAT_ERROR;
					return response;
				}
				

				Item newItem = new Item(label, type, expiryDateConverted);
				inventory.put(label, newItem);
				response = StatusMessages.ITEM_ADDED;

			}

		}

		return response;
	}

	public String TakeItem(String label) {
		String response;

		synchronized (this) {
			if (!inventory.containsKey(label)) {
				response = StatusMessages.ITEM_DOESNT_EXIST;

			} else {
				inventory.remove(label);
				response = StatusMessages.ITEM_REMOVED;

			}

		}

		return response;
	}

	public String ExpiryNotification() {
		
		StringBuilder notification = new StringBuilder();
		notification.append(StatusMessages.ITEM_EXPIRY_NOTICE);
		Calendar cal = Calendar.getInstance();
		Date today = cal.getTime();
		for(Map.Entry<String, Item> item : inventory.entrySet())
		{
			if(item.getValue().getExpiryDate().before(today))
			{
				notification.append(item.getKey());
				notification.append(",");
			}
		}
		String response = new String(notification);
		return response;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("The thread has started");

	}

}
