package edu.waketech.ccave.item;

public class Puppy extends CCaveItem{

	public static final String MY_NAME = "puppy";
	private static boolean afraid = true;
	public Puppy() {
		super(MY_NAME);
	}

	public boolean happyPup(boolean jinglingKeys) {
		if (jinglingKeys) {
			return afraid = true;
		}
		else return afraid = false;
	}
}
