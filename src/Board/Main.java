/*
This game is made by Karol Lasocki, 2018. All rights reserved
It's a computer version of the "Wolf and Sheep" chessboard game, featuring a simple GUI
I create it for learning
TODO Make it playable
TODO Refactor
TODO Use images of pawnes
TODO Add artifitial intelligence
TODO Make AI intelligent. Use machine learning
 */

package Board;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage window) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        window.setTitle("Wolf and Sheep - Chessboard game");
        //window.setOnCloseRequest(event -> );
        Chessboard chessboard = Chessboard.getInstance();
        GridPane boardView = chessboard.draw(Color.BISQUE, Color.rgb(38, 38, 38));
        boardView.prefWidthProperty().bind(window.widthProperty().subtract(200));
        HBox layout = new HBox();
        layout.setPadding(new Insets(10, 10, 10, 10));
        VBox rightMenu = new VBox();
        layout.getChildren().addAll(boardView, rightMenu);
        window.setScene(new Scene(layout, 820, 620));
        window.setResizable(false);

        window.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
