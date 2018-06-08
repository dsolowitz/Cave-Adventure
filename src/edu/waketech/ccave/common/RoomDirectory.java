package edu.waketech.ccave.common;

import java.io.Serializable;
import java.util.ArrayList;

import edu.waketech.ccave.item.CCaveItem;
import edu.waketech.ccave.location.CCaveRoom;
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

public class RoomDirectory implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2595315498631906871L;

	private ArrayList<CCaveRoom> caveRoom = new ArrayList<>();
	
	private static RoomDirectory instance = new RoomDirectory();
	
	private final CCaveRoom[] ALL_ROOMS = {
			new CobbleCrawl(),
			new BirdChamber(),
			new OpenForest(),
			new SlitInStream(),
			new LongHall(),
			new GiantRoom(),
			new WittsEnd(),
			new HallOfMists(),
			new LimeStonePassage(),
			new WellHouse(),
	};
	
	private RoomDirectory() {
		for (CCaveRoom cci: ALL_ROOMS) {
			caveRoom.add(cci);
		}
	}
	
	public static RoomDirectory getInstance() {
		return instance;
	}
	
	public boolean contains(String id) {
		for (CCaveRoom ele : caveRoom) {
			if (ele.getId().equalsIgnoreCase(id))
				return true;
		}
		return false;
	}
	public int indexOf(String id) {
		int i = 0;
		for (i = 0; i < caveRoom.size(); i++) {
			if (caveRoom.get(i).getId().equalsIgnoreCase(id))
				return i;
		}
		return -1;
	}
	public boolean remove(String id) {
		int i = -1;
		boolean found = false;
		while (!found) {
			i++;
			if (caveRoom.get(i).getId().equalsIgnoreCase(id))
				found = true;
		}
		if (i < caveRoom.size()) {
			caveRoom.remove(i);
			return true;
		}
		return false;
	}
	public CCaveRoom get(String id) {
		int i = indexOf(id);
		if (i == -1) return null;
		return caveRoom.get(i);
	}
	
}
