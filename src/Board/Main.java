/*
This game is made by Karol Lasocki, 2018. All rights reserved
It's a computer version of the "Wolf and Sheep" chessboard game, featuring a simple GUI
I create it for learning
DONE Make it playable
TODO Refactor!!!!!
TODO Make the game handle turns
TODO Add winning messages
TODO Use factory design pattern to create Pieces
TODO Add undo and other control buttons
TODO Use images of pieces
TODO make an android distribution
TODO Add artificial intelligence
TODO Make AI intelligent. Use machine learning
 */

package Board;

import Pieces.Piece;
import Pieces.Sheep;
import Pieces.Wolf;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage window) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        window.setTitle("Wolf and Sheep - Chessboard game");
        //window.setOnCloseRequest(event -> );
        Chessboard chessboard = Chessboard.getInstance();
        GridPane boardView = ChessboardView.draw();
        boardView.prefWidthProperty().bind(window.widthProperty().subtract(200));
        HBox layout = new HBox();
        layout.setPadding(new Insets(10, 10, 10, 10));
        VBox rightMenu = new VBox();
        layout.getChildren().addAll(boardView, rightMenu);
        window.setScene(new Scene(layout, 820, 620));
        window.setResizable(false);
        Piece wolf = new Wolf();
        wolf.placePiece(0, 1);
        Piece sheepOne = new Sheep(true);
        Piece sheepTwo = new Sheep(true);
        Piece sheepThree = new Sheep(true);
        Piece sheepFour = new Sheep(true);
        sheepOne.placePiece(7, 0);
        sheepTwo.placePiece(7, 2);
        sheepThree.placePiece(7, 4);
        sheepFour.placePiece(7, 6);
        Controller.addEventHandlers(sheepOne);
        Controller.addEventHandlers(sheepTwo);
        Controller.addEventHandlers(sheepThree);
        Controller.addEventHandlers(sheepFour);
        Controller.addEventHandlers(wolf);

        window.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
