package test;
import static org.junit.Assert.*;

import org.junit.Test;

import com.valant.ims.IMSImpl;

import com.valant.ims.StatusMessages;


public class TestIMSImpl {

	@Test
	public void testAddItem() {
		IMSImpl imsImpl = new IMSImpl();		
		String response = imsImpl.AddItem("P001", "Seasonal", "04/15/2015");
		assertEquals(response, StatusMessages.ITEM_ADDED);				
	} 
	
	@Test 
	public void testTakeItem() {
		IMSImpl imsImpl = new IMSImpl();
		imsImpl.AddItem("P002", "Seasonal", "06/18/2016");
		String response = imsImpl.TakeItem("P002");
		assertEquals(response, StatusMessages.ITEM_REMOVED);
	}
	
	@Test
	public void testExpiryDate() {
		IMSImpl imsImpl = new IMSImpl();
		imsImpl.AddItem("P001", "Seasonal", "04/15/2015");
		imsImpl.AddItem("P002", "Seasonal", "12/18/2017");
		imsImpl.AddItem("P003", "Perishable", "06/15/2011");
		String response = imsImpl.ExpiryNotification();
		boolean result1 = response.contains("P001");
		assertEquals(result1,true);
		boolean result2 = response.contains("P002");
		assertEquals(result2, false);
		
	}
}
