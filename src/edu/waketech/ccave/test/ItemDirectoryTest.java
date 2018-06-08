package edu.waketech.ccave.test;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import edu.waketech.ccave.common.ItemDirectory;
import edu.waketech.ccave.item.Food;

public class ItemDirectoryTest {

	@Test
	public void testContainsString0() {
		ItemDirectory direc = ItemDirectory.getInstance();
		direc.clear();
		direc.add(new Food());
		assertEquals(1, direc.size());
	}
	
	@Test
	public void testContainsString1() {
		ItemDirectory direc = ItemDirectory.getInstance();
		direc.clear();
		direc.add(new Food());
		assertTrue(direc.contains("FOod"));
	}
	
	@Test
	public void testContainsString2() {
		ItemDirectory direc = ItemDirectory.getInstance();
		direc.clear();
		direc.add(new Food());
		assertEquals(direc.get(0), direc.get("FoOd"));
	}
	
	@Test
	public void testContainsString3() {
		ItemDirectory direc = ItemDirectory.getInstance();
		direc.clear();
		assertEquals(0, direc.size());
		direc.add(new Food());
		assertTrue(direc.remove("fOOd"));
		assertEquals(0, direc.size());
	}
	
	@Test
	public void testContainsString4() {
		ItemDirectory direc = ItemDirectory.getInstance();
		direc.clear();
		assertFalse(direc.contains("food"));
		assertEquals(null, direc.get("fooD"));
	}
	
	@Test
	public void testContainsString5() {
		ItemDirectory direc = ItemDirectory.getInstance();
		direc.clear();
		assertEquals(null, direc.get("fooD"));
	}

}
