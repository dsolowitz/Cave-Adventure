package edu.waketech.ccave.location;

import java.util.ArrayList;

import edu.waketech.ccave.common.Direction;
import edu.waketech.ccave.common.ItemDirectory;
import edu.waketech.ccave.gui.AdventureGUI;
import edu.waketech.ccave.gui.MainController;
import edu.waketech.ccave.item.CCaveItem;
import edu.waketech.ccave.item.Lamp;
import edu.waketech.ccave.provided.Spelunker;

public class CobbleCrawl extends CCaveRoom {

	public static final String MY_NAME = "cobblecrawl";
	private boolean dark = true;
	private Direction nextDir;
	private ItemDirectory itemDir = ItemDirectory.getInstance();
	private ArrayList<CCaveItem> contents = itemDir.getItemsInRoom(Spelunker.SPELUNKER_ID);
	private CCaveItem lamp = itemDir.get("lamp");
	transient public static MainController controller = AdventureGUI.getController();

	
	public CobbleCrawl() {
		super(MY_NAME);
	}
	public boolean isDark() {
		return dark;
	}
	public void setDark(boolean dark) {
		this.dark = dark;
	}
	@Override
	public CCaveRoom nextRoom(Direction dir)  {
		
		nextDir = dir;
		if (Direction.W.toString().equals(dir.toString())) {
			try {
				if (lamp.getLocation().equals(Spelunker.SPELUNKER_ID)) {
					if(((Lamp) lamp).getLamp()) {
						return super.nextRoom(nextDir);
					}
					else {controller.setGameText("Turn on your lamp dummy! ");
					return this;
					}
				}
				else {
					controller.setGameText("You don't have a lamp, and it's to dark ahead! ");
					return this;
				}
			}
			catch(NullPointerException e) {
				controller.setGameText("You don't have a lamp, and it's to dark ahead!");
				return this;
			}
			}
		return super.nextRoom(nextDir);
	}

}
