package edu.waketech.ccave.item;

/**
 * See the executeCommand method for item-specfic behavior.
 * 
 * @author jparks
 *
 */
public class Food extends CCaveItem {

	public static final String MY_NAME = "food";

	public Food() {
		super(MY_NAME);
	}

	/**
	 * Later we'll enhance this to eat food.  We have to 
	 * figure out the room we're in, and what our player is carrying with
	 * him (her) and what the user input is first.
	 * 
	 * Food that's eaten simply disappears from the game.
	 */


}
