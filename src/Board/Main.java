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
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.layout.*;
import javafx.scene.shape.*;

public class Main extends Application {

    private GridPane chessboard = new GridPane();
    final int size = 8;


    @Override
    public void start(Stage window) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));

        window.setTitle("Wolf and Sheep - Chessboard game");
        //window.setOnCloseRequest(event -> );

        chessboard.setPadding(new Insets(10,10,10,10));

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                Rectangle square = new Rectangle();
                Color color;
                if ((row + col) % 2 == 0) color = Color.BISQUE;
                else color = Color.web("#383838");
                square.setFill(color);
                chessboard.add(square, col, row);
                square.widthProperty().bind(chessboard.widthProperty().divide(size).subtract(10));
                square.heightProperty().bind(chessboard.heightProperty().divide(size).subtract(10));
            }
        }

        window.setScene(new Scene(chessboard, 800, 600));
        window.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
