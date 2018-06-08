package edu.waketech.ccave.location;

import java.util.ArrayList;
import java.util.Properties;
import java.util.Scanner;

import edu.waketech.ccave.common.CCaveElement;
import edu.waketech.ccave.common.Direction;
import edu.waketech.ccave.common.ItemDirectory;
import edu.waketech.ccave.common.RoomDirectory;
import edu.waketech.ccave.item.CCaveItem;

public abstract class CCaveRoom implements CCaveElement{

	private String roomIdentifier;
	private Properties props;
	
	public CCaveRoom(String roomId) {
		roomIdentifier = roomId;
		props = CCaveElement.getPropertiesForId(roomIdentifier);
		
	}
	
	public CCaveRoom nextRoom(Direction dir) {
		ArrayList<Object> keys = new ArrayList<>();
		keys.addAll(props.keySet());
		if(keys.contains(dir.toString().toLowerCase())) {
			String nextRoom = props.getProperty(dir.toString().toLowerCase());
			RoomDirectory list = RoomDirectory.getInstance();
			CCaveRoom room = list.get(nextRoom);
			return room;
		}
		else return this;
	}

	public Properties getProps() {
		return this.props;
	}
	
	public ArrayList<CCaveItem> getRoomItems(){
		ItemDirectory itemDir = ItemDirectory.getInstance(); 
		if (itemDir.getItemsInRoom(roomIdentifier).size() < 1) return null;
		return itemDir.getItemsInRoom(roomIdentifier);
	}
	@Override
	public String getLongDescription() {
		return props.getProperty(CCaveElement.LONG_DESCRIPTION);
	}
	@Override
	public String getShortDescription() {
		return props.getProperty(CCaveElement.SHORT_DESCRIPTION);
	}
	@Override
	public String getId() {
		return roomIdentifier;
	}

	@Override
	public boolean isId(String identifier) {
		return this.roomIdentifier.equalsIgnoreCase(identifier);
	}
	public String getContentsLongDescription() {
		ItemDirectory itemDir = ItemDirectory.getInstance();
		
		String itemsDesc = "";
		for (CCaveItem i: itemDir.getItemsInRoom(roomIdentifier) ) {
			itemsDesc += " " + i.getLongDescription();
		}
		if (itemDir.getItemsInRoom(roomIdentifier).isEmpty()) return "nothing";
		return itemsDesc;
	}
	public String getContentsShortDescription() {
		ItemDirectory itemDir = ItemDirectory.getInstance();
		String itemsDesc = "";
		for (CCaveItem i: itemDir.getItemsInRoom(roomIdentifier) ) {
			itemsDesc += " " + i.getShortDescription();
		}
		if (itemDir.getItemsInRoom(roomIdentifier).isEmpty()) return "nothing";
		return itemsDesc;
		
	}
	@Override
	public String toString() {
		return "CCaveRoom [identifier=" + roomIdentifier + ", props=" + props
				+ "]";
	}
}
