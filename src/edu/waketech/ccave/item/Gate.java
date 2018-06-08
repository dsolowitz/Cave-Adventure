package edu.waketech.ccave.item;

public class Gate extends CCaveItem {
	
	public static final String MY_NAME = "gate";
	private static boolean gateLocked = true;	
	public Gate() {
		super(MY_NAME);
		// TODO Auto-generated constructor stub
	}

	public boolean unLockGate(boolean keys) {
		if (keys) {
			return gateLocked = false;
		}
		else return true;
	}
}
