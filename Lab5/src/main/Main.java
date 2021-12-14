package main;

import gui.ControlPane;
import gui.FieldPane;
import gui.SimulationManager;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) {
		HBox root = new HBox(10);
		root.setPadding(new Insets(10));
		root.setPrefHeight(400);
		ControlPane controlPane = new ControlPane();
		SimulationManager.setControlPane(controlPane);
		root.getChildren().add(controlPane);
		FieldPane fieldPane = new FieldPane();
		SimulationManager.setFieldPane(fieldPane);
		root.getChildren().add(fieldPane);
		Scene scene = new Scene(root, 800, 400);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Harvest Simulator");
		primaryStage.setResizable(false);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
