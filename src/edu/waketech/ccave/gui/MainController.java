package edu.waketech.ccave.gui;


import java.io.Serializable;


import edu.waketech.ccave.provided.Cave;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class MainController implements Serializable  {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -7036143504453192682L;
	/**
	 * 
	 */
	@FXML
	transient private Label gamePrint;
	@FXML
	transient private  TextField choiceEntry;
	
	
	 transient private  String textEntry;
	
	 transient private  String gameText;
	
	
	public void loadGame(ActionEvent e)  {

		Cave.load();
		gamePrint.setText(gameText + "What would you like to do?");
	}
	
	public void playGame(ActionEvent e) {
		textEntry = choiceEntry.getText();
		choiceEntry.setText("");
		Cave.running();
		gamePrint.setText(getGameText() );

	}
	public String getTextEntry() {
		return textEntry;
	}

	public void setTextEntry(String textEntrys) {
		textEntry = textEntrys;
	}

	public  String getGameText() {
		return gameText;
	}

	public  void setGameText(String gameText) {
		this.gameText = gameText;
	}
	
	public void appendGameText(String appendText) {
		this.gameText += appendText;
	}
	
	public Label getGameTextLabel() {
		return this.gamePrint;
	}
	public  MainController getInstance(){
		return this;
	}
}
