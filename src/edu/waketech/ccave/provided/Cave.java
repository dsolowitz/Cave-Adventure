package edu.waketech.ccave.provided;

import java.io.Serializable;

import edu.waketech.ccave.gui.AdventureGUI;
import edu.waketech.ccave.gui.MainController;


/**
 * Main method and user interface for our console-based Colossal Cave Adventure
 * Game.
 * 
 * @author parks
 *
 */
public class Cave  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7858950003287796977L;
	public static final String START_ROOM = "wellhouse";
	
	
	 public static Spelunker caveMan = null;
	 public static InputParser playerInput = InputParser.getInputParser();
	 transient public static MainController controller = AdventureGUI.getController();
	
	
	public static void load() {
		
		caveMan = SaveLoad.load();
		controller.setGameText(caveMan.getLongDescription());

	}
	public static void running() {
			
				if (caveMan == null){
				caveMan = new Spelunker(START_ROOM);}
				controller.setGameText("");

				playerInput.readInput();
				if (playerInput.getInputType() == InputType.MOVE) caveMan.move(playerInput.getDirection());
				else if (playerInput.getInputType() == InputType.LOOK) controller.setGameText(caveMan.getLongDescription());
				else if (playerInput.getInputType() == InputType.INVENTORY ) {
					ItemCommand cmd = playerInput.getItemCommand();
					String item = playerInput.getcCaveItemName();
					caveMan.changeInventory(cmd,  item);
					if(cmd == ItemCommand.DRINK || cmd == ItemCommand.EAT) {
						caveMan.otherCommand(cmd, item);
					}
					else if ( cmd == ItemCommand.ON || cmd == ItemCommand.OFF) {
						caveMan.otherCommand(cmd, item);
						controller.appendGameText(caveMan.getLongDescription());
					}
				}
			else if (playerInput.getInputType() == InputType.OTHER) {
				ItemCommand cmd = playerInput.getItemCommand();
				String item = playerInput.getcCaveItemName();
				caveMan.otherCommand(cmd, item);
			}
			if (playerInput.getVerb().equals("save")) {
				SaveLoad.save(caveMan);	
				controller.setGameText("You saved your game! ");
				}
			controller.appendGameText(caveMan.getLongDescription());

	}
}
