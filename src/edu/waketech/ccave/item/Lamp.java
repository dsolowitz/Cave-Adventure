package edu.waketech.ccave.item;

import java.io.Serializable;

import edu.waketech.ccave.gui.AdventureGUI;
import edu.waketech.ccave.gui.MainController;
import edu.waketech.ccave.location.CCaveRoom;
import edu.waketech.ccave.provided.ItemCommand;
import javafx.scene.control.Label;

public class Lamp extends CCaveItem implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3273895951891211266L;
	public static final String MY_NAME = "lamp";
	private static boolean LAMPON = false;
	private MainController controller = AdventureGUI.getController();

	public Lamp() {
		super(MY_NAME);
		
	}
	
	@Override
	public void executeCommand(ItemCommand cmd, String item, CCaveRoom currentLocation) {
		if(cmd.equals(ItemCommand.ON)) {
		LAMPON = true;
		controller.setGameText("Dang this lamp is bright for being old and ugly!!! ");
		}
		else if(cmd.equals(ItemCommand.OFF) && LAMPON == true) {
			LAMPON = false;
			controller.setGameText("It got dark again, oops! ");
		}
		}
	
	public boolean getLamp() {
		return LAMPON;
	}
}
