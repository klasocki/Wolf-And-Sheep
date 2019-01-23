/*
This game is made by Karol Lasocki, 2018. All rights reserved
It's a computer version of the "WolfModel and SheepModel" chessboard game, featuring a simple GUI
I create it for learning
DONE Make it playable
TODO Refactor!!!!!
TODO Use factory design pattern to create pieces
TODO Make the game handle turns
TODO Add winning messages
TODO Add undo and other control buttons, and help button
TODO Use images of pieces
TODO make an android distribution
TODO Add artificial intelligence
TODO Make AI intelligent. Use machine learning
 */

package game;

import board.ChessboardModel;
import board.ChessboardView;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import pieces.*;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {
    ChessboardModel chessboardModel;
    ChessboardView chessboardView;

    @Override
    public void start(Stage window) {
        window.setTitle("Wolf and Sheep - Chessboard game");
        window.setOnCloseRequest(event -> {
            event.consume();
            closeWindows();
        });
        HBox layout = new HBox();
        layout.setPadding(new Insets(10, 0, 10, 10));
        VBox rightMenu = new VBox(30);
        Button undoButton = new Button("Undo");
        Button restartButton = new Button("Restart");
        Button quitButton = new Button("Back to menu");
        quitButton.setMinHeight(50);
        undoButton.minHeightProperty().bind(quitButton.minHeightProperty());
        undoButton.prefWidthProperty().bind(quitButton.widthProperty());
        restartButton.minHeightProperty().bind(quitButton.minHeightProperty());
        restartButton.prefWidthProperty().bind(quitButton.widthProperty());

        rightMenu.setPadding(new Insets(20,0,20,20));
        rightMenu.setAlignment(Pos.BASELINE_RIGHT);
        rightMenu.getChildren().addAll(undoButton, restartButton, quitButton);
        GameController gameController = GameController.initGame(true);
        GridPane boardView = getChessboardGrid(window, gameController);

        undoButton.setOnAction(event -> {
            gameController.undoLastMove();
        });

        window.setScene(new Scene(layout, 820, 620));
        window.setResizable(false);
        layout.getChildren().addAll(boardView, rightMenu);

        window.show();
    }

    private GridPane getChessboardGrid(Stage window, GameController gameController) {
        GridPane boardView = gameController.getChessboardGrid();
        boardView.prefWidthProperty().bind(window.widthProperty().subtract(200));
        return boardView;
    }

    private void closeWindows() {
        boolean answer = ConfirmationBox.display("Exiting Wolf and Sheep",
                "Are you sure you want to quit? Your game progress will be lost");
        if (answer) {
            Platform.exit();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
