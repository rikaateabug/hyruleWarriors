package application;

import javafx.scene.layout.Pane;

public class Level extends Pane {

	private boolean status = false;					// Completed or not
	private int row;								// Ex: 1-1
	private int col;
	private String name;							// "Fight as a warrior of water"
	private String victoryConditions;				// Defeat whatever
	private String itemCardsRequired;				// Bomb etc.
	private String aVictory;				
	private String battleVictory;
	private String treasure;
	private String unlockableAreas;
	private String limitedCharas;
	private String difficulty;
	
	
	public Level(int r, int c) {
		row = r;
		col = c;
		
		setStyle("-fx-border-color: black");
		this.setPrefSize(2000, 2000);
		
		/**		//NOTE - USE THIS FORMATTING TO PREVENT RESIZING
		this.setMinWidth(20);
		this.setPrefWidth(20);
		this.setMaxWidth(20);
		
		this.setMinHeight(20);
		this.setPrefHeight(20);
		this.setMaxHeight(20);
		*/
			
		this.setOnMouseClicked(e -> handleMouseClick());
	}
	
	public void setInfo() {
		
	}
	
	public void changeStatus() {
		//Completed or not?
	}
	
	public void handleMouseClick() {
		//When clicked show the info on the right
		
	}
	
}
