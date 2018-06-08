package edu.waketech.ccave.provided;

import java.io.Serializable;
import java.util.ArrayList;

import edu.waketech.ccave.common.CCaveElement;
import edu.waketech.ccave.common.Direction;
import edu.waketech.ccave.common.ItemDirectory;
import edu.waketech.ccave.common.RoomDirectory;
import edu.waketech.ccave.item.CCaveItem;
import edu.waketech.ccave.location.CCaveRoom;

/**
 * Our fearless spelunker.
 * 
 * We track the inventory of Items that we're carrying by assigning them the
 * location SPELUNKER_ID. It's not really a "CCaveRoom," but it is a unique
 * String and can let us identify the items we're carrying versus the items that
 * we're not.
 * 
 * 
 * If we were doing a Model-View-Controller design pattern for this game (and
 * we're close, but not quite there), this would be our controller. The types
 * associated with Rooms and Items would be our data model.
 * 
 * @author parks
 *
 */
public class Spelunker implements CCaveElement,Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1786845014557682582L;

	public static final String SPELUNKER_ID = "spelunker";

	public RoomDirectory roomDirec = RoomDirectory.getInstance();

	private CCaveRoom currentLocation;
		
	private ItemDirectory direc;
	
	private ArrayList<CCaveItem> contents;
	
	private ArrayList<CCaveItem> currentStuff = new ArrayList<CCaveItem>();

	/**
	 * Create a spelunker with a given name and starting location.
	 * 
	 * @param startRoom
	 *            Were We Start
	 */
	public Spelunker(String startRoom) {
		currentLocation = roomDirec.get(startRoom);
	}



/**
 * Assign the spelunker to the given location
 * 
 * @param location will become the current location of the spelunker
 */
	public void setLocation(CCaveRoom location) {
		this.currentLocation = location;
	}
	
	/**
	 * Move the player from the current location in the given direction. Update our
	 * state as appropriate.
	 * 
	 * 
	 * @param direction
	 *            Direction to move
	 */
	public void move(Direction direction) {
		
		currentLocation = currentLocation.nextRoom(direction);

	}

	
	public void addItem(CCaveItem item) {
		currentStuff.add(item);
		
	}
	
	public void removeItem(CCaveItem item) {
		currentStuff.remove(item);
	}
	
	public void checkItemsInInventory()  {
		direc = ItemDirectory.getInstance();
		for(CCaveItem item : currentStuff ) {
			try {
			for(CCaveItem items : currentLocation.getRoomItems()) {
				if(items.getId().equals(item.getId())) {
					items.setLocation(SPELUNKER_ID);
				}
				}
			}catch(java.lang.NullPointerException e) {
			}
		}
	}
	
	
	/**
	 * Take some action on an inventory item--pick it up, drop it, etc.
	 * 
	 * Dropped items are assigned to be in our current location. Items that are
	 * picked up are assigned the location SPELUNKER_ID.
	 * 
	 * @param whatToDo
	 *            the command to perform, like GET or DROP
	 * @param objectOfAction
	 *            the item to pick up or drop or do whatever with
	 */
	public void changeInventory(ItemCommand whatToDo, String objectOfAction) {
		ItemDirectory itemDirec = ItemDirectory.getInstance();
		if (whatToDo == ItemCommand.GET) {
			CCaveItem itemObj = itemDirec.get(objectOfAction);
			if (itemObj != null)
				itemObj.setLocation(SPELUNKER_ID);
				addItem(itemObj);
			
		} else if (whatToDo == ItemCommand.DROP) {
			CCaveItem itemObj = itemDirec.get(objectOfAction);
			if (itemObj != null) {
				itemObj.setLocation(currentLocation.getId());
				removeItem(itemObj);
			}
		}
	}

	// NOT I18N CAPABLE
	@Override
	public String getLongDescription()  {
		checkItemsInInventory();
		String cRoom = currentLocation.getLongDescription();
		String roomInventory = currentLocation.getContentsLongDescription();
		
		StringBuilder youHave = new StringBuilder();
		youHave.append("you have\n");
		direc = ItemDirectory.getInstance();
		contents = direc.getItemsInRoom(SPELUNKER_ID);
		for (CCaveItem ele : currentStuff) {
			youHave.append(ele.getLongDescription());
			youHave.append("\n");
		}
		return "You are in " + cRoom + "\nIn here is " + roomInventory + "\nand " + youHave.toString();
	}

	// NOT I18N CAPABLE
	@Override
	public String getShortDescription() {
		checkItemsInInventory();
		String cRoom = currentLocation.getShortDescription();
		StringBuilder youHave = new StringBuilder();
		youHave.append("you have\n");
		for (CCaveItem ele : currentStuff) {
			youHave.append(ele.getShortDescription());
		}
		return "You are in " + cRoom + " and has " + youHave;
	}

	@Override
	public String getId() {
		return SPELUNKER_ID;
	}

	@Override
	public boolean isId(String identifier) {
		return SPELUNKER_ID.equalsIgnoreCase(identifier);
	}

	/**
	 * If we get a command that's classified as "OTHER," we find the item being
	 * manipulated and rely on it to do whatever specific processing is necessary.
	 * 
	 * @param cmd
	 *            The command to be executed
	 * 
	 * @param item
	 *            the item being manipulated
	 */
	public void otherCommand(ItemCommand cmd, String item) {
		// if we can identify the item, we'll operate on it and it alone
		CCaveItem caveItem = ItemDirectory.getInstance().get(item);
		if (caveItem != null) {
			caveItem.executeCommand(cmd, item, currentLocation);
		}
	}
	
	public String getCurrentLocation() {
		return currentLocation.getId();
	}
	
	
}
