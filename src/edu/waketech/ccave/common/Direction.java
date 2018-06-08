package edu.waketech.ccave.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

/**
 * All possible directions that a player can travel.
 * We read a properties file to determine the synonyms
 * for each direction.
 * 
 * This enum reads a properties file for each enum value in the resources directory, such as
 *<ul>
 *<li> n.properties
 *<li> s.properties
 *<li>etc.
 *</ul>
 * The keys of these properties files don't really matter--the values do.  So
 * for Direction.N,
 * in n.properties
 * <ul>
 * <li>n=north
 * <li>n1=othernorthvalue
 * <li>n2=anothernorthvalue
 * </ul>
 * will all define synonym String values for Direction.N.
 * 
 * @author parks
 *
 */
public enum Direction {

	N(), 
	S(), 
	E(), 
	W(), 
	NE(), 
	NW(), 
	SE(), 
	SW(), 
	UP(), 
	DOWN(), 
	UNKNOWN();

	public static final String RESOURCE_DIR = "resources/";
	
	private final ArrayList<String> synonyms = new ArrayList<>();
	
	/**
	 * enum-wide method to provide a more friendly valueOf method.
	 * We take a String representation of an enum value or synonym
	 * and, ignoring case, return the corresponding Direction enum value.
	 * 
	 * This method steps through every possible enum value, which it
	 * can do using 
	 * 
	 * values().
	 * 
	 * It then tests whether possibleAlt matches one of those values.  
	 * (See isSynonym)
	 * 
	 * @param possibleAlt String representing a case-insensitive, synonym-based Direction value
	 * 
	 * @return the Direction value associated with possibleAlt, or Direction.UNKNOWN
	 */
	public static Direction findSynonym(String possibleAlt) {
		for (Direction currentDir : values()) {
			if (currentDir.toString().toLowerCase().equalsIgnoreCase(possibleAlt))
				return currentDir;
			if (currentDir.isSynonym(possibleAlt.toLowerCase())) return currentDir;
		}
		return Direction.UNKNOWN;
	}


	private Direction() {
		Properties p = new Properties();
		FileInputStream fis = null;
		try {
			File f = new File(RESOURCE_DIR + this.toString().toLowerCase() + ".properties");
			fis = new FileInputStream(f);
			p.load(fis);
			for (Object key : p.keySet()) {
				String synWord = (String) key;
				String directionSyn = p.getProperty(synWord.toLowerCase());
					synonyms.add(directionSyn.toLowerCase());
			}
		} catch (IOException e) {
			System.out.println("no nls file for " + this);
		} finally {
			if (fis != null)
				try {
					fis.close();
				} catch (IOException e) {
				}
			fis = null;
		}
	}
	
	/**
	 * Determine whether a given String value represents this
	 * Direction value ignoring case, or one of its synonyms
	 * ignoring case.
	 * 
	 * @param possibleAlt a possible String representation of this Direction or
	 * one of its synonym values
	 * 
	 * @return true if possibleAlt is a valid String value for this Direction or
	 * one of its synonyms, all ignoring case
	 */
	public boolean isSynonym(String possibleAlt) {
		if (this.toString().equalsIgnoreCase(possibleAlt)) return true;
		for (String syn: synonyms) {
			if (syn.equalsIgnoreCase(possibleAlt.toLowerCase())) return true;
		}
		return false;
	}
	
	/**
	 * Determines if isSynonym in a static context
	 * @param String s, is the string that requires testing of its status as a synonym
	 * @return boolean; true if synonym, else fails
	 * @author Occhipinti
	 */
//	public static boolean isStaticSynonym(String s) {
//	    for(Direction direction : Direction.values()) {
//	        if(direction.synonyms.contains(s) || s.equals(direction.toString())) return true;
//	    }
//	    return false;
//	}
	
	
	
}
