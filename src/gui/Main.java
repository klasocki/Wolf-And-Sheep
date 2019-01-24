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

package gui;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage window) {
        GameScene gameScene = new GameScene();
        gameScene.display();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
