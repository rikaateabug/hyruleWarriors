package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Ellipse;


public class MapGUI extends Application {

	private Level[][] level = new Level[8][16];
	private Label lblStatus = new Label("I am a placeholder");
	
	@Override
	public void start(Stage primaryStage) {
		try {
			//Pane to hold cell
			GridPane pane = new GridPane();
			for (int i = 0; i < 8; i++)
				for (int j = 0; j < 16; j++)
					pane.add(level[i][j] = new Level(i, j), j, i);
		
			BorderPane borderPane = new BorderPane();
			borderPane.setCenter(pane);
			borderPane.setRight(lblStatus);
		
			
			//Create a scene and place it on the stage
			Scene scene = new Scene(borderPane, 450, 170);
			primaryStage.setTitle("Adventure Map");
			primaryStage.setScene(scene);
			primaryStage.show();
			
	
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
