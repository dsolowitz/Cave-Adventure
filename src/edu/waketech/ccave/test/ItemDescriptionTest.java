package edu.waketech.ccave.test;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import edu.waketech.ccave.item.Gate;
import edu.waketech.ccave.item.GoldNugget;
import edu.waketech.ccave.item.Keys;
import edu.waketech.ccave.item.Ladder;
import edu.waketech.ccave.item.Lamp;
import edu.waketech.ccave.item.Puppy;
import edu.waketech.ccave.item.Water;


public class ItemDescriptionTest {
	@Test
	public void testGateLongDescription() {
		Gate gate = new Gate();
		assertEquals(gate.getLongDescription(), "an old rusty gate");
	}
	@Test
	public void testGateShortDescription() {
		Gate gate = new Gate();
		assertEquals(gate.getShortDescription(), "a gate");
	}
	@Test
	public void testGateID() {
		Gate gate = new Gate();
		assertEquals(gate.getId(), "gate");
	}
	@Test
	public void testGateLocation() {
		Gate gate = new Gate();
		assertEquals(gate.getLocation(), "left hall");
	}
	@Test
	public void testGoldNuggetLongDescription() {
		GoldNugget nug = new GoldNugget();
		assertEquals(nug.getLongDescription(), "shiny gold nugget");
	}
	@Test
	public void testKeyLongDescription() {
		Keys key = new Keys();
		assertEquals(key.getLongDescription(), "old rusty key");
	}
	@Test
	public void testLadderLongDescription() {
		Ladder ladder = new Ladder();
		assertEquals(ladder.getLongDescription(), "a tall wooden ladder");
	}
	@Test
	public void testLampLongDescription() {
		Lamp lamp = new Lamp();
		assertEquals(lamp.getLongDescription(), "rusty old lamp");
	}
	@Test
	public void testPuppyLongDescription() {
		Puppy pup = new Puppy();
		assertEquals(pup.getLongDescription(), "a scared little puppy");
	}
	@Test
	public void testWaterLongDescription() {
		Water water = new Water();
		assertEquals(water.getLongDescription(), "large container of water");
	}
}
