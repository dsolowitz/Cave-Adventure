package edu.waketech.ccave.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import edu.waketech.ccave.common.Direction;
import edu.waketech.ccave.provided.Spelunker;

public class DirectionTest {

	
	 @Test
	 public void testEquals() {
	 assertTrue(Direction.N.toString().equalsIgnoreCase("n"));
	 }

	 /**
	  * Test that Direction.N.isSynonym("North") is true
	  */
	 @Test
	 public void testIsSynonym4() {
	 Direction d = Direction.N;
	 assertTrue(d.isSynonym("Northernmost"));
	 
	 }

	  @Test
	 public void testIsSynonym1() {
	 Direction d = Direction.findSynonym("d");
	 assertEquals(Direction.DOWN, d);
	 }
	 
	  @Test
		 public void testIsSynonym2() {
		 Direction d = Direction.findSynonym("misspelled");
		 assertEquals(Direction.UNKNOWN, d);
		 }
	  
	  @Test
		 public void testIsSynonym3() {
		 Direction d = Direction.findSynonym("go up");
		 assertEquals(Direction.UP, d);
		 }
	  
	  @Test
		 public void testIsSynonym5() {
		 Direction d = Direction.findSynonym("go down");
		 assertEquals(Direction.DOWN, d);
		 }
		@Test  
		  public void testIsSynonym6() {
				 Direction d = Direction.N;
				 assertFalse(d.isSynonym("go down"));		 
				 }
		@Test
		  public void testIsSynonym7() {
				 Direction d = Direction.NE;
				 assertTrue(d.isSynonym("Northeast"));
				 }
		@Test
		  public void testIsSynonym8() {
				 Direction d = Direction.UNKNOWN;
				 assertFalse(d.isSynonym("Northernmost"));
				  }
		@Test
		  public void testIsSynonym9() {
				 Direction d = Direction.DOWN;
				 assertTrue(d.isSynonym("go down"));
				  }
		@Test
		  public void testIsSynonym10() {
				 Direction d = Direction.SW;
				 assertTrue(d.isSynonym("go southwest"));
				  }
		 @Test
		 public void testIsSynonym11() {
		 Direction d = Direction.findSynonym("se");
		 assertEquals(Direction.SE, d);
		 }
		 @Test
		 public void testIsSynonym12() {
		 Direction d = Direction.findSynonym("go southeast");
		 assertEquals(Direction.SE, d);
		 }
		 
		 @Test
		 public void testNextRoom1() {
			 
			 Spelunker caveMan = new Spelunker("wellhouse");
			 caveMan.move(Direction.N);
			 assertEquals(caveMan.getCurrentLocation(),"caveentrance");
		 }
	
}
