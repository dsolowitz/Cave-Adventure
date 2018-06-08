package edu.waketech.ccave.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import edu.waketech.ccave.item.CCaveItem;
import edu.waketech.ccave.item.Food;

public class FoodTest {

	@Test
	public void testGetLongDescription() {
		CCaveItem cci = new Food();
		assertEquals("some tasty food", cci.getLongDescription());
	}

	@Test
	public void testGetShortDescription() {
		CCaveItem cci = new Food();
		assertEquals("some food", cci.getShortDescription());
	}

	@Test
	public void testGetId() {
		CCaveItem cci = new Food();
		assertEquals("food", cci.getId());
	}

	@Test
	public void testGetLocation() {
		CCaveItem cci = new Food();
		assertEquals("wellhouse", cci.getLocation());
	}

	@Test
	public void testIsId0() {
		CCaveItem cci = new Food();
		assertTrue(cci.isId("FooD"));
	}

	@Test
	public void testIsId1() {
		CCaveItem cci = new Food();
		assertFalse(cci.isId("sophie"));
	}

}
