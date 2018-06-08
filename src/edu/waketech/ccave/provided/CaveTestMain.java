package edu.waketech.ccave.provided;

import java.io.IOException;

import edu.waketech.ccave.common.Direction;

/**
 * A place with a main method where we can code some tests of our cave code.
 * 
 * @author parks
 *
 */
public class CaveTestMain {

	public static void main(String[] args) throws IOException {

		// First some sanity checks.
		// CCaveMap caveMap = CCaveMap.accessMap();
		Spelunker me = new Spelunker("wellhouse");
		System.out.println(me.getLongDescription());
		me.move(Direction.N);
		System.out.println(me.getLongDescription());
		me.move(Direction.N);
		System.out.println(me.getLongDescription());
		me.move(Direction.E);
		System.out.println(me.getLongDescription());
		System.out.println(Direction.N);
	}

}
