package com.Atsiliepimai.Application;

import com.Atsiliepimai.View.Dashboard;

import javafx.application.Application;
import javafx.stage.Stage;

public class main extends Application {	
	@Override
	public void start(Stage primaryStage) {
		Dashboard dashboard = new Dashboard(primaryStage);
	}
	
	public static void main(String[] args) {
		launch(args);
	}	
}
