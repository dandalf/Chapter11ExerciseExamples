package edu.cis232.question9;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TicTacToeApp extends Application {

	private Image[] images;
	private GridPane gridPane;
	private ImageView[][] boardImages;

	public static void main(String[] args){
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		TicTacToe ticTacToe = new TicTacToe();
		Image imgX = new Image("file:X.png");
		Image imgO = new Image("file:O.png");
		images = new Image[]{imgO, imgX};

		gridPane = new GridPane();
		gridPane.setVgap(5);
		gridPane.setHgap(5);
		boardImages = new ImageView[3][3];

		showBoard(ticTacToe);

		Label lblResult = new Label("");

		Button btnSimulate = new Button("Simulate");
		btnSimulate.setOnAction(e -> {
			ticTacToe.simulateBoard();
			showBoard(ticTacToe);
			switch(ticTacToe.getResult()){
				case 0:
					lblResult.setText("O Wins!");
					break;
				case 1:
					lblResult.setText("X Wins!");
					break;
				default:
					lblResult.setText("Tie Game!");
			}
		});

		VBox mainLayout = new VBox(gridPane, btnSimulate, lblResult);
		mainLayout.setAlignment(Pos.CENTER);
		mainLayout.setPadding(new Insets(20));
		mainLayout.setSpacing(10);

		primaryStage.setScene(new Scene(mainLayout));
		primaryStage.setTitle("Tic Tac Toe Simulator");
		primaryStage.show();
	}

	private void showBoard(TicTacToe ticTacToe) {
		int[][] board = ticTacToe.getBoard();
		for(int row = 0; row < board.length; row++ ){
			for(int col = 0; col < board.length; col++){
				int val = board[row][col];
				Image image = images[val];
				boardImages[row][col] = new ImageView(image);
				gridPane.add(boardImages[row][col], col, row);
			}
		}
	}
}
