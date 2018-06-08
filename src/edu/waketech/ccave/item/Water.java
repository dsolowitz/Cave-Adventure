package edu.waketech.ccave.item;

import edu.waketech.ccave.common.ItemDirectory;
import edu.waketech.ccave.location.CCaveRoom;
import edu.waketech.ccave.provided.ItemCommand;

public class Water extends CCaveItem {

	public static final String MY_NAME = "water";
	public Water() {
		super(MY_NAME);// TODO Auto-generated constructor stub
	}

	@Override
	public void executeCommand(ItemCommand cmd, String item, CCaveRoom currentLocation) {
	if(cmd.equals(ItemCommand.DRINK)) {
		ItemDirectory itemdirec = ItemDirectory.getInstance();
		itemdirec.remove(this);
		System.out.println("No more water bro!");
	}
	}
}
