package edu.waketech.ccave.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import edu.waketech.ccave.common.Direction;
import edu.waketech.ccave.location.CobbleCrawl;
import edu.waketech.ccave.location.BirdChamber;
import edu.waketech.ccave.location.OpenForest;
import edu.waketech.ccave.location.SlitInStream;
import edu.waketech.ccave.location.LongHall;
import edu.waketech.ccave.location.GiantRoom;
import edu.waketech.ccave.location.WittsEnd;
import edu.waketech.ccave.location.HallOfMists;
import edu.waketech.ccave.location.LimeStonePassage;
import edu.waketech.ccave.location.WellHouse;

public class RoomTest {
	public CobbleCrawl cave = new CobbleCrawl();
	
	@Test
	public void testCaveEntranceLongDescription() {
		assertEquals(cave.getLongDescription(), "You are standing outside the entrance to a cave");
	}
	@Test
	public void testCaveEntranceShortDescription() {
		assertEquals(cave.getShortDescription(), "outside");
	}
	@Test
	public void testCaveID() {
		assertEquals(cave.getId(), "cobblecrawl");
	}
	@Test
	public void testNextRoom() {
		assertEquals(cave.nextRoom(Direction.S).getId(), "wellhouse");
	}
	@Test
	public void testNextRoom2() {
		assertEquals(cave.nextRoom(Direction.E).getId(), "slitinstream");
	}
	@Test
	public void testNextRoom3() {
		assertEquals(cave.nextRoom(Direction.NE).getId(), "openforest");
	}
	@Test
	public void testNextRoom4() {
		assertEquals(cave.nextRoom(Direction.W).getId(), "birdchamber");
	}
	@Test
	public void testCaveJunctionID() {
		BirdChamber j = new BirdChamber();
		assertEquals(j.getId(), "birdchamber");
	}
	@Test
	public void testGrassyHillID() {
		OpenForest g = new OpenForest();
		assertEquals(g.getId(), "openforest");
	}
	@Test
	public void testLargeSpring() {
		SlitInStream s = new SlitInStream();
		assertEquals(s.getId(), "slitinstream");
	}
	@Test
	public void testLeftHall() {
		LongHall l = new LongHall();
		assertEquals(l.getId(), "longhall");
	}
	@Test
	public void testMainChamber() {
		GiantRoom m = new GiantRoom();
		assertEquals(m.getId(), "giantroom");
	}
	@Test
	public void testParadise() {
		WittsEnd p = new WittsEnd();
		assertEquals(p.getId(), "wittsend");
	}
	@Test
	public void testRightHall() {
		HallOfMists h = new HallOfMists();
		assertEquals(h.getId(), "hallofmists");
	}
	@Test
	public void testUpperCorridor() {
		LimeStonePassage u = new LimeStonePassage();
		assertEquals(u.getId(), "limestonepassage");
	}
	@Test
	public void testWellHouseID() {
		WellHouse w = new WellHouse();
		assertEquals(w.getId(), "wellhouse");
	}
}
