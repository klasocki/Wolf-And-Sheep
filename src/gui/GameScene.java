package gui;

import game.GameController;
import game.GameOverObserver;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GameScene implements GameOverObserver {
    Stage window;
    public void display() {
        window = prepareStage();
        GameController gameController = GameController.initGame(true);
        gameController.addObserver(this);
        GridPane boardView = getChessboardGrid(window, gameController);
        HBox layout = prepareLayout(gameController, boardView);
        window.setScene(new Scene(layout, 820, 620));
        window.show();
    }

    private HBox prepareLayout(GameController gameController, GridPane boardView) {
        HBox layout = new HBox();
        layout.setPadding(new Insets(10, 0, 10, 10));
        VBox rightMenu = new VBox(30);
        addButtons(gameController, rightMenu);
        rightMenu.setPadding(new Insets(20,0,20,20));
        rightMenu.setAlignment(Pos.BASELINE_RIGHT);
        layout.getChildren().addAll(boardView, rightMenu);
        return layout;
    }

    private void addButtons(GameController gameController, VBox rightMenu) {
        Button undoButton = new Button("Undo");
        Button restartButton = new Button("Restart");
        Button quitButton = new Button("Back to menu");
        quitButton.setMinHeight(50);
        undoButton.minHeightProperty().bind(quitButton.minHeightProperty());
        undoButton.prefWidthProperty().bind(quitButton.widthProperty());
        restartButton.minHeightProperty().bind(quitButton.minHeightProperty());
        restartButton.prefWidthProperty().bind(quitButton.widthProperty());

        undoButton.setOnAction(event -> gameController.undoLastMove());
        restartButton.setOnAction(event -> {
            if (ConfirmationBox.display("Restarting game",
                    "Are you sure you want to restart? Game progress will be lost")) {
                restart();
            }
        });

        rightMenu.getChildren().addAll(undoButton, restartButton, quitButton);
    }

    private Stage prepareStage() {
        Stage window = new Stage();
        window.setTitle("Wolf and Sheep - Chessboard game");
        window.setResizable(false);
        window.setOnCloseRequest(event -> {
            event.consume();
            closeWindows();
        });
        return window;
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

    @Override
    public void wolfHasWon() {
        GameOverBox.display("Game Over", "The Wolf has won!!!");
        restart();
    }

    @Override
    public void sheepHaveWon() {
        GameOverBox.display("Game Over", "The Sheep have won!!!");
        restart();
    }

    private void restart() {
        this.window.close();
        this.display();
    }
}
