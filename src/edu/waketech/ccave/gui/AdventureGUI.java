package edu.waketech.ccave.gui;

import java.io.IOException;
import java.io.Serializable;

import edu.waketech.ccave.provided.Cave;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;   


public class AdventureGUI extends Application   {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6721752197478878312L;
	/**
	 * 
	 */
	public static MainController controller;
	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/edu/waketech/ccave/gui/AdventureGUIFXML.fxml"));
        Parent root = loader.load();
        primaryStage.setScene(new Scene(root, 650,400));
        primaryStage.show();
        controller = loader.getController();
	}

public static void main(String[] args) throws IOException {
		launch(args);

	}



public static MainController getController() {
	// TODO Auto-generated method stub
	return controller;
}
}