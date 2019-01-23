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
import pieces.*;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage window) throws Exception{
        window.setTitle("Wolf and Sheep - Chessboard game");
        window.setOnCloseRequest(event -> {
            event.consume();
            closeWindow(window);
        });
        HBox layout = new HBox();
        layout.setPadding(new Insets(10, 10, 10, 10));
        VBox rightMenu = new VBox();
        window.setScene(new Scene(layout, 820, 620));
        window.setResizable(false);
        GridPane boardView = getChessboardGrid(window);
        layout.getChildren().addAll(boardView, rightMenu);

        window.show();
    }

    private GridPane getChessboardGrid(Stage window) {
        ChessboardModel chessboardModel = new ChessboardModel();
        ChessboardView chessboardView = new ChessboardView(chessboardModel);
        GridPane boardView = chessboardView.getChessboardGrid();
        boardView.prefWidthProperty().bind(window.widthProperty().subtract(200));
        PieceFactory pieceFactory = new PieceFactory(chessboardModel, chessboardView);
        pieceFactory.placePieces( true);
        return boardView;
    }

    private void closeWindow(Stage window) {
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
