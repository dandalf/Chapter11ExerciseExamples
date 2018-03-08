package edu.cis232.question1;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LatinTranslatorApp extends Application {

	public static void main(String[] args){
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Button btnLeft = new Button("sinister");
		Button btnRight = new Button("dexter");
		Button btnCenter = new Button("medium");
		Label lblResult = new Label();

		EventHandler<ActionEvent> translateToEnglish = event -> {
			if(event.getSource() instanceof Button){
				Button button = (Button)event.getSource();
				lblResult.setText(LatinTranslator.translate(button.getText()));
			}
		};
		btnLeft.setOnAction(translateToEnglish);
		btnRight.setOnAction(translateToEnglish);
		btnCenter.setOnAction(translateToEnglish);

		HBox buttons = new HBox(btnLeft, btnCenter, btnRight);
		buttons.setSpacing(10);
		buttons.setPadding(new Insets(20));
		buttons.setAlignment(Pos.CENTER);

		VBox mainLayout = new VBox(buttons, lblResult);
		mainLayout.setPadding(new Insets(0, 0, 20, 0));
		mainLayout.setAlignment(Pos.CENTER);

		primaryStage.setScene(new Scene(mainLayout));

		primaryStage.setTitle("Latin Translator");
		primaryStage.show();
	}
}
